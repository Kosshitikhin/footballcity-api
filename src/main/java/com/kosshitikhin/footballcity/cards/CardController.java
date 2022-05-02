package com.kosshitikhin.footballcity.cards;

import com.kosshitikhin.footballcity.cards.dto.CardDto;
import com.kosshitikhin.footballcity.cards.dto.CardUpdateRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cards")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PutMapping("{cardId}")
    public CardDto editCard(@PathVariable Long cardId,
                            @RequestBody CardUpdateRequest request) {
        return cardService.editCard(cardId, request);
    }

    @DeleteMapping("{cardId}")
    public void deleteCard(@PathVariable Long cardId) {
        cardService.deleteCard(cardId);
    }
}
