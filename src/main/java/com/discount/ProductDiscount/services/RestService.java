package com.discount.ProductDiscount.services;

import com.discount.ProductDiscount.model.Group;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Component
public class RestService {

    private String uri = "http://localhost:8080";

    public List<Group> getGroups() {
        ResponseEntity<List<Group>> response = new RestTemplate().exchange(
                uri + "/getGroupList",
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Group>>() {
                });
        List<Group> groups = response.getBody();
        return groups;
    }

    public Optional<Group> getDiscountByUser(int groupId) {

        String url = uri + "/getDiscountByGroup/" + groupId;
        ResponseEntity<Optional<Group>> response = new RestTemplate().exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Optional<Group>>() {
                });
        Optional<Group> groups = response.getBody();
        return groups;
    }
}
