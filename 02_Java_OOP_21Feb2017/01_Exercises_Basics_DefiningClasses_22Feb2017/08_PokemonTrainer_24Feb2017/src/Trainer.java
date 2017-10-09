import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String trainerName;
    private List<Pokemon> trainerPokemonList = new ArrayList<>();
    private int badges = 0;

    public Trainer (String name) {
        this.trainerName = name;
    }

    public String getName() {
        return this.trainerName;
    }

    public int getBadges() {
        return this.badges;
    }

    public List<Pokemon> getPokemonList() {
        return this.trainerPokemonList;
    }

    public void addPokemon(Pokemon pokemon) {
        trainerPokemonList.add(pokemon);
    }

    public void refreshPokemonList(List<Pokemon> newPokemonList) {
        this.trainerPokemonList = newPokemonList;
    }

    public void incrementBadges() {
        badges++;
    }
}
