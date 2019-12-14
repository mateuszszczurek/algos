package com.algos.recursion;

import lombok.Data;

import java.util.*;
import java.util.stream.Stream;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;
import static java.util.Collections.emptyList;
import static java.util.List.of;
import static java.util.function.Function.identity;
import static java.util.stream.Collectors.toMap;

public class JobPlanner {

    @Data
    private static final class Job {

        private final String name;
        private final int duration;
        private final List<Job> runAfter;

    }

    public static int calculateDuration(String jobName, Map<String, Job> jobs) {
        return calculateDuration(newHashSet(), jobName, jobs);
    }

    public static int calculateDuration(Set<String> visited, String jobName, Map<String, Job> jobs) {
        Job job = jobs.get(jobName);
        List<Job> runAfter = job.getRunAfter();

        if(runAfter.isEmpty()) {
            visited.add(job.getName());
            return job.getDuration();
        }

        int totalTime = 0;
        for (Job jobToBeRun : runAfter) {
            if(visited.contains(jobToBeRun.getName())) {
                continue;
            }
            int calculatedDuration = calculateDuration(visited, jobToBeRun.getName(), jobs);
            totalTime += calculatedDuration;
        }

        visited.add(job.getName());
        return totalTime + job.getDuration();
    }

    public static void main(String[] args) {
        Job dogWalk = new Job("dogWalk", 10, emptyList());

        Job breakFest = new Job("breakFest", 15, of(dogWalk));
        Job work = new Job("work", 15, of(dogWalk, breakFest));

        Job eatDinner = new Job("eatDinner", 5, of(work, dogWalk, breakFest));
        Map<String, Job> collect = Stream.of(dogWalk, breakFest, work, eatDinner).collect(toMap(Job::getName, identity()));

        System.out.println(calculateDuration("eatDinner", collect));
    }

}
