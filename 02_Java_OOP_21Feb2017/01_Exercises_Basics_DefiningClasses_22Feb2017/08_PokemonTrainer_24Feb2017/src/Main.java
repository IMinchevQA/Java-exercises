import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
        private static List<Trainer> trainersList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        executeFillTrainersList(reader);

        List<Trainer> trainersListSorted = new ArrayList<>();
        trainersList.stream()
                .sorted((t1, t2) -> {
                    if (t1.getBadges() > t2.getBadges()) {
                        return -1;
                    } else if (t1.getBadges() < t2.getBadges()) {
                        return 1;
                    }
                    return 0;
                })
        .forEachOrdered(e -> trainersListSorted.add(e));

        //Print result
        for (Trainer trainer : trainersListSorted) {
            System.out.printf("%s %s %s%n", trainer.getName(), trainer.getBadges(), trainer.getPokemonList().size());
        }
    }

    private static void executeTournament(BufferedReader reader, String line) throws IOException {
        while (!"End".equals(line = reader.readLine())) {
            String currentElement = line;
            for (Trainer trainer : trainersList) {
                //Current trainer pokemons
                List<Pokemon> pokemonsListCurrentTrainer = trainer.getPokemonList();
                int[] indexPokemonHasElement = {-1};
                //Search index of element in trainersList with name == trainerName
                pokemonsListCurrentTrainer.stream()
                        .filter(p -> p.getPokemonElement().equals(currentElement))
                        .forEachOrdered(e -> indexPokemonHasElement[0] = pokemonsListCurrentTrainer.indexOf(e));

                if (indexPokemonHasElement[0] != -1) {
                    trainer.incrementBadges();
                } else {
                    List<Pokemon> pokemonsLeft = new ArrayList<>();
                    pokemonsListCurrentTrainer.stream()
                            .forEach((e) -> {
                                e.reducePokemonHealth();
                                if (e.getPokemonHealth() > 0) {
                                    pokemonsLeft.add(e);
                                }
                            });

                    trainer.refreshPokemonList(pokemonsLeft);
                }
            }
        }
    }

    private static void executeFillTrainersList(BufferedReader reader) throws IOException {
        String line;
        while (!"Tournament".equals(line = reader.readLine())) {
            String[] tokens = line.trim().split("\\s+");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            int[] indexCurrentTrainer = {-1};
            //Search index of element in trainersList with name == trainerName
            trainersList.stream()
                    .filter(t -> t.getName().equals(trainerName))
                    .forEachOrdered(e -> indexCurrentTrainer[0] = trainersList.indexOf(e));

            if (indexCurrentTrainer[0] != -1) {
                Pokemon currentPokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
                trainersList.get(indexCurrentTrainer[0]).addPokemon(currentPokemon);
            } else {
                Trainer currentTrainer = new Trainer(trainerName);
                Pokemon currentPokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
                currentTrainer.addPokemon(currentPokemon);
                trainersList.add(currentTrainer);
            }
        }
        executeTournament(reader, line);
    }




}


/*
Input 1:
Pesho Charizard Fire 100
Gosho Squirtle Water 38
Pesho Pikachu Electricity 10
Tournament
Fire
Electricity
End

Expected output 1:
Pesho 2 2
Gosho 0 1


Input 2:
Stamat Blastoise Water 18
Nasko Pikachu Electricity 22
Jicata Kadabra Psychic 90
Tournament
Fire
Electricity
Fire
End


Expected output 2:
Nasko 1 1
Stamat 0 0
Jicata 0 1


 */