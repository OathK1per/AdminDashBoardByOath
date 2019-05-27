package com.example.demo.pojo;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "c_id")
    private Integer c_id;
    @Column(name = "c_product")
    @NotBlank
    private String c_product;
    @Column(name = "price")
    @Min(0)
    @NotNull
    private BigDecimal price;
    @Column(name = "type")
    private Integer type;

    public Category() {
        super();
    }

    public Category(String c_product, BigDecimal price, Integer type) {
        this.c_product = c_product;
        this.price = price;
        this.type = type;
    }

    public Integer getC_id() {
        return c_id;
    }

    public void setC_id(Integer c_id) {
        this.c_id = c_id;
    }

    public String getC_product() {
        return c_product;
    }

    public void setC_product(String c_product) {
        this.c_product = c_product;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
