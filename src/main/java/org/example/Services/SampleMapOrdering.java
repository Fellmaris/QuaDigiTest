package org.example.Services;

import org.example.Objects.Measurement;
import org.example.Types.MeasurementType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SampleMapOrdering {

    public Map<MeasurementType, List<Measurement>> orderSamples (List<Measurement> unorderedSamples) {
        Map<MeasurementType, List<Measurement>> orderedSamples;
        orderedSamples = orderSamplesByType(unorderedSamples);
        return orderSamplesByTime(orderedSamples);
    }

    private Map<MeasurementType, List<Measurement>> orderSamplesByType (List<Measurement> unorderedSamples) {
        Map<MeasurementType, List<Measurement>> orderedSamples = new HashMap<>();
        for (MeasurementType type : MeasurementType.values()) {
            orderedSamples.put(type, new ArrayList<>());
            for (Measurement measurement : unorderedSamples) {
                if (type == measurement.getMesurementType()){
                    List<Measurement> tempList = orderedSamples.get(type);
                    tempList.add(measurement);
                    orderedSamples.put(type, tempList);
                }
            }
        }
        return orderedSamples;
    }

    private Map<MeasurementType, List<Measurement>> orderSamplesByTime(Map<MeasurementType, List<Measurement>> unorderedSamples) {
        Map<MeasurementType, List<Measurement>> orderedSamples = new HashMap<>();

        for (MeasurementType type : MeasurementType.values()) {
            List<Measurement> tempTypeList = unorderedSamples.get(type);

            if (tempTypeList != null) {
                int countOfEntries = tempTypeList.size();
                for (int i = 0; i < countOfEntries - 1; i++) {
                    for (int j = i + 1; j < countOfEntries; j++) {
                        if (tempTypeList.get(i).getMeasurementTime().isAfter(tempTypeList.get(j).getMeasurementTime())) {
                            Measurement tempTime = tempTypeList.get(i);
                            tempTypeList.set(i, tempTypeList.get(j));
                            tempTypeList.set(j, tempTime);
                        }
                    }
                }
                orderedSamples.put(type, tempTypeList);
            }
        }

        return orderedSamples;
    }

}
