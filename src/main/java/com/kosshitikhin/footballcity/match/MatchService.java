package com.kosshitikhin.footballcity.match;

import com.kosshitikhin.footballcity.common.rest.NotFoundException;
import com.kosshitikhin.footballcity.league.League;
import com.kosshitikhin.footballcity.league.LeagueRepository;
import com.kosshitikhin.footballcity.match.dto.MatchDto;
import com.kosshitikhin.footballcity.match.dto.MatchRequest;
import com.kosshitikhin.footballcity.match.goals.Goal;
import com.kosshitikhin.footballcity.match.goals.GoalService;
import com.kosshitikhin.footballcity.team.Team;
import com.kosshitikhin.footballcity.team.TeamRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class MatchService {

    private final MatchRepository matchRepository;
    private final LeagueRepository leagueRepository;
    private final GoalService goalService;
    private final TeamRepository teamRepository;

    public MatchService(MatchRepository matchRepository,
                        LeagueRepository leagueRepository,
                        GoalService goalService,
                        TeamRepository teamRepository) {
        this.matchRepository = matchRepository;
        this.leagueRepository = leagueRepository;
        this.goalService = goalService;
        this.teamRepository = teamRepository;
    }

    public MatchDto getMatch(Long leagueId, Long matchId) {
        return null;
    }

    public MatchDto createMatch(Long leagueId, MatchRequest request) {
        League league = leagueRepository.findById(leagueId).orElseThrow(NotFoundException::league);
        List<Goal> goalsOfMatch = new ArrayList<>(goalService.getAllGoals().values());
        goalService.clear();
        Team homeTeam = teamRepository.findByName(request.getNameHomeTeam()).orElseThrow(NotFoundException::team);
        Team awayTeam = teamRepository.findByName(request.getNameAwayTeam()).orElseThrow(NotFoundException::team);
        LocalDateTime matchDay = request.getMatchDay();
        int tour = request.getTour();
        int homeGoals = request.getHomeGoals();
        int awayGoals = request.getAwayGoals();
        return new MatchDto(matchRepository.save(new Match(league, homeTeam, awayTeam, matchDay, tour, homeGoals, awayGoals)), goalsOfMatch);
    }


}
