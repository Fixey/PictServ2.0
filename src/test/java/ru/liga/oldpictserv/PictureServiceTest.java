package ru.liga.oldpictserv;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.liga.oldpictserv.entity.TempImageEntity;
import ru.liga.oldpictserv.painting.*;
import ru.liga.oldpictserv.parsetext.ParseText;

@SpringBootTest
class PictureServiceTest {
    private final CreatingFont creatingFont;
    private final ParseText parseText;
    private final CreatingTextLayout creatingTextLayout;
    private final CreatingLineBreakMeasurer creatingLineBreakMeasurer;
    private final ChoosingFont choosingFont;
    private final TempImageEntity tempImageEntity;

    @Autowired
    public PictureServiceTest(CreatingFont creatingFont, ParseText parseText, CreatingTextLayout creatingTextLayout, CreatingLineBreakMeasurer creatingLineBreakMeasurer, ChoosingFont choosingFont, TempImageEntity tempImageEntity) {
        this.creatingFont = creatingFont;
        this.parseText = parseText;
        this.creatingTextLayout = creatingTextLayout;
        this.creatingLineBreakMeasurer = creatingLineBreakMeasurer;
        this.choosingFont = choosingFont;
        this.tempImageEntity = tempImageEntity;
    }

    @Test
    void createPicture() {
        String text = "Many people believe that Vincent van Gogh painted his best works " +
                "during the two-year period he spent in Provence. Here is where he " +
                "painted The Starry Night--which some consider to be his greatest " +
                "work of all. However, as his artistic brilliance reached new " +
                "kjhjkhjk heights in Provence, his physical and mental health plummeted." +
                "heights in Provence, his physical and mental health plummeted.";
        new PictureService(creatingFont, parseText, creatingTextLayout,
                creatingLineBreakMeasurer, choosingFont, tempImageEntity).createPicture(text);
    }
}