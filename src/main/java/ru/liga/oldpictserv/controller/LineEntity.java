package ru.liga.oldpictserv.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextLayout;
import java.text.AttributedString;

/**
 * Сущность текста
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Component
public class LineEntity {
    private String text;
    private Font font;
    private AttributedString attributeText;
    private LineBreakMeasurer lineBreakMeasurer;
    private TextLayout textLayout;
}
