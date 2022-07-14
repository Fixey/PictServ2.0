package ru.liga.oldpictserv.controller;

import ru.liga.oldpictserv.painting.CreatePicture;
import ru.liga.oldpictserv.sending.SendingPicture;

//@ShellComponent
public class ShellController {
    private final CreatePicture createPicture;
    private final SendingPicture sendingPicture;

    //        @Autowired
    public ShellController(CreatePicture createPicture, SendingPicture sendingPicture) {
        this.createPicture = createPicture;
        this.sendingPicture = sendingPicture;
    }

    //    @ShellMethod("Create pict")
    public void conv(String text) {
        createPicture.createPicture(text);

    }
}
