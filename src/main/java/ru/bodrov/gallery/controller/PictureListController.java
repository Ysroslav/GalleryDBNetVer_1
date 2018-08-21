package ru.bodrov.gallery.controller;


import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bodrov.gallery.dao.TblClientEntDAO;
import ru.bodrov.gallery.dao.TblPictureEntityDAO;
import ru.bodrov.gallery.entity.TblClientEnt;
import ru.bodrov.gallery.entity.TblPictureEntity;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ViewScoped
@ManagedBean
public class PictureListController {
    @Inject
    private TblPictureEntityDAO pictureDAO;

    @NotNull
    public List<TblPictureEntity> getListPictures() {
        return pictureDAO.getPictures();
    }

    public void removePictureById(@Nullable final String pictureId) {
        pictureDAO.removePictureById(pictureId);
    }
}
