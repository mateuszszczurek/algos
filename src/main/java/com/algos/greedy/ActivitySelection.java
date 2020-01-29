package com.algos.greedy;

import org.checkerframework.checker.units.qual.A;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.stream.IntStream;

import static com.google.common.collect.Maps.newHashMap;
import static com.google.common.collect.Maps.newTreeMap;
import static java.lang.Math.max;
import static java.util.Comparator.comparingInt;

//https://practice.geeksforgeeks.org/problems/activity-selection/0
//https://www.studytonight.com/data-structures/activity-selection-problem
//https://en.wikipedia.org/wiki/Activity_selection_problem
public class ActivitySection {

    public static void main(String[] args) {
        // 1 3 2 5 8 5
        // 2 4 6 7 9 9

        int[] start = {1, 3, 2, 5, 8, 5};
        int[] end = {2, 4, 6, 7, 9, 9};

        System.out.println(countActivities(start, end));
    }

    public static class Activity {

        private final int start;
        private final int end;

        Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }

    }

    private static int countActivities(int[] start, int[] end) {
        SortedSet<Activity> activities = new TreeSet<>(comparingInt(a -> a.end));
        for (int i = 0; i < start.length; i++) {
            activities.add(new Activity(start[i], end[i]));
        }

        int result = 0;
        int position = 0;
        for (Activity activity : activities) {
            if (activity.start >= position) {
                result++;
                position = activity.end + 1;
            }
        }

        return result;
    }

}
