package com.kosshitikhin.footballcity.goals;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("matches/{matchId}/goals")
public class GoalController {

    private final GoalService goalService;

    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @PutMapping("add")
    public void addGoal(@PathVariable Long matchId, @RequestBody GoalRequest request) {
        goalService.addGoal(matchId, request);
    }

    @PutMapping("{goalId}/delete")
    public void deleteGoal(@PathVariable Long matchId, @PathVariable Long goalId) {
        goalService.deleteGoal(matchId, goalId);
    }
}
