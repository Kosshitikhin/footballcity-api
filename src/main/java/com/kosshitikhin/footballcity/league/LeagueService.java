package com.kosshitikhin.footballcity.league;

import com.kosshitikhin.footballcity.common.rest.NotFoundException;
import com.kosshitikhin.footballcity.league.dto.LeagueDto;
import com.kosshitikhin.footballcity.league.dto.LeagueRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeagueService {

    private final LeagueRepository leagueRepository;

    public LeagueService(LeagueRepository leagueRepository) {
        this.leagueRepository = leagueRepository;
    }

    public LeagueDto getOneLeague(Long leagueId) {
        League league = leagueRepository.findById(leagueId).orElseThrow(NotFoundException::league);
        return new LeagueDto(league);
    }

    public List<LeagueDto> getAllLeagues() {
        return leagueRepository.findAll()
                .stream()
                .map(LeagueDto::new)
                .collect(Collectors.toList());
    }

    public LeagueDto createLeague(LeagueRequest request) {
        League league = new League(request.getName(), request.getStartYear(), request.getEndYear());
        return new LeagueDto(leagueRepository.save(league));
    }

    public LeagueDto updateLeague(Long leagueId, LeagueRequest request) {
        League league = leagueRepository.findById(leagueId).orElseThrow(NotFoundException::league);
        league.setName(request.getName());
        league.setStartYear(request.getStartYear());
        league.setEndYear(request.getEndYear());
        return new LeagueDto(leagueRepository.save(league));
    }

    @Transactional
    public void deleteLeague(Long leagueId) {
        leagueRepository.deleteById(leagueId);
    }
}
