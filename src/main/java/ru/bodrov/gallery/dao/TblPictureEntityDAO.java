package ru.bodrov.gallery.dao;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bodrov.gallery.entity.TblClientEnt;
import ru.bodrov.gallery.entity.TblPictureEntity;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class TblPictureEntityDAO extends AbstractDAO {

    public TblPictureEntity findOne(String id) {
        return em.find(TblPictureEntity.class, id);
    }

    @NotNull
    public List<TblPictureEntity> getPictures() {
        return em.createQuery("SELECT e FROM TblPictureEntity e ORDER BY e.dateInput DESC", TblPictureEntity.class).getResultList();
    }

    @Nullable
    public TblPictureEntity getPicturesById(@Nullable final String pictureId) {
        if (pictureId == null || pictureId.isEmpty()) return null;
        return getEntity(em.createQuery("SELECT e FROM TblPictureEntity e WHERE e.id = :id", TblPictureEntity.class)
                .setParameter("id", pictureId)
                .setMaxResults(1));
    }

    @Nullable
    public TblPictureEntity persist(@Nullable final TblPictureEntity picture) {
        if (picture == null) return null;
        em.persist(picture);
        return picture;
    }

    @Nullable
    public TblPictureEntity merge(@Nullable final TblPictureEntity picture) {
        if (picture == null) return null;
        return em.merge(picture);
    }

    public void removePictureById(@Nullable final String pictureId) {
        @Nullable final TblPictureEntity pictureEntity = getPicturesById(pictureId);
        if (pictureEntity == null) return;
        em.remove(pictureEntity);
    }

}
