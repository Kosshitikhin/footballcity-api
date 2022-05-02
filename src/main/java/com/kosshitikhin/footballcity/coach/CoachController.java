package com.kosshitikhin.footballcity.coach;

import com.kosshitikhin.footballcity.coach.dto.CoachDto;
import com.kosshitikhin.footballcity.coach.dto.CoachUpdateRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("coach")
public class CoachController {

    private final CoachService coachService;

    public CoachController(CoachService coachService) {
        this.coachService = coachService;
    }

    @GetMapping("{coachId}")
    public CoachDto getCoach(@PathVariable Long coachId) {
        return coachService.getCoach(coachId);
    }

    @PutMapping("{coachId}")
    public CoachDto updateCoach(@PathVariable Long coachId,
                                @RequestBody CoachUpdateRequest request) {
        return coachService.updateCoach(coachId, request);
    }

    @DeleteMapping("{coachId}")
    public void deleteCoach(@PathVariable Long coachId) {
        coachService.deleteCoach(coachId);
    }
}
