package com.portofrotterdam.contract.demo.springcloudconsumer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class BoatClient {

    private final RestTemplate restTemplate;

    public ResponseEntity<Boat> getBoat(final int port, final int id) {
        String boatResource
                = "http://localhost:" + port + "/api/boats/{id}";

        Map<String, String> params = new HashMap<>();
        params.put("id", String.valueOf(id));

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(boatResource)
                .buildAndExpand(params)
                .encode()
                .toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Boat> requestEntity = new HttpEntity<>(headers);

        return restTemplate.exchange(
                urlTemplate, HttpMethod.GET, requestEntity, Boat.class);
    }

    public ResponseEntity<BoatsResponse> getBoats(int port) {
        String boatResource
                = "http://localhost:" + port + "/api/boats/";

        String urlTemplate = UriComponentsBuilder.fromHttpUrl(boatResource)
                .encode()
                .toUriString();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<Boat> requestEntity = new HttpEntity<>(headers);



        return restTemplate.exchange(
                urlTemplate, HttpMethod.GET, requestEntity, BoatsResponse.class);
    }
}
