package pr0304Barracks;

//import pr0304Barracks.contracts.Repository;
//import pr0304Barracks.contracts.Runnable;
//import pr0304Barracks.contracts.UnitFactory;
//import pr0304Barracks.core.Engine;
//import pr0304Barracks.core.factories.UnitFactoryImpl;
//import pr0304Barracks.data.UnitRepository;

import pr0304Barracks.contracts.CommandInterpreter;
import pr0304Barracks.contracts.Repository;
import pr0304Barracks.contracts.UnitFactory;
import pr0304Barracks.core.Engine;
import pr0304Barracks.core.factories.CommandInterpreterImpl;
import pr0304Barracks.core.factories.UnitFactoryImpl;
import pr0304Barracks.data.UnitRepository;
import pr0304Barracks.contracts.Runnable;

public class Main {

	public static void main(String[] args) {
		Repository repository = new UnitRepository();
		UnitFactory unitFactory = new UnitFactoryImpl();
//		Runnable engine = new Engine(repository, unitFactory);
		CommandInterpreter interpreter = new CommandInterpreterImpl(repository, unitFactory);
		Runnable engine = new Engine(interpreter);
		engine.run();
	}
}

/*
Ex. 04:
retire Archer
add Pikeman
add Pikeman
add Gunner
add Horseman
add Archer
add Gunner
add Gunner
add Horseman
report
retire Gunner
retire Archer
report
retire Swordsman
retire Archer
fight


Expected output 4:
No such units in repository.
Pikeman added!
Pikeman added!
Gunner added!
Horseman added!
Archer added!
Gunner added!
Gunner added!
Horseman added!
Archer -> 1
Gunner -> 3
Horseman -> 2
Pikeman -> 2
Gunner retired!
Archer retired!
Archer -> 0
Gunner -> 3
Horseman -> 2
Pikeman -> 2
No such units in repository.
No such units in repository.




Ex.: 03
Input 1:
add Swordsman
add Archer
add Pikeman
report
add Pikeman
add Pikeman
report
fight

Expected output 1:
Swordsman added!
Archer added!
Pikeman added!
Archer -> 1
Pikeman -> 1
Swordsman -> 1
Pikeman added!
Pikeman added!
Archer -> 1
Pikeman -> 3
Swordsman -> 1

Input 2:
add Pikeman
add Pikeman
add Gunner
add Horseman
add Archer
add Gunner
add Gunner
add Horseman
report
fight

Expected output 2:
Pikeman added!
Pikeman added!
Gunner added!
Horseman added!
Archer added!
Gunner added!
Gunner added!
Horseman added!
Archer -> 1
Gunner -> 3
Horseman -> 2
Pikeman -> 2



 */
