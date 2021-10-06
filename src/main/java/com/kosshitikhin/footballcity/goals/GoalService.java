package com.kosshitikhin.footballcity.goals;

import com.kosshitikhin.footballcity.common.rest.NotFoundException;
import com.kosshitikhin.footballcity.match.Match;
import com.kosshitikhin.footballcity.match.MatchRepository;
import org.springframework.stereotype.Service;

@Service
public class GoalService {

    private final GoalRepository goalRepository;
    private final MatchRepository matchRepository;

    public GoalService(GoalRepository goalRepository,
                       MatchRepository matchRepository) {
        this.goalRepository = goalRepository;
        this.matchRepository = matchRepository;
    }

    public void addGoal(Long matchId, GoalRequest request) {
        Match match = matchRepository.findById(matchId).orElseThrow(NotFoundException::match);
        Goal goal = new Goal(request.getFirstName(), request.getSurname(), request.getMinute());
        match.addGoal(goalRepository.save(goal));
        matchRepository.save(match);
    }

    public void deleteGoal(Long matchId, Long goalId) {
        Match match = matchRepository.findById(matchId).orElseThrow(NotFoundException::match);
        Goal goal = goalRepository.findById(goalId).orElseThrow(NotFoundException::goal);
        match.deleteGoal(goal);
        goalRepository.delete(goal);
        matchRepository.save(match);
    }
}
