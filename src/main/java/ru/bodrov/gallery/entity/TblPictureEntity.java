package ru.bodrov.gallery.entity;

import org.jetbrains.annotations.Nullable;
import ru.bodrov.gallery.api.WBS;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class TblPictureEntity extends TblEntityEntity implements WBS {

   @Nullable
    private String titlePicture = null;
    @Nullable
    private Date dateInput;
    @Nullable
    private double valueBalance;
    @Nullable
    private String apostel = null;
    @Nullable
    private int athorId;
    @Nullable
    private int pictureType;

    public TblPictureEntity(){}

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tblPictureEntities", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TblSaleEnt> sales = new ArrayList<>();

   @Nullable
    public String getTitlePicture() {
        return titlePicture;
    }

    public void setTitlePicture( @Nullable String titlePicture) {
        this.titlePicture = titlePicture;
    }

    @Nullable
    public Date getDateInput() {
        return dateInput;
    }

    public void setDateInput( @Nullable Date dateInput) {
        this.dateInput = dateInput;
    }

    @Nullable
    public double getValueBalance() {
        return valueBalance;
    }

    public void setValueBalance( @Nullable double valueBalance) {
        this.valueBalance = valueBalance;
    }

    @Nullable
    public String getApostel() {
        return apostel;
    }

    public void setApostel( @Nullable String apostel) {
        this.apostel = apostel;
    }

    @Nullable
    public int getAthorId() {
        return athorId;
    }

    public void setAthorId( @Nullable int athorId) {
        this.athorId = athorId;
    }

    @Nullable
    public int getPictureType() {
        return pictureType;
    }

    public void setPictureType( @Nullable int pictureType) {
        this.pictureType = pictureType;
    }

    @ManyToOne()
    private DictTypepictureEnt dictTypepictureEnt;

    public DictTypepictureEnt getDictTypepictureEnt() {
        return dictTypepictureEnt;
    }

    public void setDictTypepictureEnt(DictTypepictureEnt dictTypepictureEnt) {
        this.dictTypepictureEnt = dictTypepictureEnt;
    }

    @ManyToOne(optional = false)
    private TblClientEnt tblClientEnt;

    public TblClientEnt getTblClientEnt() {
        return tblClientEnt;
    }

    public void setTblClientEnt(TblClientEnt tblClientEnt) {
        this.tblClientEnt = tblClientEnt;
    }

}
