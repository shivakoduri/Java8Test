package com.myprojects.java8.forums.examples.forum1;

import java.time.*;

public class TimePeriodDemo {

    public static void main(String... args) {

        //java.time.Period
        periodDemo();

        //java.time.Year
        yearDemo();

        //java.time.YearMonth
        yearMonthDemo();

        //java.time.ZonedDataTime
        zonedDateTimeDemo();

        //java.time.MonthDay
        monthDayDemo();

        //java.time.Month
        monthDemo();

        //java.time.OffsetDateTime
        offsetDateTimeDemo();

        //java.time.OffsetTime
        offsetTimeDemo();
    }

    private static void offsetTimeDemo() {
        OffsetTime offTime = OffsetTime.now();
        System.out.println(offTime.getHour() + " hour");
        System.out.println(offTime.getMinute() + " minute");
        System.out.println(offTime.getSecond() + " second");
    }

    private static void offsetDateTimeDemo() {
        OffsetDateTime offsetDT = OffsetDateTime.now();
        System.out.println(offsetDT.getDayOfMonth());
        System.out.println(offsetDT.getDayOfYear());
        System.out.println(offsetDT.getDayOfWeek());
        System.out.println(offsetDT.toLocalDate());
    }

    private static void monthDemo() {
        System.out.println(Month.MARCH);
        System.out.println(Month.MARCH.getValue());
        System.out.println(Month.of(3));
        System.out.println(Month.valueOf("MARCH"));
    }

    private static void monthDayDemo() {
        MonthDay mday = MonthDay.now();
        System.out.println(mday.getDayOfMonth());
        System.out.println(mday.getMonth());
        System.out.println(mday.atYear(2014));
    }

    private static void zonedDateTimeDemo() {
        System.out.println(ZonedDateTime.now());
        ZonedDateTime zdt = ZonedDateTime.parse("2018-04-05T10:15:30+01:00[Europe/Paris]");
        System.out.println("getDayOfYear:" + zdt.getDayOfYear());
        System.out.println("zdt.getYear():" + zdt.getYear());
    }

    private static void yearMonthDemo() {
        System.out.println("YearMonth.now():" + YearMonth.now());
        System.out.println("getMonthValue:" + YearMonth.parse("2014-09").getMonthValue());
        System.out.println("getYear():" + YearMonth.parse("2014-09").getYear());
        System.out.println("isLeapYear():" + YearMonth.parse("2014-09").isLeapYear());
    }

    private static void yearDemo() {
        System.out.println("Year.now():" + Year.now());
        System.out.println("Year.MAX_VALUE:" + Year.MAX_VALUE);
        System.out.println("Year.isLeap(2014):" + Year.isLeap(2014));
        System.out.println("Year.isLeap(2016):" + Year.isLeap(2016));
    }

    private static void periodDemo() {
        LocalDate start = LocalDate.now();
        System.out.println("Period.between:" + Period.between(start, LocalDate.MAX).getDays());
        System.out.println("Period.ofDays:" + Period.ofDays(5).getDays());
    }


}
