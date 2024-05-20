package com.Navigator.Controllers;

import com.Navigator.Service.Impl.HiddenFeatureService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/hidden-features")
public class HiddenFeatureController {

    private final HiddenFeatureService hiddenFeatureService;

    public HiddenFeatureController(HiddenFeatureService hiddenFeatureService){
        this.hiddenFeatureService = hiddenFeatureService;
    }

    @GetMapping("/{number}")
    public ResponseEntity<String> getNumberFact(@PathVariable int number) {
        String apiUrl = "http://numbersapi.com/" + number;
        RestTemplate restTemplate = new RestTemplate();
        String fact = restTemplate.getForObject(apiUrl, String.class);
        return ResponseEntity.ok(fact);
    }
}
