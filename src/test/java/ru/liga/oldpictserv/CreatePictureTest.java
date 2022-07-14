package ru.liga.oldpictserv;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.liga.oldpictserv.painting.*;
import ru.liga.oldpictserv.parsetext.ParseText;
import ru.liga.oldpictserv.sending.SendingPicture;

@SpringBootTest
class CreatePictureTest {
    final private CreatingFont creatingFont;
    final private ParseText parseText;
    final private CreatingTextLayout creatingTextLayout;
    final private CreatingLineBreakMeasurer creatingLineBreakMeasurer;
    final private ChoosingFont choosingFont;

    @Autowired
    public CreatePictureTest(CreatingFont creatingFont, ParseText parseText, CreatingTextLayout creatingTextLayout, CreatingLineBreakMeasurer creatingLineBreakMeasurer, ChoosingFont choosingFont, AttributeText attributeText, SendingPicture sendingPicture) {
        this.creatingFont = creatingFont;
        this.parseText = parseText;
        this.creatingTextLayout = creatingTextLayout;
        this.creatingLineBreakMeasurer = creatingLineBreakMeasurer;
        this.choosingFont = choosingFont;
    }

    @Test
    void createPicture() {
        String text = "Many people believe that Vincent van Gogh painted his best works " +
                "during the two-year period he spent in Provence. Here is where he " +
                "painted The Starry Night--which some consider to be his greatest " +
                "work of all. However, as his artistic brilliance reached new " +
                "kjhjkhjk heights in Provence, his physical and mental health plummeted." +
                "heights in Provence, his physical and mental health plummeted.";
        new CreatePicture(creatingFont, parseText, creatingTextLayout,
                creatingLineBreakMeasurer, choosingFont).createPicture(text);
    }
}