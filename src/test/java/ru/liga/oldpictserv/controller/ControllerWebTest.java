package ru.liga.oldpictserv.controller;

import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
//@AutoConfigureMockMvc
public class ControllerWebTest {

    @Test
    public void givenDataIsJson_whenDataIsPostedByPostForObject_thenResponseBodyIsNotNull()
            throws IOException {
        String createPersonUrl = "http://localhost:8080/pict";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject personJsonObject = new JSONObject();
        personJsonObject.put("text", "John is Сударь");
        HttpEntity<String> request =
                new HttpEntity<>(personJsonObject.toString(), headers);

        String personResultAsJsonStr =
                restTemplate.postForObject(createPersonUrl, request, String.class);
        assertNotNull(personResultAsJsonStr);
    }
}