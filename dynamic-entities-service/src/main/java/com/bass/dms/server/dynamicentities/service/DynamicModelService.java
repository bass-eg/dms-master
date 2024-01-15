package com.bass.dms.server.dynamicentities.service;

import com.bass.dms.server.dynamicentities.entity.DynamicEntityRequest;
import jakarta.transaction.Transactional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DynamicModelService {
    private final SessionFactory sessionFactory;
    //    private final DynamicRepository dynamicRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public DynamicModelService(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Transactional
    public void test() {
        Session s = this.sessionFactory.openSession();
        Map<String, Object> david = new HashMap<>();
        david.put("name", "David");
        Map<String, Object> mostafa = new HashMap<>();
        mostafa.put("name", "Mostafa");
        s.save("Test", david);
        s.save("Test", mostafa);
        s.close();

    }

    @Transactional
    public void createXML(String entityName, List<DynamicEntityRequest> requestList) {
        try {
            // Create a new Document
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.newDocument();

            // Create the root element <hibernate-mapping>
            Element hibernateMapping = doc.createElement("hibernate-mapping");
            doc.appendChild(hibernateMapping);

            // Create the <class> element with entity-name=entityName
            Element clazz = doc.createElement("class");
            clazz.setAttribute("entity-name", entityName);
            hibernateMapping.appendChild(clazz);

            // Create the <id> element
            Element id = doc.createElement("id");
            id.setAttribute("name", "id");
            id.setAttribute("type", "long");
            id.setAttribute("column", "id");
            clazz.appendChild(id);

            // Create the <generator> element
            Element generator = doc.createElement("generator");
            generator.setAttribute("class", "identity");
            id.appendChild(generator);

            createProperty(doc, clazz, requestList);

            // Write the XML content to a file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(doc);
            String resourcesPath = new File("dynamic-entities-service/src/main/resources/dynamic-entities").getAbsolutePath();
            String xmlFilePath = resourcesPath + File.separator + entityName + ".hbm.xml";
//            Path path = Paths.get(xmlFilePath);
//            if(Files.exists(path)){
//                System.out.println("FILES EXISTS");
//            }
//            System.out.println(resourcesPath);
            StreamResult result = new StreamResult(new File(xmlFilePath));

            transformer.transform(source, result);

            System.out.println("XML file generated successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createProperty(Document doc, Element clazz, List<DynamicEntityRequest> requestList) {
        for (DynamicEntityRequest dynamicEntityRequest : requestList) {

            switch (dynamicEntityRequest.getColumnType().toLowerCase()) {
                case "string": {
                    createPropertyDependingOnType(doc, clazz, dynamicEntityRequest.getColumnName(), "string");
                    break;
                }
                case "long": {
                    createPropertyDependingOnType(doc, clazz, dynamicEntityRequest.getColumnName(), "long");
                    break;
                }
                case "int": {
                    createPropertyDependingOnType(doc, clazz, dynamicEntityRequest.getColumnName(), "int");
                    break;
                }
                case "boolean": {
                    createPropertyDependingOnType(doc, clazz, dynamicEntityRequest.getColumnName(), "boolean");
                    break;
                }
                default: {
                    System.out.println("Unhandled type");
                    break;
                }
            }
        }
    }

    private void createPropertyDependingOnType(Document doc, Element clazz, String columnName, String columnType) {
        Element property = doc.createElement("property");
        property.setAttribute("name", columnName);
        property.setAttribute("column", columnName);
        property.setAttribute("type", columnType);
        clazz.appendChild(property);
    }

//    @Transactional
//    public List<Object> findAll(String entityClassName, String column, String matching) {
//        List<Map<String, Object>> result = jdbcTemplate.queryForList("SELECT * FROM " + entityClassName + " WHERE " + column + " LIKE '%" + matching + "%'");
//        result.forEach(System.out::println);
//        return dynamicRepository.findAll(entityClassName);
//    }
}