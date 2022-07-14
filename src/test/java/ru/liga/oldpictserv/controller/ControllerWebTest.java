package ru.liga.oldpictserv.controller;

import net.minidev.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;
import ru.liga.oldpictserv.painting.ChoosingFont;
import ru.liga.oldpictserv.painting.CreatingFont;
import ru.liga.oldpictserv.painting.CreatingLineBreakMeasurer;
import ru.liga.oldpictserv.painting.CreatingTextLayout;
import ru.liga.oldpictserv.painting.enity.LineEntity;
import ru.liga.oldpictserv.parsetext.ParseText;
import ru.liga.oldpictserv.sending.SendingPicture;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
//@AutoConfigureMockMvc
public class ControllerWebTest {
    final private CreatingFont creatingFont;
    final private ParseText parseText;
    final private CreatingTextLayout creatingTextLayout;
    final private CreatingLineBreakMeasurer creatingLineBreakMeasurer;
    final private ChoosingFont choosingFont;
    final private SendingPicture sendingPicture;
    private List<LineEntity> lineEntityList = new LinkedList();


    @Autowired
    public ControllerWebTest(CreatingFont creatingFont, ParseText parseText, CreatingTextLayout creatingTextLayout, CreatingLineBreakMeasurer creatingLineBreakMeasurer, ChoosingFont choosingFont, SendingPicture sendingPicture) {
        this.creatingFont = creatingFont;
        this.parseText = parseText;
        this.creatingTextLayout = creatingTextLayout;
        this.creatingLineBreakMeasurer = creatingLineBreakMeasurer;
        this.choosingFont = choosingFont;
        this.sendingPicture = sendingPicture;
    }

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