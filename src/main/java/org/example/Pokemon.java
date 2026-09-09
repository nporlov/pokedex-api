package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import tools.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {
    // EMPTY CONSTRUCTOR
    public Pokemon() {}

    private int id;
    private String name;
    @JsonProperty ("base_experience") private int baseExperience;
    private int height;
    private int weight;
    @JsonProperty ("is_default") private boolean isDefault;
    private int order;
    private List<Ability> abilities;

    // GETTERS
    public String getName() { return name; }
    public boolean  isDefault() { return isDefault; }
    public int getOrder() { return order; }
    public int getId() { return id; }
    public int getBaseExperience() { return baseExperience; }
    public int getHeight() { return height; }
    public int getWeight() { return weight; }
    public List<Ability> getAbilities() { return abilities; }

    // SETTERS
    public void setName(String name) { this.name = name; }
    public void setIsDefault(boolean isDefault) { this.isDefault = isDefault; }
    public void setOrder(int order) { this.order = order; }
    public void setId(int id) { this.id = id; }
    public void setBaseExperience(int baseExperience) { this.baseExperience = baseExperience; }
    public void setHeight(int height) { this.height = height; }
    public void setWeight(int weight) { this.weight = weight; }
    public void setAbilities(List<Ability> abilities) { this.abilities = abilities; }

    public void printBasicInfo () {
        System.out.println("ID:\t\t\t" + id);
        System.out.println("Name:\t\t" + name);
        System.out.println("Height:\t\t" + height);
        System.out.println("Weight:\t\t" + weight);
    }
}
