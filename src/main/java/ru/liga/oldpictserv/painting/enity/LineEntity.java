package ru.liga.oldpictserv.painting.enity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextLayout;
import java.util.LinkedList;
import java.util.List;

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
    private List<TextLayout> textLayoutsList = new LinkedList<>();
    /**
     * Описание текста
     */
    private String descriptor;
    /**
     * Высота текста
     */
    private float high;

    public void addTextLayout(TextLayout textLayouts) {
        if(this.textLayoutsList==null){
            this.textLayoutsList = new LinkedList<>();
            this.high = 0;
        }
        this.textLayoutsList.add(textLayouts);
        this.high += textLayouts.getAscent() + textLayouts.getDescent() + textLayouts.getLeading();

    }
}
