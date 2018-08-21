package ru.bodrov.gallery.controller;


import ru.bodrov.gallery.manager.EventManager;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.logging.Logger;

@ViewScoped
@ManagedBean
public class EventController {

    private static final Logger LOGGER = Logger.getLogger(EventController.class.getSimpleName());

    @Inject
    private EventManager eventManager;

    public void sync() {
        LOGGER.info("[SYNC] TREAD ID: "+Thread.currentThread().getId());
        eventManager.sync();
    }

    public void async() {
        LOGGER.info("[ASYNC] TREAD ID: "+Thread.currentThread().getId());
        eventManager.async();
    }

}
