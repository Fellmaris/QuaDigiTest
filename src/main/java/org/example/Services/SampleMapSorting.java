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
            List<Measurement> sortedListOfType = sortAndAdjustMeasurementsByTime(startOfSampling, measurements);
            sortedSamples.put(type, sortedListOfType);
        }
        return sortedSamples;
    }

    private List<Measurement> sortAndAdjustMeasurementsByTime(LocalDateTime startOfSampling, List<Measurement> measurements) {
        List<Measurement> sortedListOfType = new ArrayList<>();
        LocalDateTime currentPoint = startOfSampling;
        Measurement lastMeasurementInInterval = null;

        for (Measurement measurement : measurements) {
            currentPoint = advanceTimeAndAddMissingMeasurements(currentPoint, measurement, sortedListOfType, lastMeasurementInInterval);
            lastMeasurementInInterval = measurement;
        }

        if (lastMeasurementInInterval != null) {
            lastMeasurementInInterval.setMeasurementTime(currentPoint.plusMinutes(5));
            sortedListOfType.add(lastMeasurementInInterval);
        }

        return sortedListOfType;
    }

    private LocalDateTime advanceTimeAndAddMissingMeasurements(LocalDateTime currentPoint, Measurement measurement,
                                                               List<Measurement> sortedListOfType, Measurement lastMeasurementInInterval) {
        while (measurement.getMeasurementTime().isAfter(currentPoint.plusMinutes(5))) {
            if (lastMeasurementInInterval != null) {
                lastMeasurementInInterval.setMeasurementTime(currentPoint.plusMinutes(5));
                sortedListOfType.add(lastMeasurementInInterval);
            }
            lastMeasurementInInterval = null;
            currentPoint = currentPoint.plusMinutes(5);
        }
        return currentPoint;
    }
}