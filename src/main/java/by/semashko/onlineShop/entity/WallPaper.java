package by.semashko.onlineShop.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Table (name="table_shop_wallpaper")
public class WallPaper {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="name")
    @NotBlank
    private String name;
    @Column(name="color")
    @NotBlank
    private String color;
    @Column(name="painting")
    @NotBlank
    private String painting;
    @Column(name="count")
    @NotBlank
    private Integer count;
    @Min(1)
    @Column(name="price")
    @Min(1)
    private Integer price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPainting() {
        return painting;
    }

    public void setPainting(String painting) {
        this.painting = painting;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Wallpaper{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", painting='" + painting + '\'' +
                ", count=" + count +
                '}';
    }
}
