package io.github.brunoonofre64.mscards.application.v1.controller;

import io.github.brunoonofre64.mscards.domain.dto.CardsInputDTO;
import io.github.brunoonofre64.mscards.domain.dto.CardsOutputDTO;
import io.github.brunoonofre64.mscards.domain.service.CardsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardsController {

    private final CardsService cardsService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void saveNewCard(@RequestBody CardsInputDTO cardsInputDTO) {
        cardsService.saveNewCard(cardsInputDTO);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<CardsOutputDTO> findCardsIncomeLessThanEqual(@RequestParam("income") Long income) {
        return cardsService.findCardsIncomeLessThanEqual(income);
    }
}
