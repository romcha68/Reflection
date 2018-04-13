package com.brainacad.oop.testreflection1;

import java.util.Arrays;
import java.util.stream.Collectors;

import java.lang.reflect.Modifier;


public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class c = Class.forName(MyClass.class.getCanonicalName());
        MyClass instance = (MyClass) c.newInstance();


        System.out.println("ClassName: " + instance.getClass().getCanonicalName());
        System.out.println("\tModifiers: \n\t\t" + getModifiersName(instance.getClass().getModifiers()));

        System.out.println("\tFields: ");
        System.out.println(Arrays.stream(instance.getClass().getDeclaredFields())
                .map(field -> {
                    StringBuilder fieldDeclaration = new StringBuilder("");
                    fieldDeclaration.append("\t\tField:\n");
                    fieldDeclaration.append("\t\t\tName: " + field.getName() + "\n");
                    fieldDeclaration.append("\t\t\tModifiers: " + getModifiersName(field.getModifiers()) + "\n");
                    fieldDeclaration.append("\t\t\tType: " + field.getType());

                    return fieldDeclaration.toString();
                }).collect(Collectors.joining("\n")));

        System.out.println("\tConstructors: ");
        Arrays.stream(instance.getClass().getDeclaredConstructors())
                .forEach(constructor ->
                        System.out.println("\t\tConstructor: " + Arrays.stream(constructor.getParameterTypes())
                                .map(field -> field.getName())
                                .collect(Collectors.joining(", "))));

        System.out.println("\tMethods: ");
        System.out.println(Arrays.stream(instance.getClass().getDeclaredMethods())
                .map(method -> {
                    StringBuilder methodDeclaration = new StringBuilder("");
                    methodDeclaration.append("\t\tMethod:\n");
                    methodDeclaration.append("\t\t\tName: " + method.getName() + "\n");
                    methodDeclaration.append("\t\t\tModifiers: " + getModifiersName(method.getModifiers()) + "\n");
                    methodDeclaration.append("\t\t\tReturn type: " + method.getReturnType().getName() + "\n");
                    methodDeclaration.append("\t\t\tParam types: " + Arrays.stream(method.getParameterTypes())
                            .map(parameterType -> parameterType.getName())
                            .collect(Collectors.joining(", ")));

                    return methodDeclaration.toString();
                }).collect(Collectors.joining("\n")));
    }

    private static String getModifiersName(final int modifiersNumber) {
        StringBuilder name = new StringBuilder("");
        if (Modifier.isAbstract(modifiersNumber))
            name.append("abstract ");

        if (Modifier.isFinal(modifiersNumber))
            name.append("final ");

        if (Modifier.isInterface(modifiersNumber))
            name.append("interface ");

        if (Modifier.isPrivate(modifiersNumber))
            name.append("private ");

        if (Modifier.isNative(modifiersNumber))
            name.append("native ");

        if (Modifier.isProtected(modifiersNumber))
            name.append("protected ");

        if (Modifier.isPublic(modifiersNumber))
            name.append("public ");

        if (Modifier.isStatic(modifiersNumber))
            name.append("static ");

        if (Modifier.isStrict(modifiersNumber))
            name.append("strict ");

        if (Modifier.isSynchronized(modifiersNumber))
            name.append("synchronized ");

        if (Modifier.isTransient(modifiersNumber))
            name.append("transient ");

        if (Modifier.isVolatile(modifiersNumber))
            name.append("volatile ");

        if (modifiersNumber == 0)
            name.append("none");

        return name.toString();
    }
}
