package com.myprojects.java8.examples.concepts;

import com.myprojects.java8.examples.concepts.Model.Employeee;
import com.myprojects.java8.examples.concepts.Model.PeekObject;
import com.myprojects.java8.examples.concepts.Model.Position;
import com.myprojects.java8.forums.examples.model.Employee;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;

import java.util.*;
import java.util.stream.Collectors;

public class AdvancedStreamExamples {

    public static List<PeekObject> limit_shortCircuiting(List<String> stringList, int limit) {
        return stringList
                .stream()
                .map(PeekObject::new)
                .limit(limit)
                .collect(Collectors.toList());
    }

    public static List<PeekObject> sorted_notShotCircuting(List<String> stringList, int limit) {
        return stringList
                .stream()
                .map(PeekObject::new)
                .sorted((left, right) -> left.getMessage().compareTo(right.getMessage()))
                .limit(limit)
                .collect(Collectors.toList());
    }


    public static Map<Long, Long> splitToMap(List<String> stringList) {
        return stringList.stream()
                .filter(StringUtils::isNotEmpty)
                .map(line -> line.split(","))
                .filter(array -> array.length == 2 && NumberUtils.isNumber(array[0]) && NumberUtils.isNumber(array[1]))
                .collect(Collectors.toMap(array -> Long.valueOf(array[0]),
                        array -> Long.valueOf(array[1]), (first, second) -> first));
    }

    public static List<String> gatherEmployeeSkills(List<Employeee> employees, Position... positions) {
        positions = positions == null || positions.length == 0 ? Position.values() : positions;
        List<Position> searchPositions = Arrays.stream(positions).collect(Collectors.toList());
        return employees == null ? Collections.emptyList() :
                employees
                        .stream()
                        .filter(employee -> searchPositions.contains(employee.getPosition()))
                        .flatMap(employeee -> employeee.getSkills().stream())
                        .distinct()
                        .collect(Collectors.toList());
    }

    public static String printEmployeeSkills(List<Employeee> employees, Position position) {
        List<String> skills = gatherEmployeeSkills(employees, position);
        return skills.stream()
                .collect(Collectors.joining("; ", "Our " + position + "s have: ", " skills"));
    }

    public static Map<Position, IntSummaryStatistics> salaryStatistics(List<Employeee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employeee::getPosition,
                        Collectors.summarizingInt(Employeee::getSalary)));
    }

    public static Position positionWithLowestAverageSalary(List<Employeee> employees) {
        return salaryStatistics(employees)
                .entrySet().stream()
                .sorted((entry1, entry2) -> Double.compare(entry1.getValue().getAverage(), entry2.getValue().getAverage()))
                .findFirst()
                .get()
                .getKey();
    }

    public static Map<Position, List<Employeee>> employeesPerPosition(List<Employeee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employeee::getPosition, Collectors.toList()));
    }

    public static Map<Position, List<String>> employeeNamesPerPosition(List<Employeee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employeee::getPosition,
                        Collectors.mapping(Employeee::getName, Collectors.toList())));
    }

    public static Map<Position, Long> employeesCountPerPosition(List<Employeee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employeee::getPosition, Collectors.counting()));
    }

    public static List<Employeee> employeesWithDuplicateFirstName(List<Employeee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employeee::getFirstName, Collectors.toList()))
                .entrySet().stream()
                .filter(entry -> entry.getValue().size() > 1)
                .flatMap(entry -> entry.getValue().stream())
                .collect(Collectors.toList());
    }

}
