package com.kosshitikhin.footballcity.assists;

import com.kosshitikhin.footballcity.assists.dto.AssistDto;
import com.kosshitikhin.footballcity.assists.dto.AssistUpdateRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("assists")
public class AssistController {

    private final AssistService assistService;

    public AssistController(AssistService assistService) {
        this.assistService = assistService;
    }

    @PutMapping("{assistId}")
    public AssistDto editAssist(@PathVariable Long assistId, @RequestBody AssistUpdateRequest request) {
        return assistService.editAssist(assistId, request);
    }

    @DeleteMapping("{assistId}")
    public void deleteAssist(@PathVariable Long assistId) {
        assistService.deleteAssist(assistId);
    }

}
