package ru.bodrov.gallery.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class TblLogEntity extends TblEntityEntity  {

    @Column
    private String message;

    public TblLogEntity(){}

    public TblLogEntity(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}
