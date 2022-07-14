package ru.liga.oldpictserv.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.minidev.json.JSONObject;
import org.junit.BeforeClass;
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
    public static String createPersonUrl;
    public static String updatePersonUrl;
    public static HttpHeaders headers;
    public static RestTemplate restTemplate;
    public static JSONObject personJsonObject;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeClass
    public static void runBeforeAllTestMethods() {
        createPersonUrl = "http://localhost:8080/pict";
//        updatePersonUrl = "http://localhost:8082/spring-rest/updatePerson";

        restTemplate = new RestTemplate();
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        personJsonObject = new JSONObject();
        personJsonObject.put("text", "John is Сударь");
    }

    @Test
    public void givenDataIsJson_whenDataIsPostedByPostForObject_thenResponseBodyIsNotNull()
            throws IOException {
        createPersonUrl = "http://localhost:8080/pict";
//        updatePersonUrl = "http://localhost:8082/spring-rest/updatePerson";

        restTemplate = new RestTemplate();
        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        personJsonObject = new JSONObject();
        personJsonObject.put("text", "John is Сударь");
        HttpEntity<String> request =
                new HttpEntity<>(personJsonObject.toString(), headers);

        String personResultAsJsonStr =
                restTemplate.postForObject(createPersonUrl, request, String.class);
        assertNotNull(personResultAsJsonStr);

    }
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    public void noParamGreetingShouldReturnDefaultMessage() throws Exception {
//
//        this.mockMvc.perform(get("/pict")).andDo(print()).andExpect(status().isOk())
//                .andExpect(jsonPath("$.content").value("Hello World"));
//    }
//
//    @Test
//    public void paramGreetingShouldReturnTailoredMessage() throws Exception {
//
//        this.mockMvc.perform(get("/todo").param("name", "Spring Community"))
//                .andDo(print()).andExpect(status().isOk())
//                .andExpect(jsonPath("$.content").value("Hello, Spring Community!"));
//    }

}