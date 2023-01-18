package entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class OwnerBoatId implements Serializable {
    private static final long serialVersionUID = -6671116868513669646L;
    @NotNull
    @Column(name = "ownerID", nullable = false)
    private Integer ownerID;

    @NotNull
    @Column(name = "boatID", nullable = false)
    private Integer boatID;

    public OwnerBoatId() {
    }

    public Integer getOwnerID() {
        return ownerID;
    }

    public void setOwnerID(Integer ownerID) {
        this.ownerID = ownerID;
    }

    public Integer getBoatID() {
        return boatID;
    }

    public void setBoatID(Integer boatID) {
        this.boatID = boatID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OwnerBoatId entity = (OwnerBoatId) o;
        return Objects.equals(this.ownerID, entity.ownerID) &&
                Objects.equals(this.boatID, entity.boatID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ownerID, boatID);
    }

}