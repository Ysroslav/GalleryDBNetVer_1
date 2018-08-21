package ru.bodrov.gallery.listener;

import ru.bodrov.gallery.event.SyncEvent;

import javax.ejb.Stateless;
import javax.enterprise.event.Observes;
import java.util.logging.Logger;

@Stateless
public class SyncListener {

    private static final Logger LOGGER = Logger.getLogger(SyncListener.class.getSimpleName());

    public void observe(@Observes SyncEvent event) {
        LOGGER.info("[SYNC] OBSERVE TREAD ID: "+Thread.currentThread().getId());
    }
}
