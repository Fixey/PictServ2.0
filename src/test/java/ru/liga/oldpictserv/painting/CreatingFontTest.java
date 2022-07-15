package ru.liga.oldpictserv.painting;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.liga.oldpictserv.entity.LineEntity;
import ru.liga.oldpictserv.enums.TextType;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class CreatingFontTest {
    private final CreatingFont creatingFont;

    @Autowired
    CreatingFontTest(CreatingFont creatingFont) {
        this.creatingFont = creatingFont;
    }

    @Test
    void fillLinesEntityByFontTest() {
        List<LineEntity> lineEntityList = new LinkedList<>();
        lineEntityList.add(new LineEntity().builder().descriptor(TextType.header).text("textheader").build());
        lineEntityList.add(new LineEntity().builder().descriptor(TextType.body).text("textbody").build());
        creatingFont.fillLinesEntityByMainFont(lineEntityList);
        for (LineEntity lineEntity : lineEntityList) {
            if (lineEntity.getDescriptor().equals("body")) {
                assertEquals(lineEntity.getFont(), creatingFont.getMainFont());
            } else {
                assertEquals(lineEntity.getFont(), creatingFont.getMainFontB());

            }
        }
    }
}