package ru.bodrov.gallery.controller;


import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bodrov.gallery.dao.TblClientEntDAO;
import ru.bodrov.gallery.entity.TblClientEnt;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;
import java.util.List;

@ViewScoped
@ManagedBean
public class ClientListController {

    @Inject
    private TblClientEntDAO clientDAO;

    @NotNull
    public List<TblClientEnt> getListClients() {
        return clientDAO.getClients();
    }

    public void removeClientById(@Nullable final String clientId) {
        clientDAO.removeClientById(clientId);
    }
}
