package com.bass.dms.server.dynamicentities.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DynamicEntityRequest {
    private String columnName;
    private String columnType;
}
