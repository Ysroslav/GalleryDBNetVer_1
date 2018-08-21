package ru.bodrov.gallery.controller;


import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bodrov.gallery.dao.TblPictureEntityDAO;
import ru.bodrov.gallery.dao.TblSaleEntDAO;
import ru.bodrov.gallery.entity.TblPictureEntity;
import ru.bodrov.gallery.entity.TblSaleEnt;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

@ViewScoped
@ManagedBean
public class SaleEditController {

    @Inject
    private TblSaleEntDAO saleDAO;

    @Nullable
    private String id;

    @NotNull
    private TblSaleEnt saleEnt = new TblSaleEnt();

    public void init() {
        @Nullable final TblSaleEnt saleEnt = saleDAO.getSalesById(id);
        if (saleEnt!= null) this.saleEnt = saleEnt;
    }

    @NotNull
    public String save() {
        saleDAO.merge(saleEnt);
        return "sale-list";
    }

    @NotNull
    public TblSaleEnt getSaleEnt() {
        return saleEnt;
    }

    public void setSaleEnt(@NotNull final TblSaleEnt saleEnt) {
        this.saleEnt = saleEnt;
    }

    @Nullable
    public String getId() {
        return id;
    }

    public void setId(@Nullable final String id) {
        this.id = id;
    }
}
