package com.api.h2.Entities;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="productos")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column
    private String name;
    @Column
    private Double price;
    @Column
    private Integer stock;

    @Column(name = "published")
	private boolean published;

    // ### Many to Many
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "ventas_productos", joinColumns = @JoinColumn(name = "producto_id"), inverseJoinColumns = @JoinColumn(name = "venta_id"))
    private List<Venta> ventas;

    public Producto() {
    }

    public Producto(String name, Double price, Integer stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public void addVenta(Venta venta){
        if(this.ventas == null){
            this.ventas = new ArrayList<>();
        }
        this.ventas.add(venta);
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Integer getStock() {
        return stock;
    }
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public List<Venta> getVentas() {
        return ventas;
    }

    public void setVentas(List<Venta> ventas) {
        this.ventas = ventas;
    }
}
