package ru.bodrov.gallery.dao;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bodrov.gallery.entity.TblClientEnt;
import ru.bodrov.gallery.entity.TblSaleEnt;

import java.util.List;

public class TblSaleEntDAO extends AbstractDAO {

    public TblSaleEnt findOne(String id) {
        return em.find(TblSaleEnt.class, id);
    }

    @NotNull
    public List<TblSaleEnt> getSales() {
        return em.createQuery("SELECT e FROM TblSaleEnt e ORDER BY e.dateSale DESC", TblSaleEnt.class).getResultList();
    }

    @Nullable
    public TblSaleEnt getSalesById(@Nullable final String saleId) {
        if (saleId == null || saleId.isEmpty()) return null;
        return getEntity(em.createQuery("SELECT e FROM TblSaleEnt e WHERE e.id = :id", TblSaleEnt.class)
                .setParameter("id", saleId)
                .setMaxResults(1));
    }

    @Nullable
    public TblSaleEnt persist(@Nullable final TblSaleEnt sale) {
        if (sale == null) return null;
        em.persist(sale);
        return sale;
    }

    @Nullable
    public TblSaleEnt merge(@Nullable final TblSaleEnt sale) {
        if (sale == null) return null;
        return em.merge(sale);
    }

    public void removeSaleById(@Nullable final String saleId) {
        @Nullable final TblSaleEnt saleEnt = getSalesById(saleId);
        if (saleEnt == null) return;
        em.remove(saleEnt);
    }

}
