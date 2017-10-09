package someCrazyReflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;
public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException, ClassNotFoundException, InvocationTargetException {
        Class reflectionClass = Reflection.class;
        Annotation[] annotations = reflectionClass.getAnnotations();


        String debug = "";


//        //Ex.1 : Reflection
//        Class reflectionClass = Reflection.class;
//        System.out.println(reflectionClass);
//
//        Class superClass = reflectionClass.getSuperclass();
//        System.out.println(superClass);
//
//        Class[] reflectionClassInterfaces = reflectionClass.getInterfaces();
//        Stream.of(reflectionClassInterfaces).forEach(i -> System.out.println(i));
//
//        Reflection reflection = (Reflection) reflectionClass.newInstance();
//        System.out.println(reflection);


//        //Ex.2: Getters and Setters
//        Class reflectionClass = Reflection.class;
//        Method[] allMethods = reflectionClass.getDeclaredMethods();
//
//        Method[] allGetters = Stream.of(allMethods).filter(e -> e.getName().startsWith("get")).toArray(g -> new Method[g]);
//
//        Method[] allSetters = Stream.of(allMethods).filter(e -> e.getName().startsWith("set")).toArray(s -> new Method[s]);
//
//        Arrays.sort(allGetters, Comparator.comparing(m -> m.getName()));
//        Stream.of(allGetters).forEach(g -> System.out.println(String.format("%s will return %s",
//                g.getName(), g.getReturnType())));
//
//        Arrays.sort(allSetters, Comparator.comparing(m -> m.getName()));
//        Stream.of(allSetters).forEach(s -> {
//            if (void.class.equals(s.getReturnType())) {
//                if (s.getParameterCount() == 1) {
//                    System.out.println(String.format("%s and will set field of %s",
//                            s.getName(), s.getParameterTypes()[0]));
//                }
//            }
//        });

        //Ex.3: High Quality Mistakes
//        Class reflectionClass = Reflection.class;
        Reflection rf = (Reflection) reflectionClass.getConstructor().newInstance();
//        Method[] allMethods = reflectionClass.getDeclaredMethods();
//
//        Method[] allGetters = Stream.of(allMethods).filter(e -> e.getName().startsWith("get")).toArray(g -> new Method[g]);
//
//        Method[] allSetters = Stream.of(allMethods).filter(e -> e.getName().startsWith("set")).toArray(s -> new Method[s]);
//
//        Field[] allFields = reflectionClass.getDeclaredFields();
//
//        Arrays.sort(allFields,Comparator.comparing(m -> m.getName()));
//        Stream.of(allFields).forEach(f -> {
//            if (!Modifier.isPrivate(f.getModifiers())) {
//                System.out.println(String.format("%s must be private!", f.getName()));
//            }
//        });
//
//
//        Arrays.sort(allGetters, Comparator.comparing(m -> m.getName()));
//        Stream.of(allGetters).forEach(g -> {
//            if (!Modifier.isPublic(g.getModifiers()))
//            System.out.println(String.format("%s have to be public!",
//                    g.getName()));
//        });
//
//        Arrays.sort(allSetters, Comparator.comparing(m -> m.getName()));
//        Stream.of(allSetters).forEach(s -> {
//            if (void.class.equals(s.getReturnType())) {
//                if (s.getParameterCount() == 1) {
//                    if (!Modifier.isPrivate(s.getModifiers())) {
//                        System.out.println(String.format("%s have to be private!",
//                                s.getName()));
//                    }
//                }
//            }
//        });



//        //TESTS
//        Class<?> reflectionClass = Class.forName("someCrazyReflection.Reflection");
//
//        // Some METHOD tests.
//        Method[] allMethods = reflectionClass.getDeclaredMethods();
//        Reflection rf = (Reflection) reflectionClass.getConstructor().newInstance();
//        Method getNameMethod = allMethods[1];
////        getNameMethod.setAccessible(true);
////        Object o1 = getNameMethod.invoke(rf); //Works only for "public" accessible NON-static methods, otherwise "getNameMethod.setAccessible(true)" is necessary!!!
////        Object o2 = getNameMethod.invoke(null); // Works also with static methods;
//
//        int nameMethodModifier = getNameMethod.getModifiers();
//
//        System.out.println(Modifier.toString(nameMethodModifier));
//
//
//        String debug = "";
//


//    //        Some FIELD tests
//        Field[] allFields = reflectionClass.getDeclaredFields();
//        Reflection rf = (Reflection) reflectionClass.getConstructor().newInstance();
//        Field nickNameField = allFields[0];
//        nickNameField.setAccessible(true);
//        Object nickNamObj = nickNameField.get(nickNameField.getType()); //This WON'T work for non-static fields
        //nickNameField.set WON'T work while the nickNameField is "final"!!! - pls. see the next row
//        nickNameField.set(nickNameField.getType(), "Cow");

//        Reflection rf = (Reflection) reflectionClass.getConstructor().newInstance();
//        Field nameField = allFields[1];
//        nameField.setAccessible(true);
////        Object nameObj = nameField.get(nameField.getType()); //This WON'T work because of NON-static nameField
//        Object nameObj = nameField.get(rf); //WORKS
////        nameField.set(nameField.getType(), "Cow"); //WON'T work because of NON-static nameField;
//        nameField.set(rf, "Cow");
//        String debug = "";




//        //Crate constructor and Instantiate an object!!!
//        Constructor[] cons = reflectionClass.getDeclaredConstructors();
//        Class[] parameterTypes = null;
//        for (Constructor con : cons) {
//            if (con.getParameterCount() == 4) {
//                parameterTypes = con.getParameterTypes();
//                con.setAccessible(true);
//                //Instantiate an object with the constructor found - this works OK.
//                Object obj = con.newInstance(new Object[]{"Str1", "Str2", "Str3", 5});
//                String debug = "";
//            }
//        }
//        //Getting the constructor with parameterTypes - DOES NOT WORK (java.lang.NoSuchMethodException)
//        Constructor constructor = reflectionClass.getConstructor(parameterTypes);
//        constructor.setAccessible(true);
//        Object object = constructor.newInstance("str1", "str2", "str3", 5);
//        String debug = "";
    }
}
