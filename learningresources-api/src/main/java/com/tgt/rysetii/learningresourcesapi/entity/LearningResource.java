package com.tgt.rysetii.learningresourcesapi.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "learning_resources")
public class LearningResource {

    @Id
    @Column(name = "learning_resource_id")
    private int id;

    @Column(name = "learning_resource_name")
    private String name;

    @Column(name = "cost_price")
    private Double costPrice;

    @Column(name = "selling_price")
    private Double sellingPrice;

    @Column(name = "learning_resource_status")
    @Enumerated(EnumType.STRING)
    private LearningResourceStatus productStatus;

    @Column(name = "created_date")
    private LocalDate createdDate;

    @Column(name = "published_date")
    private LocalDate publishedDate;

    @Column(name = "retired_date")
    private LocalDate retiredDate;

    public LearningResource() {
    }

    public LearningResource(int id, String name, Double costPrice, Double sellingPrice, LearningResourceStatus productStatus, LocalDate createdDate, LocalDate publishedDate, LocalDate retiredDate) {
        this.id = id;
        this.name = name;
        this.costPrice = costPrice;
        this.sellingPrice = sellingPrice;
        this.productStatus = productStatus;
        this.createdDate = createdDate;
        this.publishedDate = publishedDate;
        this.retiredDate = retiredDate;
    }
    public Double getProfitMargin(){
        return (this.sellingPrice-this.costPrice)/this.getSellingPrice();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(Double costPrice) {
        this.costPrice = costPrice;
    }

    public Double getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(Double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public LearningResourceStatus getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(LearningResourceStatus productStatus) {
        this.productStatus = productStatus;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDate getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(LocalDate publishedDate) {
        this.publishedDate = publishedDate;
    }

    public LocalDate getRetiredDate() {
        return retiredDate;
    }

    public void setRetiredDate(LocalDate retiredDate) {
        this.retiredDate = retiredDate;
    }

}
