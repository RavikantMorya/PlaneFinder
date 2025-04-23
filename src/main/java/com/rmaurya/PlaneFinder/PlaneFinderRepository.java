package com.rmaurya.PlaneFinder;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface PlaneFinderRepository extends ReactiveCrudRepository<Aircraft,Long> {
}
