package com.swellshinider.main.store;

import com.swellshinider.instruments.*;
import com.swellshinider.enumerators.Metal;
import com.swellshinider.enumerators.TradeMark;
import com.swellshinider.enumerators.Type;
import com.swellshinider.enumerators.Wood;
import com.swellshinider.specs.Instruments;

import java.io.File;
import java.io.IOException;
import java.net.JarURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class Inventory {

    public static int instrumentsToGenerate;
    public static List<Instruments> allInstruments = new ArrayList<>();

    private static final List<Class<? extends Instruments>> instrumentsType = new ArrayList<>();

    static {
        try {
            var classes = getClassesForPackage("com.swellshinider.instruments");

            for(var clazz: classes){
                //noinspection unchecked
                instrumentsType.add((Class<? extends Instruments>) clazz);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void generateInstruments() {

        long serial = 1L;
        float price = generateNewPrice();

        int i = 0;
        int j = 0;

        while ( i < instrumentsToGenerate) {

            Class<? extends Instruments> insClass = instrumentsType.get(j);

            switch (insClass.getSimpleName()) {
                case "Flute": {
                    if (new Random().nextFloat() > 0.5f)
                        allInstruments.add(new Flute(serial, price, TradeMark.getRandom(),
                                Wood.getRandom(), Metal.NONE));
                    else
                        allInstruments.add(new Flute(serial, price, TradeMark.getRandom(),
                                Wood.NONE, Metal.getRandom()));
                }
                break;
                case "Guitar": {
                    allInstruments.add(new Guitar(serial, price, TradeMark.getRandom(),
                            Wood.getRandom(), Wood.getRandom(), Type.getRandom(),
                            (new Random().nextFloat() >= 0.5f) ? 6 : 7));
                }
                break;
                case "Mandolin": {
                    allInstruments.add(new Mandolin(serial, price, TradeMark.getRandom(),
                            Wood.getRandom(), Wood.getRandom(), Type.getRandom()));
                }
                break;
                case "Battery": {
                    allInstruments.add(new Battery(serial, price, TradeMark.getRandom(),
                            Metal.getRandom(), Wood.getRandom(), Type.getRandom()));
                }
                break;
                case "Violin": {
                    allInstruments.add(new Violin(serial, price, TradeMark.getRandom(),
                            Wood.getRandom(), Wood.getRandom(), Type.getRandom()));
                }
                break;
                case "Saxophone": {
                    allInstruments.add(new Saxophone(serial, price, TradeMark.getRandom(), Metal.getRandom()));
                }
                break;
                case "Tambourine":{
                    allInstruments.add(new Tambourine(serial, price, TradeMark.getRandom(),
                            Wood.getRandom(), (int)((Math.random() * (15 - 5)) + 5)));
                }
                break;
                default:
                    throw new IllegalStateException("Unexpected value: " + insClass.getSimpleName());
            }

            serial += 1L;
            price = generateNewPrice();
            j = ((1 + j) >= instrumentsType.size()) ? 0 : ++j;
            i++;
        }
    }

    private static float generateNewPrice(){
        return (float)((Math.random() * (5000 - 500)) + 500);
    }

    // Search Classes
    private static void checkDirectory(File directory, String pckgname, ArrayList<Class<?>> classes) throws ClassNotFoundException {
        File tmpDirectory;

        if (directory.exists() && directory.isDirectory()) {
            final String[] files = directory.list();

            assert files != null;
            for (final String file : files) {
                if (file.endsWith(".class")) {
                    try {
                        classes.add(Class.forName(pckgname + '.'
                                + file.substring(0, file.length() - 6)));
                    } catch (final NoClassDefFoundError e) {
                        // do nothing. this class hasn't been found by the
                        // loader, and we don't care.
                    }
                } else if ((tmpDirectory = new File(directory, file))
                        .isDirectory()) {
                    checkDirectory(tmpDirectory, pckgname + "." + file, classes);
                }
            }
        }
    }

    private static void checkJarFile(JarURLConnection connection, String pckgname, ArrayList<Class<?>> classes) throws ClassNotFoundException, IOException {
        final JarFile jarFile = connection.getJarFile();
        final Enumeration<JarEntry> entries = jarFile.entries();
        String name;

        for (JarEntry jarEntry; entries.hasMoreElements()
                && ((jarEntry = entries.nextElement()) != null);) {
            name = jarEntry.getName();

            if (name.contains(".class")) {
                name = name.substring(0, name.length() - 6).replace('/', '.');

                if (name.contains(pckgname)) {
                    classes.add(Class.forName(name));
                }
            }
        }

    }

    public static ArrayList<Class<?>> getClassesForPackage(String pckgname) throws ClassNotFoundException {

        ArrayList<Class<?>> classes = new ArrayList<>();

        try {
            final ClassLoader cld = Thread.currentThread().getContextClassLoader();

            final Enumeration<URL> resources = cld.getResources(pckgname
                    .replace('.', '/'));

            URLConnection connection;

            for (URL url; resources.hasMoreElements() && ((url = resources.nextElement()) != null);) {
                try {
                    connection = url.openConnection();

                    if (connection instanceof JarURLConnection) {
                        checkJarFile((JarURLConnection) connection, pckgname,
                                classes);
                    } else if (connection != null) {
                        checkDirectory(
                                new File(URLDecoder.decode(url.getPath(), StandardCharsets.UTF_8)), pckgname, classes);
                    } else
                        throw new ClassNotFoundException(pckgname + " ("
                                + url.getPath()
                                + ") does not appear to be a valid package");
                } catch (final IOException ioex) {
                    throw new ClassNotFoundException(
                            "IOException was thrown when trying to get all resources for "
                                    + pckgname, ioex);
                }
            }
        } catch (final NullPointerException ex) {
            throw new ClassNotFoundException(
                    pckgname
                            + " does not appear to be a valid package (Null pointer exception)",
                    ex);
        } catch (final IOException ioex) {
            throw new ClassNotFoundException(
                    "IOException was thrown when trying to get all resources for "
                            + pckgname, ioex);
        }

        return classes;
    }
}
