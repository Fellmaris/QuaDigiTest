package org.example.MeasurementService;

import org.example.dto.Measurement;
import org.example.Enum.MeasurementType;
import org.example.Validator.Validation;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class MeasurementProcessor {

    public Map<MeasurementType, List<Measurement>> createOrderedAndSortedMap(LocalDateTime startOfSampling, List<Measurement> unsampledMeasurements){
        Map<MeasurementType, List<Measurement>> resultMap;
        Validation validation = new Validation();
        List <Measurement> validatedMeasurements = validation.validateMeasurements(unsampledMeasurements);
        MeasurementOrderingByTypeAndTime ordering = new MeasurementOrderingByTypeAndTime();
        resultMap = ordering.orderSamples(validatedMeasurements);
        MeasurementSortingIntoIntervals sorting = new MeasurementSortingIntoIntervals();
        return sorting.sampleMapSorting(startOfSampling, resultMap);
    }

}
