package pr0304Barracks.core.factories;


import pr0304Barracks.contracts.*;
import pr0304Barracks.core.commands.Command;

import java.lang.reflect.Field;

public class CommandInterpreterImpl implements CommandInterpreter {

    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }


    @Override
    public Executable interpretCommand(String[] data, String commandName) {
        String commandClassName = Command.class.getName();
        String commandPackageName = commandClassName.substring(0, commandClassName.lastIndexOf('.') + 1);

        commandName = commandPackageName + Character.toUpperCase(commandName.charAt(0)) + commandName.substring(1);
        Command commandInstance = null;

        try {
            Class<?> commandClass = Class.forName(commandName);
            commandInstance = (Command) commandClass.getConstructor(String[].class).newInstance(Object.class.cast(data));
            this.injectDependencies(commandInstance, commandClass);

        } catch (ReflectiveOperationException ex) {
            ex.printStackTrace();
        }

        return commandInstance;
    }

    private void injectDependencies(Executable commandInstance, Class<?> commandClass) throws IllegalAccessException {
        Field[] fieldsCommandClass = commandClass.getDeclaredFields();
        Field[] fieldsCommandInterpreterImpl = CommandInterpreterImpl.class.getDeclaredFields();

        for (Field field : fieldsCommandClass) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true);

                for (Field thisField : fieldsCommandInterpreterImpl) {
                    if (thisField.getType().equals(field.getType())) {
                        thisField.setAccessible(true);
                        field.set(commandInstance, thisField.get(this));
                    }
                }
            }
        }
    }
}
