package org.example.MeasurementService;

import org.example.dto.Measurement;
import org.example.Enum.MeasurementType;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

public class MeasurementSortingIntoIntervals {

    public Map<MeasurementType, List<Measurement>> sampleMapSorting(LocalDateTime startOfSampling,
                                                                    Map<MeasurementType, List<Measurement>> unsortedSamples) {
        return Arrays.stream(MeasurementType.values())
                .map(type -> Map.entry(type, unsortedSamples.get(type)))
                .filter(entry -> entry.getValue() != null && !entry.getValue().isEmpty())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> sortAndAdjustMeasurementsByTime(startOfSampling, entry.getValue())
                ));
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