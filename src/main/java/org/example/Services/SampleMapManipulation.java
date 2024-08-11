package org.example.Services;

import org.example.Objects.Measurement;
import org.example.Types.MeasurementType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class SampleMapManipulation {

    public Map<MeasurementType, List<Measurement>> createOrderedAndSortedMap(LocalDateTime startOfSampling, List<Measurement> unsampledMeasurements){
        Map<MeasurementType, List<Measurement>> resultMap;
        SampleValidation validation = new SampleValidation();
        List <Measurement> validatedMeasurements = validation.validateMeasurements(unsampledMeasurements);
        SampleMapOrdering ordering = new SampleMapOrdering();
        resultMap = ordering.orderSamples(validatedMeasurements);
        SampleMapSorting sorting = new SampleMapSorting();
        return sorting.sampleMapSorting(startOfSampling, resultMap);
    }

}
