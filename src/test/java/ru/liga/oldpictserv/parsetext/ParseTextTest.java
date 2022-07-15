package ru.liga.oldpictserv.parsetext;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParseTextTest {

    @Test
    void getLineEntityListByText() {
        ParseText parseText = new ParseText();
        parseText.getLineEntityListByText("");
    }
}