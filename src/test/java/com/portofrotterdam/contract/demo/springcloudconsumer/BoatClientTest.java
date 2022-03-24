package com.portofrotterdam.contract.demo.springcloudconsumer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureJsonTesters
@AutoConfigureStubRunner(stubsMode = StubRunnerProperties.StubsMode.LOCAL, ids = "com.example.producer.scc:spring-cloud-producer:8080")
public class BoatClientTest {

    @Autowired
    private BoatClient boatClient;

    @Test
    public void should_give_a_boat_response() {
        ResponseEntity<Boat> boat = boatClient.getBoat(8080, 1);

        Boat body = boat.getBody();
        assertThat(body).isNotNull();
        assertThat(body.getName()).isEqualTo("YellowSubmarine");
    }

    @Test
    public void should_give_a_list_of_boats_response() {
        ResponseEntity<BoatsResponse> response = boatClient.getBoats(8080);

        BoatsResponse boatsResponse = response.getBody();
        assertThat(boatsResponse).isNotNull();
        assertThat(boatsResponse.getBoats()).hasSize(3);
    }

}
