package com.rmaurya.PlaneFinder;


import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;

import java.time.Instant;
/*Context: Spring Data + Persistable
Spring Data needs to know:
        "Should I INSERT this object, or UPDATE it?"
By default, it checks:
If @Id is null ➜ it inserts.
If @Id is set ➜ it assumes it's an existing record, and tries to update.
But in some cases (like in reactive apps or with manual IDs), that logic is not enough or incorrect.
That’s where Persistable<T> comes in — you implement it and tell Spring yourself whether the object is new.*/


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Aircraft implements Persistable<Long> {
    @Id
    private Long id;
    private String callsign, squawk, reg, flightno, route, type, category;
    private int altitude, heading, speed;
    @JsonProperty("vert_rate")
    private int vertRate;
    @JsonProperty("selected_altitude")
    private int selectedAltitude;
    private double lat, lon, barometer;
    @JsonProperty("polar_distance")
    private double polarDistance;
    @JsonProperty("polar_bearing")
    private double polarBearing;
    @JsonProperty("is_adsb")
    private boolean isADSB;
    @JsonProperty("is_on_ground")
    private boolean isOnGround;
    @JsonProperty("last_seen_time")
    private Instant lastSeenTime;
    @JsonProperty("pos_update_time")
    private Instant posUpdateTime;
    @JsonProperty("bds40_seen_time")
    private Instant bds40SeenTime;

//    @Transient
    @JsonProperty("new_aircraft")
    private boolean newAircraft;

    @Override
    @Transient
    public boolean isNew() {
        return this.newAircraft || id == null;
    }

}
