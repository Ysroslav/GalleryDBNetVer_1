package ru.bodrov.gallery.controller;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.bodrov.gallery.dao.TblClientEntDAO;
import ru.bodrov.gallery.entity.TblClientEnt;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

@ViewScoped
@ManagedBean
public class ClientEditController {

    @Inject
    private TblClientEntDAO clientDAO;

    @Nullable
    private String id;

    @NotNull
    private TblClientEnt clientEnt = new TblClientEnt();

    public void init() {
        @Nullable final TblClientEnt clientEnt = clientDAO.getClientsById(id);
        if (clientEnt != null) this.clientEnt = clientEnt;
    }

    @NotNull
    public String save() {
        clientDAO.merge(clientEnt);
        return "client-list";
    }

    @NotNull
    public TblClientEnt getClientEnt() {
        return clientEnt;
    }

    public void setClientEnt(@NotNull final TblClientEnt clientEnt) {
        this.clientEnt = clientEnt;
    }

    @Nullable
    public String getId() {
        return id;
    }

    public void setId(@Nullable final String id) {
        this.id = id;
    }
}
