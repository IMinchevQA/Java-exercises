package pr0304Barracks.core.factories;

import pr0304Barracks.contracts.Unit;
import pr0304Barracks.contracts.UnitFactory;
import pr0304Barracks.models.units.AbstractUnit;

public class UnitFactoryImpl implements UnitFactory {
    private static final String ABSTRACT_UNIT_NAME = AbstractUnit.class.getName(); //pr0304Barracks.models.units.AbstractUnit
	private static final String UNITS_PACKAGE_NAME = ABSTRACT_UNIT_NAME.substring(0, ABSTRACT_UNIT_NAME.lastIndexOf('.') + 1);//pr0304Barracks.models.units.

	@Override
	public Unit createUnit(String unitType) {
		Unit unit = null;
		try {
			Class<?> unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
			unit = (Unit) unitClass.getConstructor().newInstance();
		} catch (ReflectiveOperationException roex) {
			roex.printStackTrace();
		}
		// Solved TO_DO: implement for problem 3
//		throw new NotImplementedException();
		return unit;
	}
}
