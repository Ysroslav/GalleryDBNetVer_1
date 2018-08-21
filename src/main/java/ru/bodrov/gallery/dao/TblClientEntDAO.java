package ru.bodrov.gallery.dao;


import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bodrov.gallery.entity.TblClientEnt;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class TblClientEntDAO extends AbstractDAO {

    public TblClientEnt findOne(String id) {
        return em.find(TblClientEnt.class, id);
    }

    @NotNull
    public List<TblClientEnt> getClients() {
        return em.createQuery("SELECT e FROM TblClientEnt e ORDER BY e.dateIn DESC", TblClientEnt.class).getResultList();
    }

    @Nullable
    public TblClientEnt getClientsById(@Nullable final String clientId) {
        if (clientId == null || clientId.isEmpty()) return null;
        return getEntity(em.createQuery("SELECT e FROM TblClientEnt e WHERE e.id = :id", TblClientEnt.class)
                .setParameter("id", clientId)
                .setMaxResults(1));
    }

    @Nullable
    public TblClientEnt persist(@Nullable final TblClientEnt client) {
        if (client == null) return null;
        em.persist(client);
        return client;
    }

    @Nullable
    public TblClientEnt merge(@Nullable final TblClientEnt client) {
        if (client == null) return null;
        return em.merge(client);
    }

    public void removeClientById(@Nullable final String clientId) {
        @Nullable final TblClientEnt clientEnt = getClientsById(clientId);
        if (clientEnt == null) return;
        em.remove(clientEnt);
    }

}
