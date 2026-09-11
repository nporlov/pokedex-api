package pokedex;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PokemonOwnedAbility {
    @JsonProperty("is_hidden") private boolean isHidden;
    private int slot;
    private Ability ability;

    // EMPTY CONSTRUCTOR
    public PokemonOwnedAbility() {}

    // GETTERS
    public boolean  isHidden() {return isHidden;}
    public int getSlot() {return slot;}
    public Ability getAbility() {return ability;}
}
