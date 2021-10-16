package com.kosshitikhin.footballcity.cards;

import com.kosshitikhin.footballcity.cards.dto.CardDto;
import com.kosshitikhin.footballcity.cards.dto.CardRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("leagues/{leagueId}")
public class CardController {

    private final CardService cardService;

    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @PostMapping("matches/{matchId}/players/{playerId}/cards/add")
    public void addCard(@PathVariable Long leagueId,
                        @PathVariable Long matchId,
                        @PathVariable Long playerId,
                        @RequestBody CardRequest request) {
        cardService.addCard(leagueId, matchId, playerId, request);
    }

    @DeleteMapping("cards/{cardId}/delete")
    public void deleteCard(@PathVariable Long leagueId,
                           @PathVariable Long cardId) {
        cardService.deleteCard(leagueId, cardId);
    }

    @GetMapping("players/{playerId}/cards")
    public List<CardDto> getAllCardsOfPlayer(@PathVariable Long leagueId, @PathVariable Long playerId) {
        return cardService.getAllCardsOfPlayerFromLeague(leagueId, playerId);
    }
}
