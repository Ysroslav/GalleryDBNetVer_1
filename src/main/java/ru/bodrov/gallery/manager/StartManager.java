package ru.bodrov.gallery.manager;

import ru.bodrov.gallery.dao.LogDAO;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import java.util.logging.Logger;

public class StartManager {

    private static final Logger LOGGER = Logger.getLogger(StartManager.class.getSimpleName());

    @Inject
    private LogDAO logDAO;

    @PostConstruct
    public void init() {
        LOGGER.info("Application started...");
        logDAO.start();
    }

    @PreDestroy
    public void destroy() {
        LOGGER.info("Application stopped...");
        logDAO.stopped();
    }

}
