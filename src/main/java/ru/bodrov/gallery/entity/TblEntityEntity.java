package ru.bodrov.gallery.entity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
public abstract class TblEntityEntity {
    @Id
    @NotNull
    private String id = UUID.randomUUID().toString();

    @Nullable
    private java.util.Date created;

    @Nullable
    private java.util.Date updated;

    @NotNull
    public String getId() {
        return id;
    }

    public void setId(@NotNull String id) {
        this.id = id;
    }

    @Nullable
    public java.util.Date getCreated() {
        return created;
    }

    public void setCreated(@Nullable java.util.Date created) {
        this.created = created;
    }

    @Nullable
    public java.util.Date getUpdated() {
        return updated;
    }

    public void setUpdated(@Nullable java.util.Date updated) {
        this.updated = updated;
    }

    @PrePersist
    private void prePersist() {
        created = new java.util.Date();
        updated = new java.util.Date();
    }

    @PreUpdate
    private void preUpdate() {
        if (created == null) created = new java.util.Date();
        updated = new java.util.Date();
    }

}
