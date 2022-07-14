package ru.liga.oldpictserv.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ru.liga.oldpictserv.controller.entity.TextEntity;
import ru.liga.oldpictserv.painting.CreatePicture;
import ru.liga.oldpictserv.sending.SendingPicture;

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
    @ResponseBody
    public byte[] sendImage(TextEntity textEntity) {
        log.info("Receive POST Request");
        createPicture.createPicture(textEntity.getText());
        log.info("Send Response from POST Request");
        return sendingPicture.getImageBase64();
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
