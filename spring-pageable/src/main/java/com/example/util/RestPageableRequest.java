package com.example.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestPageableRequest {
    private int pageNumber;
    private int pageSize;
    private String columnName;
    private boolean asc;
}
