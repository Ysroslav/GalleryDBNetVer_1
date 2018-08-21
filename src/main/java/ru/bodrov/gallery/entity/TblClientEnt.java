package ru.bodrov.gallery.entity;

import org.jetbrains.annotations.Nullable;
import ru.bodrov.gallery.api.WBS;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class TblClientEnt extends TblEntityEntity implements WBS {

    @Nullable
    private String firstName = null;
    @Nullable
    private String lastName= null;
    @Nullable
    private Date dateBirth = null;
    @Nullable
    private String email = null;
    @Nullable
    private String telephone= null;
    @Nullable
    private String addtelephone = null;
    @Nullable
    private String address = null;
    @Nullable
    private Date dateIn;
    @Nullable
    private byte isAuthor;


    public TblClientEnt(){}

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tblClientEnt", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TblPictureEntity> pictures = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tblClientEnts", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TblSaleEnt> sales = new ArrayList<>();

    @Nullable
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(@Nullable String firstName) {
        this.firstName = firstName;
    }

    @Nullable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(@Nullable  String lastName) {
        this.lastName = lastName;
    }

    @Nullable
    public Date getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(@Nullable Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    @Nullable
    public String getEmail() {
        return email;
    }

    public void setEmail(@Nullable String email) {
        this.email = email;
    }

    @Nullable
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(@Nullable String telephone) {
        this.telephone = telephone;
    }

    @Nullable
    public String getAddtelephone() {
        return addtelephone;
    }

    public void setAddtelephone(@Nullable String addtelephone) {
        this.addtelephone = addtelephone;
    }

    @Nullable
    public String getAddress() {
        return address;
    }

    public void setAddress(@Nullable String address) {
        this.address = address;
    }

    @Nullable
    public Date getDateIn() {
        return dateIn;
    }

    public void setDateIn(@Nullable Date dateIn) {
        this.dateIn = dateIn;
    }

    @Nullable
    public byte getIsAuthor() {
        return isAuthor;
    }

    public void setIsAuthor(@Nullable byte isAuthor) {
        this.isAuthor = isAuthor;
    }


}
