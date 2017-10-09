package Ex08_MilitaryElite_15March2017;


import Ex08_MilitaryElite_15March2017.implementation.*;
import Ex08_MilitaryElite_15March2017.interfaces.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
        private static Map<Integer, Soldier> army = new LinkedHashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        executeReadInput(reader);

        army.values().stream().forEach(e -> System.out.println(e.toString().trim()));
    }

    private static void executeReadInput(BufferedReader reader) throws IOException {
        String line = "";

        while (!"End".equals(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");

            String type = tokens[0];
            int id = Integer.parseInt(tokens[1]);
            String firstName = tokens[2];
            String lastName = tokens[3];

            switch (type.toLowerCase()) {
                case "private":
                    army.putIfAbsent(id, new PrivateImpl(id, firstName, lastName, Double.parseDouble(tokens[4])));
                    break;
                case "leutenantgeneral":
                    Collection<Private> somePrivates = new ArrayList<>();
                    Stream.of(tokens).skip(5)
                            .map(s -> Integer.parseInt(s))
                            .collect(Collectors.toList()).forEach(e ->
                                somePrivates.add(Private.class.cast(army.get(e))));
                    army.putIfAbsent(id, new LeutenantGeneralImpl(id, firstName, lastName, Double.valueOf(tokens[4]),
                            somePrivates));
                    break;
                case "engineer":
                    SpecialisedSoldier engineer = new EngineerImpl(id, firstName, lastName, Double.valueOf(tokens[4]), tokens[5], parseRepairs(tokens));
                    if (engineer.getCorps() != null)
                        army.putIfAbsent(id, engineer);
                    break;
                case "commando":
                    SpecialisedSoldier soldier = new CommandoImpl(id, firstName, lastName, Double.valueOf(tokens[4]), tokens[5], parseMissions(tokens));
                    if (soldier.getCorps() != null) {
                        army.putIfAbsent(id, soldier);
                    }
                    break;
                case "spy":
                    army.putIfAbsent(id, new SpyImpl(id, firstName, lastName, Integer.parseInt(tokens[4])));
                    break;
            }
        }
    }

    private static Collection<Mission> parseMissions(String... args) {
        Collection<Mission> rp = new ArrayList<>();
        for (int i = 6; i < args.length; i += 2) {
            Mission m = new MissionImpl(args[i], args[i + 1]);
            if (m.getState() != null) {
                rp.add(m);
            }
        }
        return rp;
    }

    private static Collection<Repair> parseRepairs(String... args) {
        Collection<Repair> rp = new ArrayList<>();
        for (int i = 6; i < args.length; i+= 2) {
            rp.add(new RepairImpl(args[i], Integer.parseInt(args[i + 1])));
        }
        return rp;
    }
}

/*
Input 1:
Private 1 Pesho Peshev 22.22
Commando 13 Stamat Stamov 13.1 Airforces
Private 222 Toncho Tonchev 80.08
LeutenantGeneral 3 Joro Jorev 100 222 1
End

Expected output 1:
Name: Pesho Peshev Id: 1 Salary: 22.22
Name: Stamat Stamov Id: 13 Salary: 13.10
Corps: Airforces
Missions:
Name: Toncho Tonchev Id: 222 Salary: 80.08
Name: Joro Jorev Id: 3 Salary: 100.00
Privates:
  Name: Toncho Tonchev Id: 222 Salary: 80.08
  Name: Pesho Peshev Id: 1 Salary: 22.22




Input 2:
Engineer 7 Pencho Penchev 12.23 Marines Boat 2 Crane 17
Commando 19 Penka Ivanova 150.15 Airforces HairyFoot finished Freedom inProgress
End


Expected output 2:
Name: Pencho Penchev Id: 7 Salary: 12.23
Corps: Marines
Repairs:
  Part Name: Boat Hours Worked: 2
  Part Name: Crane Hours Worked: 17
Name: Penka Ivanova Id: 19 Salary: 150.15
Corps: Airforces
Missions:
  Code Name: Freedom State: inProgress

 */
