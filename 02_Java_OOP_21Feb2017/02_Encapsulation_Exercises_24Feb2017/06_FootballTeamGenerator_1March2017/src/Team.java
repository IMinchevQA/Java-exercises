import java.util.ArrayList;
import java.util.List;

public class Team {

    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    public boolean addPlayer(Player player) {
        return this.players.add(player); //ADDS player and RETURNS true if addition is successful.
    }

    public boolean removePlayer(String playerName) {
        Player player = this.getPlayerByName(playerName);
        if (player == null) {
            throw new CE(String.format("Player %s is not in %s team.", playerName, this.name));
        }
        return this.players.remove(player); //REMOVES player and RETURNS true if removal is successful.
    }

    private double getRating() {
        // this.players.stream().mapToDouble(Player::getSkill).average(); RETURNS OPTIONAL DOUBLE
        //Therefore adding .orElse(0D) is necessary;
        return this.players.stream().mapToDouble(Player::getSkill)
                .average()
                .orElse(0D);
    }

    @Override
    public String toString() {
        return String.format("%s - %.0f", this.name, this.getRating());
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new CE("A name should not be empty.");
        }
        this.name = name;
    }

    private Player getPlayerByName(String name) {
        // this.players.stream().filter(pl -> pl.getName().equals(name)).findFirst(); RETURNS OPTIONAL;
        //Therefore adding .orElse(null) is necessary;
        return this.players.stream().filter(pl -> pl.getName().equals(name)).findFirst().orElse(null);

    }
}
