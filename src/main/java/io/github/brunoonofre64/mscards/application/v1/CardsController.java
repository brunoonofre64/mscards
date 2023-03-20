package io.github.brunoonofre64.mscards.application.v1;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardsController {


    @GetMapping
    public String checkStatus() {
        return "ok";
    }
}
