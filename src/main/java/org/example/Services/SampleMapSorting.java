package org.example.Services;

import org.example.Objects.Measurement;
import org.example.Types.MeasurementType;

import java.time.LocalDateTime;
import java.util.*;

public class SampleMapSorting {

    public Map<MeasurementType, List<Measurement>> sampleMapSorting(LocalDateTime startOfSampling,
                                                                       Map<MeasurementType, List<Measurement>> unsortedSamples) {
        Map<MeasurementType, List<Measurement>> sortedSamples = new HashMap<>();
        for (MeasurementType type : MeasurementType.values()) {
            List<Measurement> measurements = unsortedSamples.get(type);
            if (measurements == null || measurements.isEmpty()) {
                continue;
            }
            List<Measurement> sortedListOfType = new ArrayList<>();
            LocalDateTime currentPoint = startOfSampling;
            Measurement lastMeasurementInInterval = null;
            for (Measurement measurement : measurements) {
                LocalDateTime measurementTime = measurement.getMeasurementTime();
                while (measurementTime.isAfter(currentPoint.plusMinutes(5))) {
                    if (lastMeasurementInInterval != null) {
                        lastMeasurementInInterval.setMeasurementTime(currentPoint.plusMinutes(5));
                        sortedListOfType.add(lastMeasurementInInterval);
                    }
                    lastMeasurementInInterval = null;
                    currentPoint = currentPoint.plusMinutes(5);
                }
                lastMeasurementInInterval = measurement;
            }
            if (lastMeasurementInInterval != null) {
                lastMeasurementInInterval.setMeasurementTime(currentPoint.plusMinutes(5));
                sortedListOfType.add(lastMeasurementInInterval);
            }
            sortedSamples.put(type, sortedListOfType);
        }
        return sortedSamples;
    }
}