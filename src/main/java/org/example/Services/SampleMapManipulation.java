package org.example.Services;

import org.example.Objects.Measurement;
import org.example.Types.MeasurementType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class SampleMapManipulation {

    public Map<MeasurementType, List<Measurement>> createOrderedAndSortedMap(LocalDateTime startOfSampling, List<Measurement> unsampledMesurements){
        Map<MeasurementType, List<Measurement>> resultMap;
        SampleMapOrdering ordering = new SampleMapOrdering();
        resultMap = ordering.orderSamples(unsampledMesurements);
        SampleMapSorting sorting = new SampleMapSorting();
        return sorting.sampleMapSorting(startOfSampling, resultMap);
    }

}
