package ru.liga.oldpictserv.sending;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

@Service
public class SendingPicture {
    /**
     * Хранимые файлы
     */

    public String getImageBase64() {
        try {
            byte[] fileContent = FileUtils.readFileToByteArray(new File("temp/image.jpg"));
            return Base64.getEncoder().encodeToString(fileContent);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
