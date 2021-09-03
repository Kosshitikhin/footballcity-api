package com.kosshitikhin.footballcity.coach;

import com.kosshitikhin.footballcity.coach.dto.CoachDto;
import com.kosshitikhin.footballcity.coach.dto.CoachRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("leagues/{leagueId}/teams/{teamId}/coach")
public class CoachController {

    private final CoachService coachService;

    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    @GetMapping("{coachId}")
    public CoachDto getCoach(@PathVariable Long leagueId,
                             @PathVariable Long teamId,
                             @PathVariable Long coachId) {
        return coachService.getCoach(leagueId, teamId, coachId);
    }

    @PostMapping
    public CoachDto addCoach(@PathVariable Long leagueId,
                             @PathVariable Long teamId,
                             @RequestBody CoachRequest request) {
        return coachService.addCoach(leagueId, teamId, request);
    }

    @PutMapping("{coachId}")
    public CoachDto updateCoach(@PathVariable Long leagueId,
                                @PathVariable Long teamId,
                                @PathVariable Long coachId,
                                @RequestBody CoachRequest request) {
        return coachService.updateCoach(leagueId, teamId, coachId, request);
    }

    @DeleteMapping("{coachId}")
    public void deleteCoach(@PathVariable Long leagueId,
                            @PathVariable Long teamId,
                            @PathVariable Long coachId) {
        coachService.deleteCoach(leagueId, teamId, coachId);
    }
}
