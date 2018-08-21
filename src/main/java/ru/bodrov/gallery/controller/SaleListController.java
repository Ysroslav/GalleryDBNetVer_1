package ru.bodrov.gallery.controller;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bodrov.gallery.dao.TblClientEntDAO;
import ru.bodrov.gallery.dao.TblSaleEntDAO;
import ru.bodrov.gallery.entity.TblClientEnt;
import ru.bodrov.gallery.entity.TblSaleEnt;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;


@ViewScoped
@ManagedBean
public class SaleListController {

    @Inject
    private TblSaleEntDAO saleDAO;

    @NotNull
    public List<TblSaleEnt> getListSales() {
        return saleDAO.getSales();
    }

    public void removeSaleById(@Nullable final String saleId) {
        saleDAO.removeSaleById(saleId);
    }
}
