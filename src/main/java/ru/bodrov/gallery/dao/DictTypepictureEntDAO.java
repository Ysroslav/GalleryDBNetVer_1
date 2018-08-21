package ru.bodrov.gallery.dao;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bodrov.gallery.entity.DictTypepictureEnt;
import ru.bodrov.gallery.entity.TblClientEnt;

import java.util.List;

public class DictTypepictureEntDAO extends AbstractDAO {

    public DictTypepictureEnt findOne(String id) {
        return em.find(DictTypepictureEnt.class, id);
    }

    @NotNull
    public List<DictTypepictureEnt> getTypes() {
        return em.createQuery("SELECT e FROM DictTypepictureEnt e ORDER BY e.dateLoad DESC", DictTypepictureEnt.class).getResultList();
    }

    @Nullable
    public DictTypepictureEnt getTypesById(@Nullable final String typeId) {
        if (typeId == null || typeId.isEmpty()) return null;
        return getEntity(em.createQuery("SELECT e FROM DictTypepictureEnt e WHERE e.id = :id", DictTypepictureEnt.class)
                .setParameter("id", typeId)
                .setMaxResults(1));
    }

    @Nullable
    public DictTypepictureEnt persist(@Nullable final DictTypepictureEnt type) {
        if (type == null) return null;
        em.persist(type);
        return type;
    }

    @Nullable
    public DictTypepictureEnt merge(@Nullable final DictTypepictureEnt type) {
        if (type == null) return null;
        return em.merge(type);
    }

    public void removeTypeById(@Nullable final String typeId) {
        @Nullable final DictTypepictureEnt typeEnt = getTypesById(typeId);
        if (typeEnt == null) return;
        em.remove(typeEnt);
    }
}
