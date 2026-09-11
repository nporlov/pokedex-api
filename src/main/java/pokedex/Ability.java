package pokedex;

import com.fasterxml.jackson.annotation.JsonProperty;
import tools.jackson.databind.annotation.JsonDeserialize;

public class Ability {
    public Ability() {}

    private String name;
    private int id;
    @JsonProperty("is_main_series") private boolean isMainSeries;

    // GETTERS
    public String getName() { return name; }
    public int getId() { return id; }
    public boolean isMainSeries() { return isMainSeries; }

    // SETTERS
    public void setName(String name) { this.name = name; }
    public void setId(int id) { this.id = id; }
    public void setMainSeries(boolean isMainSeries) { this.isMainSeries = isMainSeries; }

    public String toString() {
        return String.format("""
                        ID:\t\t\t%d
                        Name:\t\t%s""",
                this.getId(), this.getName());
    }
}
