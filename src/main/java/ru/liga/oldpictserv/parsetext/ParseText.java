package ru.liga.oldpictserv.parsetext;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.liga.oldpictserv.painting.enity.LineEntity;
import ru.liga.oldpictserv.parsetext.exception.CantParseTextException;

import java.util.LinkedList;
import java.util.List;

@Service
@Slf4j
public class ParseText {
    /**
     * Распарсить текст
     *
     * @param text текст
     * @return Map<String, String> распарсинный текст
     * @throws CantParseTextException когда не может распарсить
     */
    public List<LineEntity> getLineEntityListByText(String text) {
        try {
            log.debug("parse text:{}", text);
            String header, body;
            if (text.contains("\n")) {
                header = text.split("\n")[0];
            } else {
                header = text.split(" ")[0];
            }
            body = text.substring(header.length()).trim();
            List<LineEntity> lineEntityList = new LinkedList<>();
            lineEntityList.add(new LineEntity().builder().text(header).descriptor("header").build());
            lineEntityList.add(new LineEntity().builder().text(body).descriptor("body").build());
            log.debug("finish parse and get lineEntityList:{}", lineEntityList);
            return lineEntityList;
        } catch (NullPointerException | IndexOutOfBoundsException e) {
            throw new CantParseTextException();
        }
    }
}
