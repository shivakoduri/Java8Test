package com.myprojects.java8.forums.examples.forum1;

import com.myprojects.java8.forums.examples.model.Person1;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsToListDemo {

    public static void main(String... args){

        //Simple Map to List Example
        simpleMapToList();

        //Convert Map to List of User Object Example
        mapToListOfUserObject();

    }

    private static  void mapToListOfUserObject(){
        List<Person1> list = getMapData().entrySet().stream()
                .sorted(Comparator.comparing(e -> e.getKey()))
                .map(e->new Person1(e.getKey(), e.getValue()))
                .collect(Collectors.toList());

        list.forEach(l -> System.out.println("Id:"+ l.getId() + ", Name:" + l.getName()));
    }

    private static void simpleMapToList(){

        System.out.println("--Convert Map values to List --");
        List<String> valueList = getMapData().values().stream().collect(Collectors.toList());
        valueList.forEach(n -> System.out.println(n));

        System.out.println("--Convert Map Values to List using sort--");
        List<String> sortedValueList = getMapData().values().stream().sorted().collect(Collectors.toList());
        sortedValueList.forEach(n -> System.out.println(n));

        System.out.println("--Convert Map Keys to List--");
        List<Integer> keyList = getMapData().keySet().stream().collect(Collectors.toList());
        keyList.forEach(n -> System.out.println(n));

        System.out.println("--Convert Map keys to List using sort --");
        List<Integer> sortedKeyList = getMapData().keySet().stream().sorted().collect(Collectors.toList());
        sortedKeyList.forEach(n-> System.out.println(n));

    }

    private static Map<Integer,String> getMapData(){
        Map<Integer, String> map = new HashMap<>();
        map.put(23, "Mahesh");
        map.put(10, "Suresh");
        map.put(26, "Dinesh");
        map.put(11, "Kamlesh");

        return map;
    }
}
