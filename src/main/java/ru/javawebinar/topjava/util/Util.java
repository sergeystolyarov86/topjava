package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Util {
    private static Map<Integer, Integer> caloriesByDay = new HashMap<>();

    public static boolean isBetweenHalfOpen(LocalTime lt, LocalTime startTime, LocalTime endTime) {
        return lt.compareTo(startTime) >= 0 && lt.compareTo(endTime) <0;
    }

    public static void ValueFieldByDay(List<UserMeal> list) {
        LocalDateTime tmpTime = list.get(0).getDateTime();
        int sumByDayCalories = 0;
        for (int i = 0; i < list.size(); i++) {
            if (tmpTime.getDayOfYear() == list.get(i).getDateTime().getDayOfYear()) sumByDayCalories += list.get(i).getCalories();
            if (tmpTime.getDayOfYear() < list.get(i).getDateTime().getDayOfYear() || i == list.size() - 1) {
                caloriesByDay.put(tmpTime.getDayOfYear(), sumByDayCalories);
                tmpTime = list.get(i).getDateTime();
                sumByDayCalories = list.get(i).getCalories();
            }
        }
    }

    public static Map<Integer, Integer> getCaloriesByDay() {
        return caloriesByDay;
    }
}
