package com.rmaurya.Planefinder;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.planefinder.Aircraft;


import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaneFinderService {

    private final PlaneFinderController planeFinderController;

    public List<Aircraft> getAircrafts() {
        return planeFinderController.planeFinder();
    }
}
