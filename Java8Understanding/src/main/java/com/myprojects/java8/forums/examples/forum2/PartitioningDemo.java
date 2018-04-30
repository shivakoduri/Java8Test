package com.myprojects.java8.forums.examples.forum2;

import com.myprojects.java8.forums.examples.forum2.model.Developer;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PartitioningDemo {

    public static void main(String... args) {
        //A Team has more than one developers. which programing languages are used by developers younger than 30
        //Collectors#partitiongBy expects a Predict(filter) which "partitions" all developers into two buckets by a "boolean"

        List<Developer> team = Arrays.asList(
                new Developer(18, "java"),
                new Developer(20, "java"),
                new Developer(35, "javascript"),
                new Developer(50, "javascript"),
                new Developer(50, "logo")
        );

        Map<Boolean, List<Developer>> youngerThan30 = team.stream().collect(Collectors.partitioningBy(d -> d.getAge() < 30));
        System.out.println("Developers younger than thirty are using:" + youngerThan30.get(true).stream().map(d -> d.getFavoriteLanguage()).collect(Collectors.toSet()));
        // Developers younger than thirty are using:[java]

        System.out.println("Developers older than thirty are using:" + youngerThan30.get(false).stream().map(d -> d.getFavoriteLanguage()).collect(Collectors.toSet()));
        // Developers older than thirty are using:[logo, javascript]
    }
}
