package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import tools.jackson.databind.annotation.JsonDeserialize;

public class Ability {
    public Ability() {}

    private String name;

    // GETTERS
    public String getName() { return name; }

    // SETTERS
    public void setName(String name) { this.name = name; }
}
