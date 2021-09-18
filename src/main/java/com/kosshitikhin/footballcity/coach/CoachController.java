package com.kosshitikhin.footballcity.coach;

import com.kosshitikhin.footballcity.coach.dto.CoachDto;
import com.kosshitikhin.footballcity.coach.dto.CoachRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("leagues/{leagueId}")
public class CoachController {

    private final CoachService coachService;

    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    @GetMapping("coach/{coachId}")
    public CoachDto getCoach(@PathVariable Long leagueId,
                             @PathVariable Long coachId) {
        return coachService.getCoach(leagueId, coachId);
    }

    @PostMapping("/teams/{teamId}/coach")
    public CoachDto addCoach(@PathVariable Long leagueId,
                             @PathVariable Long teamId,
                             @RequestBody CoachRequest request) {
        return coachService.addCoach(leagueId, teamId, request);
    }

    @PutMapping("coach/{coachId}")
    public CoachDto updateCoach(@PathVariable Long leagueId,
                                @PathVariable Long coachId,
                                @RequestBody CoachRequest request) {
        return coachService.updateCoach(leagueId, coachId, request);
    }

    @DeleteMapping("coach/{coachId}")
    public void deleteCoach(@PathVariable Long leagueId,
                            @PathVariable Long coachId) {
        coachService.deleteCoach(leagueId, coachId);
    }
}
