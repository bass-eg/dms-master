package com.bass.dms.server.elasticsearch.utils;


import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * A utility class that encrypts or decrypts a file.
 *
 * @author www.codejava.net
 */
public class CryptoUtils implements Serializable {

    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";
    private static String encKey = "Cc8kCQ3Yba+YJAFAuZQtWw==";

    public static void encrypt(String key, File inputFile, File outputFile)
            throws CryptoException {
//        doCrypto(Cipher.ENCRYPT_MODE, key, inputFile, outputFile);
    }

    public static FileInputStream decrypt(File inputFile)
            throws CryptoException {
        return decrypto(Cipher.DECRYPT_MODE, Base64.getDecoder().decode(encKey), inputFile);
    }

    public static String encrypt(File inputFile, File outputFile)
            throws CryptoException {
        try {
            // Create a KeyGenerator instance for AES
//            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
//
//            // Initialize the KeyGenerator with the desired key size (128 bits for AES)
//            keyGen.init(128); // Change this to 192 or 256 for other key sizes
//
//            // Generate the AES key
//            SecretKey secretKey = keyGen.generateKey();

//            encKey = Base64.getEncoder().encodeToString(secretKey.getEncoded());


            byte[] decode = Base64.getDecoder().decode(encKey);
            doCrypto(Cipher.ENCRYPT_MODE, decode, inputFile, outputFile);
            return encKey;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    private static void doCrypto(int cipherMode, byte[] key, File inputFile,
                                 File outputFile) throws CryptoException {
        try {
            Key secretKey = new SecretKeySpec(key, ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(cipherMode, secretKey);

            FileInputStream inputStream = new FileInputStream(inputFile);
            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);

            byte[] outputBytes = cipher.doFinal(inputBytes);

            FileOutputStream outputStream = new FileOutputStream(outputFile);
            outputStream.write(outputBytes);

            inputStream.close();
            outputStream.close();

        } catch (NoSuchPaddingException | NoSuchAlgorithmException
                 | InvalidKeyException | BadPaddingException
                 | IllegalBlockSizeException | IOException ex) {
            throw new CryptoException("Error encrypting/decrypting file", ex);
        }
    }

    private static FileInputStream decrypto(int cipherMode, byte[] key, File inputFile) throws CryptoException {
        try {
            Key secretKey = new SecretKeySpec(key, ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORMATION);
            cipher.init(cipherMode, secretKey);

            FileInputStream inputStream = new FileInputStream(inputFile);
            byte[] inputBytes = new byte[(int) inputFile.length()];
            inputStream.read(inputBytes);

            byte[] outputBytes = cipher.doFinal(inputBytes);
            File tempFile = File.createTempFile("temp", ".tmp");

            FileOutputStream outputStream = new FileOutputStream(tempFile);
            outputStream.write(outputBytes);

            inputStream.close();
            outputStream.close();
            FileInputStream input = new FileInputStream(tempFile);
            return input;

        } catch (NoSuchPaddingException | NoSuchAlgorithmException
                 | InvalidKeyException | BadPaddingException
                 | IllegalBlockSizeException | IOException ex) {
            throw new CryptoException("Error encrypting/decrypting file", ex);
        }
    }
}