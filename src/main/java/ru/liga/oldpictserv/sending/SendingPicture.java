package ru.liga.oldpictserv.sending;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import ru.liga.oldpictserv.sending.exception.CantEncodingImageToBase64Excepted;

import java.io.File;
import java.io.IOException;

@Service
@Slf4j
public class SendingPicture {
    /**
     * Хранимые файлы
     */

    public byte[] getImageBase64() {
        try {
            return FileUtils.readFileToByteArray(new File("temp/image.jpg"));
        } catch (IOException e) {
            log.error(e.getMessage(), e);
            throw new CantEncodingImageToBase64Excepted();
        }
    }


}
