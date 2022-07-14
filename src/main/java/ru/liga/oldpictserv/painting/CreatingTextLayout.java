package ru.liga.oldpictserv.painting;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.liga.oldpictserv.painting.enity.LineEntity;

import java.awt.font.LineBreakMeasurer;
import java.awt.font.TextLayout;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CreatingTextLayout {
    /**
     * Заполнить сущность линий слоями для строк
     *
     * @param lineEntityList список сущностей линий
     * @param breakWidth     шинира картинки
     */
    public void fillLineEntityByTextLayout(List<LineEntity> lineEntityList,
                                           float breakWidth) {
        log.debug("fill line Entity by TextLayout.LineEntity={}", lineEntityList);
        for (LineEntity lineEntity : lineEntityList) {
            LineBreakMeasurer line = lineEntity.getLineBreakMeasurer();
            lineEntity.setTextLayoutsList(new LinkedList<>());
            lineEntity.setHigh(0);
            while (line.getPosition() < lineEntity.getText().length()) {
                TextLayout textLayout = line.nextLayout(breakWidth);
                lineEntity.addTextLayout(textLayout);
            }
        }
        log.debug("After filling line Entity by TextLayout.lineEntityList={}", lineEntityList);
    }
}
