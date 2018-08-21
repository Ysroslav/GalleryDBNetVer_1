package ru.bodrov.gallery.dao;


import ru.bodrov.gallery.entity.TblEntityEntity;
import ru.bodrov.gallery.entity.TblLogEntity;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote
@Stateless
public class LogDAO extends AbstractDAO {

    public void start() {
        em.persist(new TblLogEntity("APP STARTED"));
    }

    public void save(TblEntityEntity entity){em.persist(new TblLogEntity("SAVE - " + entity.getId() + " - " + entity.getCreated()));}
    public void remove(TblEntityEntity entity){em.persist(new TblLogEntity("REMOVE - " + entity.getId() + " - " + entity.getCreated()));}

    public void stopped() {
        em.persist(new TblLogEntity("APP STOPPED"));
    }

    public void testRollbackRTE() {
        em.persist(new TblLogEntity("testRollbackRTE"));
        throw new RuntimeException("testRollbackRTE");
    }

    public void testRollbackCatchRTE() {
        em.persist(new TblLogEntity("testRollbackCatchRTE"));
        try {
            throw new RuntimeException("testRollbackCatchRTE");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
