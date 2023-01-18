package dtos;

import entities.Harbor;
import entities.Owner;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * A DTO for the {@link Harbor} entity
 */
public class HarborDto implements Serializable {
    private final Integer id;
    @Size(max = 45)
    @NotNull
    private final String name;
    @Size(max = 45)
    @NotNull
    private final String adress;
    @NotNull
    private final Integer capasity;

    public HarborDto(Integer id, String name, String adress, Integer capasity) {
        this.id = id;
        this.name = name;
        this.adress = adress;
        this.capasity = capasity;
    }

    public HarborDto(Harbor harbor){
        this.id = harbor.getId();
        this.name = harbor.getName();
        this.adress = harbor.getAdress();
        this.capasity = harbor.getCapasity();
    }

    public static List<HarborDto> getHarborDtos(List<Harbor> harbors) {
        List<HarborDto> harborDtoList = new ArrayList<>();
        harbors.forEach(harbor -> {
            harborDtoList.add(new HarborDto(harbor));
        });
        return harborDtoList;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAdress() {
        return adress;
    }

    public Integer getCapasity() {
        return capasity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HarborDto entity = (HarborDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.name, entity.name) &&
                Objects.equals(this.adress, entity.adress) &&
                Objects.equals(this.capasity, entity.capasity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, adress, capasity);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "name = " + name + ", " +
                "adress = " + adress + ", " +
                "capasity = " + capasity + ")";
    }
}