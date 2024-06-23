package com.springboot.webServices;


import com.springboot.webServicesVO.ListResponse;
import com.springboot.webServicesVO.MacBookRequest;
import com.springboot.webServicesVO.MacBookResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MackBookService {

    private static final String BASE_URL = "https://api.restful-api.dev/objects";
    //Ref: https://restful-api.dev/

    @Autowired
    private RestTemplate restTemplate;

    public MacBookResponse getById(String id) {
        return restTemplate.getForObject(BASE_URL + "/" + id, MacBookResponse.class);
    }

    public MacBookResponse addData(MacBookRequest request) {
        return restTemplate.postForObject(BASE_URL, request, MacBookResponse.class);
    }

    public ListResponse getByParam(String id) {
        return null;
    }

    public void updateData(MacBookRequest request, String id) {
        restTemplate.put(BASE_URL + "/" + id, request);
    }

    public void delete(String id) {
        restTemplate.delete(BASE_URL + "/" + id);
    }


}
