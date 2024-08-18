package org.example.MeasurementService;

import org.example.dto.Measurement;
import org.example.Enum.MeasurementType;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MeasurementOrderingByTypeAndTime {

    public Map<MeasurementType, List<Measurement>> orderSamples(List<Measurement> unorderedSamples) {
        return orderSamplesByTime(orderSamplesByType(unorderedSamples));
    }

    private Map<MeasurementType, List<Measurement>> orderSamplesByType(List<Measurement> unorderedSamples) {
        return unorderedSamples.stream()
                .collect(Collectors.groupingBy(Measurement::getMeasurementType));
    }

    private Map<MeasurementType, List<Measurement>> orderSamplesByTime(Map<MeasurementType, List<Measurement>> unorderedSamples) {
        return unorderedSamples.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().stream()
                                .sorted(Comparator.comparing(Measurement::getMeasurementTime))
                                .collect(Collectors.toList())
                ));
    }

}
