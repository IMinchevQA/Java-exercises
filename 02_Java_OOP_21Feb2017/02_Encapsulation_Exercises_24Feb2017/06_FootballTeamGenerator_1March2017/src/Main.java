import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Main {
    private static Map<String, Team> teams = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        executeReadInput(reader);
    }

    private static void executeReadInput(BufferedReader reader) throws IOException {
        String line = "";

        while (!"END".equals(line = reader.readLine())) {
            String[] commandTokens = line.split(";");
            String command = commandTokens[0];
            String[] commandArgs = Stream.of(commandTokens).skip(1).toArray(String[]::new);
            try {
                switch (command) {
                    case "Team":
                        createNewTeam(commandArgs);
                        break;
                    case "Add":
                        addNewPlayer(commandArgs);
                        break;
                    case "Remove":
                        removePlayerFromTeam(commandArgs);
                        break;
                    case "Rating":
                        getTeamRating(commandArgs);
                        break;
                }
            } catch (CE ce) {
                System.out.println(ce.getMessage());
            }

        }
    }

    private static void getTeamRating(String[] commandArgs) {
        String teamName = commandArgs[0];
        Team team = getTeamByName(teamName);
        System.out.println(team);

    }

    private static void removePlayerFromTeam(String[] commandArgs) {
        String teamName = commandArgs[0];
        Team team = getTeamByName(teamName);
        String playerName = commandArgs[1];
        team.removePlayer(playerName);

    }

    private static void addNewPlayer(String[] commandArgs) {
        String teamName = commandArgs[0];
        Team team = getTeamByName(teamName);

        String playerName = commandArgs[1];
        double skill1 = Double.parseDouble(commandArgs[2]);
        double skill2 = Double.parseDouble(commandArgs[3]);
        double skill3 = Double.parseDouble(commandArgs[4]);
        double skill4 = Double.parseDouble(commandArgs[5]);
        double skill5 = Double.parseDouble(commandArgs[6]);
        Player player = new Player(playerName, skill1, skill2, skill3, skill4, skill5);
        team.addPlayer(player);
    }

    private static void createNewTeam(String[] commandArgs) {
        String teamName = commandArgs[0];
        teams.putIfAbsent(teamName, new Team(teamName));
    }

    private static Team getTeamByName(String teamName) {
        Team team = teams.getOrDefault(teamName, null);
        if(team == null) {
            throw new CE(String.format("Team %s does not exist.", teamName));
        }

        return team;
    }
}

/*
Input 1:
Team;Arsenal
Add;Arsenal;Kieran_Gibbs;75;85;84;92;67
Add;Arsenal;Aaron_Ramsey;95;82;82;89;68
Remove;Arsenal;Aaron_Ramsey
Rating;Arsenal
END

Expected output 1:
Arsenal – 81


Input 2:
Team;Arsenal
Add;Arsenal;Kieran_Gibbs;75;85;84;92;67
Add;Arsenal;Aaron_Ramsey;195;82;82;89;68
Remove;Arsenal;Aaron_Ramsey
Rating;Arsenal
END

Expected output 2:
Endurance should be between 0 and 100.
Player Aaron_Ramsey is not in Arsenal team.
Arsenal - 81


Input 3:
Team;Arsenal
Rating;Arsenal
END

Expected output 3:
Arsenal – 0
 */
