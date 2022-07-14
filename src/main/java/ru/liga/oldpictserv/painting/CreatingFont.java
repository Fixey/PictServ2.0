package ru.liga.oldpictserv.painting;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.liga.oldpictserv.painting.enity.LineEntity;

import java.awt.*;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

import static ru.liga.oldpictserv.constant.ConstantUtil.*;

/**
 * Создание шрифта
 */
@Service
@Slf4j
public class CreatingFont {
    private Font mainFontB;
    private Font mainFont;

    public Font getMainFontB() {
        return mainFontB;
    }

    public void setMainFontB(Font mainFontB) {
        this.mainFontB = mainFontB;
    }

    public Font getMainFont() {
        return mainFont;
    }

    public void setMainFont(Font mainFont) {
        this.mainFont = mainFont;
    }

    public CreatingFont() {
        try {
            Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getResourceAsStream(OLDSTANDART_BOLD_PATH)));
            this.mainFontB = new Font("Old Standard TT", Font.BOLD, DEF_FONT_BOLD);
            Font.createFont(Font.TRUETYPE_FONT, Objects.requireNonNull(getClass().getResourceAsStream(OLDSTANDART_REG_PATH)));
            this.mainFont = new Font("Old Standard TT", Font.PLAIN, DEF_FONT_REG);
        } catch (FontFormatException | IOException e) {
            log.error(e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }

    /**
     * Заполнение сущности линий Шрифтами
     *
     * @param lineEntityList List<LineEntity> список линий
     */
    public void fillLinesEntityByMainFont(List<LineEntity> lineEntityList) {
        for (LineEntity lineEntity : lineEntityList) {
            if (lineEntity.getDescriptor().equals("body")) {
                lineEntity.setFont(mainFont);
            }
            if (lineEntity.getDescriptor().equals("header")) {
                lineEntity.setFont(mainFontB);
            }
        }
    }
}
