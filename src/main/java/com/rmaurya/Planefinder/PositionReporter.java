package com.rmaurya.Planefinder;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.example.planefinder.Aircraft;
import java.util.List;
import java.util.function.Supplier;

@AllArgsConstructor
@Configuration
public class PositionReporter {
    private final PlaneFinderService pfService;
    @Bean
    Supplier<Iterable<Aircraft>> reportPositions() {
        return () -> {
            try {
                return pfService.getAircrafts();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return List.of();
        };
    }
}
