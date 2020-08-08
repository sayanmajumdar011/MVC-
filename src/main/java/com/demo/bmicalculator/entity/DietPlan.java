package com.demo.bmicalculator.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "diet_plan")
public class DietPlan {
    private static final long serialVersionUID = -6477953462119453739L;

    @Id
    @Column(name = "ID")
    private String id;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "TIPS", length = 1000)
    private String tips;

    public DietPlan() {
    }

    public DietPlan(String id, String category, String tips) {
        this.id = id;
        this.category = category;
        this.tips = tips;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }
}
