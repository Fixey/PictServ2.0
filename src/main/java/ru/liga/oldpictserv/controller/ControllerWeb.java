package ru.liga.oldpictserv.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.liga.oldpictserv.controller.entity.TextEntity;
import ru.liga.oldpictserv.painting.CreatePicture;
import ru.liga.oldpictserv.sending.SendingPicture;

import java.io.InputStream;

/**
 * Контроллер
 */
@Slf4j
@RestController
public class ControllerWeb {
    final private SendingPicture sendingPicture;
    final private CreatePicture createPicture;

    @Autowired
    public ControllerWeb(SendingPicture sendingPicture, CreatePicture createPicture) {
        this.sendingPicture = sendingPicture;
        this.createPicture = createPicture;
    }

    /**
     * POST Request
     *
     * @param textEntity текст
     * @return String Картинка
     */
    @PostMapping(value = "/pict")
    public @ResponseBody String sendImage(@RequestBody TextEntity textEntity) {
//        log.info("Receive POST Request");
//        createPicture.createPicture(textEntity.getText());
//        log.info("Send Response from POST Request");
        return getClass().getClassLoader().getResource("logback.xml").getPath();
    }

    /**
     * GET Request
     *
     * @return Ответ
     */
    @GetMapping
    public String getUrl() {
        log.info("Receive GET Request");
        return "Чё надо, холоп?";
    }
}
