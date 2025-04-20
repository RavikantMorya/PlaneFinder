package com.rmaurya.PlaneFinder;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaneFinderService {

    private final PlaneFinderRepository repository;
    // Fetch data from DB
    public Iterable<Aircraft> getAircrafts() {
        return repository.findAll();
    }

    // Save list of aircraft to DB
    public void saveAll(List<Aircraft> aircrafts) {
        repository.saveAll(aircrafts);
    }

    // 🕒 Scheduled task: refresh aircraft data every 300 seconds
    @Scheduled(fixedRate = 30000)
    public void refreshSampleAircrafts() {
        List<Aircraft> demoAircrafts = List.of(
                new Aircraft(1L, "AB123", "7500", "A1", "Flight101", "RouteA", "TypeA", "Category1",
                        35000, 90, 450, 100, 36000, 37.7749, -122.4194, 1013.25,
                        50.0, 270.0, true, false, Instant.now(), Instant.now(), Instant.now()),
                new Aircraft(2L, "CD456", "7600", "B2", "Flight202", "RouteB", "TypeB", "Category2",
                        36000, 180, 500, 200, 37000, 40.7128, -74.0060, 1012.50,
                        60.0, 180.0, true, true, Instant.now(), Instant.now(), Instant.now()),
                new Aircraft(3L, "EF789", "7700", "C3", "Flight303", "RouteC", "TypeC", "Category3",
                        28000, 270, 400, 150, 29000, 48.8566, 2.3522, 1011.75,
                        70.0, 90.0, false, false, Instant.now(), Instant.now(), Instant.now()),
                new Aircraft(4L, "GH012", "7500", "D4", "Flight404", "RouteD", "TypeD", "Category4",
                        32000, 45, 550, 120, 33000, 51.5074, -0.1278, 1014.00,
                        80.0, 225.0, true, false, Instant.now(), Instant.now(), Instant.now()),
                new Aircraft(5L, "IJ345", "7600", "E5", "Flight505", "RouteE", "TypeE", "Category5",
                        34000, 90, 470, 90, 35000, 40.7128, -74.0060, 1012.25,
                        30.0, 180.0, false, true, Instant.now(), Instant.now(), Instant.now()),
                new Aircraft(6L, "KL678", "7700", "F6", "Flight606", "RouteF", "TypeF", "Category6",
                        37000, 0, 480, 170, 38000, 35.6895, 139.6917, 1013.50,
                        20.0, 360.0, true, false, Instant.now(), Instant.now(), Instant.now()),
                new Aircraft(7L, "MN901", "7500", "G7", "Flight707", "RouteG", "TypeG", "Category7",
                        33000, 135, 500, 130, 34000, 34.0522, -118.2437, 1015.25,
                        60.0, 300.0, true, true, Instant.now(), Instant.now(), Instant.now()),
                new Aircraft(8L, "OP234", "7600", "H8", "Flight808", "RouteH", "TypeH", "Category8",
                        29000, 225, 420, 110, 30000, 55.7558, 37.6173, 1010.75,
                        40.0, 135.0, false, false, Instant.now(), Instant.now(), Instant.now()),
                new Aircraft(9L, "QR567", "7700", "I9", "Flight909", "RouteI", "TypeI", "Category9",
                        25000, 315, 350, 100, 26000, -33.8688, 151.2093, 1009.50,
                        90.0, 45.0, true, false, Instant.now(), Instant.now(), Instant.now()),
                new Aircraft(10L, "ST890", "7500", "J10", "Flight010", "RouteJ", "TypeJ", "Category10",
                        30000, 270, 400, 80, 31000, 19.0760, 72.8777, 1016.25,
                        70.0, 270.0, false, true, Instant.now(), Instant.now(), Instant.now()),
                new Aircraft(11L, "UV123", "7600", "K11", "Flight111", "RouteK", "TypeK", "Category11",
                        29000, 90, 430, 60, 30000, 28.6139, 77.2090, 1012.00,
                        30.0, 180.0, true, true, Instant.now(), Instant.now(), Instant.now()),
                new Aircraft(12L, "WX456", "7700", "L12", "Flight212", "RouteL", "TypeL", "Category12",
                        31000, 360, 450, 140, 32000, -23.5505, -46.6333, 1011.25,
                        50.0, 360.0, false, false, Instant.now(), Instant.now(), Instant.now())
        );

        // Clear old data
        repository.deleteAll();

        // Save new aircraft data
        repository.saveAll(demoAircrafts);
        System.out.println("🔄 Aircraft data refreshed at: " + Instant.now());
    }
}
