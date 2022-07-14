package ru.liga.oldpictserv.painting.enity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextLayout;

/**
 * Сущность текста
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
@Builder
public class LineEntity {
    /**
     * Текст
     */
    private String text;
    /**
     * Шрифт текста
     */
    private Font font;
    /**
     * Класс для работы с стилями текста
     */
    private LineBreakMeasurer lineBreakMeasurer;
    /**
     * Слои текста
     */
    private TextLayout textLayout;
    /**
     * Описание текста
     */
    private String descriptor;
    /**
     * Высота текста
     */
    private float high;

    public void setTextLayout(TextLayout textLayout) {
        this.textLayout = textLayout;
        this.high = textLayout.getAscent() + textLayout.getDescent() + textLayout.getLeading();
    }
}
