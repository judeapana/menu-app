package com.application.menuapp.models;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.io.Serializable;

@DatabaseTable(tableName = "menu_db")
public class Menu implements Serializable {

    @DatabaseField(generatedId = true)
    public Long Id;
    @DatabaseField(dataType = DataType.STRING)
    public String foodName;
    @DatabaseField(dataType = DataType.STRING)
    public String tribeName;

    @DatabaseField(dataType = DataType.STRING)
    private String howToPrepare;

    public Menu(){

    }
    public Menu(String foodName, String tribeName, String howToPrepare) {
        this.setFoodName(foodName);
        this.setTribeName(tribeName);
        this.setHowToPrepare(howToPrepare);
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getTribeName() {
        return tribeName;
    }

    public void setTribeName(String tribeName) {
        this.tribeName = tribeName;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getHowToPrepare() {
        return howToPrepare;
    }

    public void setHowToPrepare(String howToPrepare) {
        this.howToPrepare = howToPrepare;
    }
}
