package io.artcreativity;

import io.artcreativity.file.GestionDeFichiers;

import java.util.*;

public class TestMain {

    public static void main(String[] args) {
        Set<String> list = new HashSet<>();
        list.add("TOTO");
        list.add("Vehicle");
        list.add("Jacob");
        list.add("Isaac");
        list.add("Muhammed");
        list.add("Jean");
        list.add("Hanan");

        list.add("Jacob");
        list.add("Isaac");
        for (String str :
                list) {
            System.out.println(str);
        }
        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        list.forEach(System.err::println);

        Map<String, String> maps = new HashMap<>();
        maps.put("Wave 110",  "HONDA");
        maps.put("Mate 50",  "YAMAHA");
        maps.put("Sanya 900",  "SANYA");
        maps.put("Galaxy S21",  "Samsung");
        maps.put("Redme Note 12S",  "XIAOMI");
        maps.put("iPhone 14Pro",  "APPLE");

        maps.forEach((key, value) -> {
            System.out.println(key + ":" + value);
        });

        if(maps.containsKey("iPhone 14Pro")) {
            maps.replace("iPhone 14Pro", "ITEL");
        }
        if(maps.containsKey("Galaxy S21")) {
            System.err.println(maps.get("Galaxy S21"));
        }


        for(Map.Entry<String, String> entry : maps.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }

    }

    public static void buildList() {
        List<String> myList = new ArrayList<>();
        myList.add("TOTO");
        myList.add("Vehicle");
        myList.add("Jacob");
        myList.add("Isaac");
        myList.add("Muhammed");
        myList.add("Jean");
        myList.add("Hanan");

        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }

        myList.set(3, "Joseph");

        int index = myList.indexOf("Jean");
        if(index>=0) {
            myList.set(index, "Jeanne");
        }
        System.out.println();

        for (String str : myList) {
            System.out.println(str);
        }


        myList.add("Jacob");
        myList.add("Isaac");
        myList.add(2, "Jacob");
        myList.add(2, "Isaac");

        myList.forEach(System.err::println);

        while (myList.contains("Jacob")) {
            index = myList.indexOf("Jacob");
            myList.set(index, "Pierre");
        }

        for (int i = 0; i < myList.size(); i++) {
            System.out.println(myList.get(i));
        }

        myList.replaceAll(s -> s.equals("Pierre")? "Job" : s);

        for (String str : myList) {
            System.out.println(str);
        }
        System.err.println("END " + myList.size());
    }

}
