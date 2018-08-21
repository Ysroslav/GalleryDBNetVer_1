package ru.bodrov.gallery.entity;

import org.jetbrains.annotations.Nullable;
import ru.bodrov.gallery.api.WBS;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class TblSaleEnt extends TblEntityEntity implements WBS {
    @Nullable
    private double prize=0;
    @Nullable
    private Date dateSale;


    public TblSaleEnt(){}

    @Nullable
    public double getPrize(){return prize;}
    @Nullable
    public Date getDateSale(){return dateSale;}

    public void setPrize(@Nullable double prize){this.prize = prize;}
    public void setDateSale(@Nullable Date dateSale){this.dateSale = dateSale;}

    @ManyToOne(optional = false)
    private TblPictureEntity tblPictureEntities;

    public TblPictureEntity getTblPictureEntities() {
        return tblPictureEntities;
    }

    public void setTblPictureEntities(TblPictureEntity tblPictureEntities) {
        this.tblPictureEntities = tblPictureEntities;
    }

    @ManyToOne(optional = false)
    private TblClientEnt tblClientEnts;

    public TblClientEnt getTblClientEnts() {
        return tblClientEnts;
    }

    public void setTblClientEnts(TblClientEnt tblClientEnts) {
        this.tblClientEnts = tblClientEnts;
    }
}
