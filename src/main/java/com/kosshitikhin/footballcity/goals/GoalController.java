package com.kosshitikhin.footballcity.goals;

import com.kosshitikhin.footballcity.goals.dto.GoalDto;
import com.kosshitikhin.footballcity.goals.dto.GoalRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("leagues/{leagueId}")
public class GoalController {

    private final GoalService goalService;

    public GoalController(GoalService goalService) {
        this.goalService = goalService;
    }

    @PostMapping("matches/{matchId}/goals/add")
    public void addGoal(@PathVariable Long leagueId, @PathVariable Long matchId, @RequestBody GoalRequest request) {
        goalService.addGoal(leagueId, matchId, request);
    }

    @DeleteMapping("matches/{matchId}/goals/{goalId}/delete")
    public void deleteGoal(@PathVariable Long leagueId, @PathVariable Long matchId, @PathVariable Long goalId) {
        goalService.deleteGoal(leagueId, matchId, goalId);
    }

    @GetMapping("players/{playerId}/goals")
    public List<GoalDto> getAllGoalsOfPlayerFromLeague(@PathVariable Long leagueId, @PathVariable Long playerId) {
        return goalService.getAllGoalsOfPlayerFromLeague(leagueId, playerId);
    }
}
