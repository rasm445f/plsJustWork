package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "boat")
public class Boat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "boat_ID", nullable = false)
    private Integer id;

    @Size(max = 45)
    @Column(name = "brand", length = 45)
    private String brand;

    @Size(max = 45)
    @Column(name = "make", length = 45)
    private String make;

    @Size(max = 45)
    @Column(name = "image", length = 45)
    private String image;

    @Size(max = 45)
    @NotNull
    @Column(name = "name", nullable = false, length = 45)
    private String name;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "harborID", nullable = false)
    private Harbor harborID;

    public Boat (String brand, String make, String image, String name) {
        this.brand = brand;
        this.make = make;
        this.image = image;
        this.name = name;

    }

    public Boat() {

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Harbor getHarborID() {
        return harborID;
    }

    public void setHarborID(Harbor harborID) {
        this.harborID = harborID;
    }

}