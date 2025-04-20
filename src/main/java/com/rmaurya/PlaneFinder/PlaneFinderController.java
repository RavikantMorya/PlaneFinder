package com.rmaurya.PlaneFinder;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PlaneFinderController {
    private final PlaneFinderService planeFinderService;

    // Fetch aircrafts (from the database)
    @GetMapping("/aircraft")
    public Iterable<Aircraft> getAircrafts() {
        System.out.println(planeFinderService.getAircrafts());
        return planeFinderService.getAircrafts(); // Delegate to service layer
    }

}
