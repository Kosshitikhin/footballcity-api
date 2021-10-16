package com.kosshitikhin.footballcity.goals;

import com.kosshitikhin.footballcity.common.rest.NotFoundException;
import com.kosshitikhin.footballcity.goals.dto.GoalDto;
import com.kosshitikhin.footballcity.goals.dto.GoalRequest;
import com.kosshitikhin.footballcity.league.League;
import com.kosshitikhin.footballcity.league.LeagueRepository;
import com.kosshitikhin.footballcity.match.Match;
import com.kosshitikhin.footballcity.match.MatchRepository;
import com.kosshitikhin.footballcity.player.Player;
import com.kosshitikhin.footballcity.player.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoalService {

    private final GoalRepository goalRepository;
    private final MatchRepository matchRepository;
    private final LeagueRepository leagueRepository;
    private final PlayerRepository playerRepository;

    public GoalService(GoalRepository goalRepository,
                       MatchRepository matchRepository,
                       LeagueRepository leagueRepository,
                       PlayerRepository playerRepository) {
        this.goalRepository = goalRepository;
        this.matchRepository = matchRepository;
        this.leagueRepository = leagueRepository;
        this.playerRepository = playerRepository;
    }

    public void addGoal(Long leagueId, Long matchId, Long teamId, GoalRequest request) {
        League league = leagueRepository.findById(leagueId).orElseThrow(NotFoundException::league);
        Match match = matchRepository.findById(matchId).orElseThrow(NotFoundException::match);
        Player player = playerRepository.findByFirstNameAndSurnameAndTeamId(request.getFirstName(), request.getSurname(), teamId).orElseThrow(NotFoundException::player);
        Goal goal = new Goal(request.getFirstName(), request.getSurname(), request.getMinute());
        goal.setLeague(league);
        goal.setMatch(match);
        goal.setPlayer(player);
        goalRepository.save(goal);
    }

    public void deleteGoal(Long leagueId, Long matchId, Long goalId) {
        Goal goal = goalRepository.findByLeagueIdAndMatchIdAndId(leagueId, matchId, goalId).orElseThrow(NotFoundException::goal);
        goalRepository.delete(goal);
    }

    public List<GoalDto> getAllGoalsOfPlayerFromLeague(Long leagueId, Long playerId) {
        return goalRepository.findAllByLeagueIdAndPlayerId(leagueId, playerId).stream()
                .map(GoalDto::new)
                .collect(Collectors.toList());
    }

    public List<GoalDto> getAllGoalsOfMatch(Long leagueId, Long matchId) {
        return goalRepository.findAllByLeagueIdAndMatchId(leagueId, matchId).stream()
                .map(GoalDto::new)
                .collect(Collectors.toList());
    }
}
