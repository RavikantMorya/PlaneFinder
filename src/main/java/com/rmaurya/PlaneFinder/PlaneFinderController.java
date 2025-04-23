package com.rmaurya.PlaneFinder;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class PlaneFinderController {
    private final PlaneFinderService planeFinderService;

    // Fetch aircrafts (from the database)
    @GetMapping("/aircraft")
    public Flux<Aircraft> getAircrafts() {
        System.out.println(planeFinderService.getAircrafts());
        return planeFinderService.getAircrafts(); // Delegate to service layer
    }

}
