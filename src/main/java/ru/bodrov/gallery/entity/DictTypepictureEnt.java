package ru.bodrov.gallery.entity;

import org.jetbrains.annotations.Nullable;
import ru.bodrov.gallery.api.WBS;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class DictTypepictureEnt extends TblEntityEntity implements WBS {

    //private int id;
    @Nullable
    private String nameType = null;
    @Nullable
    private String shortName = null;
    @Nullable
    private Date dateLoad;


    public DictTypepictureEnt(){
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "dictTypepictureEnt", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TblPictureEntity> pictures = new ArrayList<>();

    @Nullable
    public String getNameType(){return nameType;}
    @Nullable
    public String getShortName(){return shortName;}
    @Nullable
    public Date getDateLoad(){return dateLoad;}

    public void setNameType(@Nullable String nameType){this.nameType = nameType;}
    public void setShortName(@Nullable String shortName){this.shortName = shortName;}
    public void setDateLoad(@Nullable Date dateLoad){this.dateLoad = dateLoad;}

}
