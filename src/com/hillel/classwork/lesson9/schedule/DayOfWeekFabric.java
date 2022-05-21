package com.hillel.classwork.lesson9.schedule;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DayOfWeekFabric {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input day");
        System.out.println(Arrays.toString(DayOfWeeks.values()));
        String day = reader.readLine().toUpperCase();
        DayOfWeeks dayOfWeek = DayOfWeeks.valueOf(day);

        Map<DayOfWeeks,String> map = new HashMap<>();
        map.put(DayOfWeeks.MONDAY,"Today we are putting in order");
        map.put(DayOfWeeks.TUESDAY,"Today we are tiding the living room");
        map.put(DayOfWeeks.WEDNESDAY,"Today we are doing vacuum cleaning");
        map.put(DayOfWeeks.THURSDAY,"Today we are cleaning the windows");
        map.put(DayOfWeeks.FRIDAY,"Today we are pouring flowers");
        map.put(DayOfWeeks.SATURDAY,"5");
        map.put(DayOfWeeks.SUNDAY,"6");



        System.out.println(day + " " + map.get(dayOfWeek));

        switch (dayOfWeek){
            case MONDAY:
                System.out.println("Today we are putting in order");
                break;
            case TUESDAY:
                System.out.println("Today we are tiding the living room");
                break;
            case WEDNESDAY:
                System.out.println("Today we are doing vacuum cleaning");
                break;
            case THURSDAY:
                System.out.println("Today we are cleaning the windows");
                break;
            case FRIDAY:
                System.out.println("Today we are 1");
                break;
            case SATURDAY:
                System.out.println("Today we are 2");
                break;
            case SUNDAY:
                System.out.println("Today we are 3");
                break;
        }
    }
}
