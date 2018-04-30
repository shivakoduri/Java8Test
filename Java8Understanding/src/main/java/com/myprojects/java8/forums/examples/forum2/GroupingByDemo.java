package com.myprojects.java8.forums.examples.forum2;

import com.myprojects.java8.forums.examples.forum2.model.Developer;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByDemo {

    public static void main(String... args) {
        //A team has more than one developers.
        //Group developers by their favorite language. Collectors#groupingBy groups classes by properties out-of-the-box

        List<Developer> team = Arrays.asList(
                new Developer(18, "java"),
                new Developer(20, "java"),
                new Developer(35, "javascript"),
                new Developer(50, "javascript"),
                new Developer(50, "logo")
        );

        Map<String, List<Developer>> developerByLanguages = team.stream()
                .collect(
                        Collectors.groupingBy(
                                Developer::getFavoriteLanguage));
        System.out.println(developerByLanguages);

        //{java=[Developer{age=18, favoriteLanguage='java'}, Developer{age=20, favoriteLanguage='java'}],
        // logo=[Developer{age=50, favoriteLanguage='logo'}],
        // javascript=[Developer{age=35, favoriteLanguage='javascript'}, Developer{age=50, favoriteLanguage='javascript'}]}

        Map<String, Double> favoriteLanguageByAverageAge = team.stream()
                .collect(
                        Collectors.groupingBy(
                                Developer::getFavoriteLanguage,
                                Collectors.averagingInt(Developer::getAge)));

        //{java=[Developer{age=18, favoriteLanguage='java'}, Developer{age=20, favoriteLanguage='java'}],
        // logo=[Developer{age=50, favoriteLanguage='logo'}],
        // javascript=[Developer{age=35, favoriteLanguage='javascript'}, Developer{age=50, favoriteLanguage='javascript'}]}


    }
}
