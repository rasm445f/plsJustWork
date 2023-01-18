package dtos;

import entities.Boat;
import entities.Owner;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link Owner} entity
 */
public class OwnerDto implements Serializable {
    private final Integer id;
    @Size(max = 45)
    private final String ownerName;
    @Size(max = 45)
    private final String ownerAdress;
    @Size(max = 45)
    private final Integer ownerPhonenum;



    public OwnerDto(Integer id, String ownerName, String ownerAdress, int ownerPhonenum) {
        this.id = id;
        this.ownerName = ownerName;
        this.ownerAdress = ownerAdress;
        this.ownerPhonenum = ownerPhonenum;

    }

    public OwnerDto(Owner owner) {
        this.id = owner.getId();
        this.ownerName = owner.getOwnerName();
        this.ownerAdress = owner.getOwnerAdress();
        this.ownerPhonenum = owner.getOwnerPhonenum();

    }

    public static List<OwnerDto> getOwnerDtos(List<Owner> owners) {
        List<OwnerDto> ownerDtoList = new ArrayList<>();
        owners.forEach(owner -> {
            ownerDtoList.add(new OwnerDto(owner));
        });
        return ownerDtoList;
    }

    public Integer getId() {
        return id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public String getOwnerAdress() {
        return ownerAdress;
    }

    public int getOwnerPhonenum() {
        return ownerPhonenum;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OwnerDto entity = (OwnerDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.ownerName, entity.ownerName) &&
                Objects.equals(this.ownerAdress, entity.ownerAdress) &&
                Objects.equals(this.ownerPhonenum, entity.ownerPhonenum);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ownerName, ownerAdress, ownerPhonenum);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "ownerName = " + ownerName + ", " +
                "ownerAdress = " + ownerAdress + ", " +
                "ownerPhonenum = " + ownerPhonenum + ", ";
    }
}