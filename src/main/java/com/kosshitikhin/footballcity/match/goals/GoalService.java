package com.kosshitikhin.footballcity.match.goals;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class GoalService {

    public static Map<Integer, Goal> goalsOfMatch = new ConcurrentHashMap<>();

    @Transactional
    public void addGoal(GoalRequest request) {
        Goal goal = new Goal(request.getFirstName(), request.getSurname(), request.getMinute());
        goalsOfMatch.put(request.getRowGoal(), goal);
    }

    @Transactional
    public void deleteGoal(GoalRequest request) {
        goalsOfMatch.remove(request.getRowGoal());
    }

    @Transactional
    public void clear() {
        goalsOfMatch.clear();
    }

    public Map<Integer, Goal> getAllGoals() {
        return goalsOfMatch;
    }
}
