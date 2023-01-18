package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "owner")
public class Owner {
    @Id
    @Column(name = "owner_ID", nullable = false)
    private Integer id;

    @Size(max = 45)
    @Column(name = "owner_name", length = 45)
    private String ownerName;

    @Size(max = 45)
    @Column(name = "owner_adress", length = 45)
    private String ownerAdress;

    @Size(max = 45)
    @Column(name = "owner_phonenum", length = 45)
    private Integer ownerPhonenum;



    public Owner(String ownerName, String ownerAdress, int ownerPhonenum) {
    }

    public Owner() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerAdress() {
        return ownerAdress;
    }

    public void setOwnerAdress(String ownerAdress) {
        this.ownerAdress = ownerAdress;
    }

    public int getOwnerPhonenum() {
        return ownerPhonenum;
    }

    public void setOwnerPhonenum(int ownerPhonenum) {
        this.ownerPhonenum = ownerPhonenum;
    }


}