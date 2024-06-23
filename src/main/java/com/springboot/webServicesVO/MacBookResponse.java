package com.springboot.webServicesVO;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
public class MacBookResponse {

    private String id;
    private String name;
    private Data data;
    private String createdAt;
}
