package org.example;

import org.example.MockData.MockMeasurements;
import org.example.Objects.Measurement;
import org.example.Services.SampleMapManipulation;
import org.example.Types.MeasurementType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        SampleMapManipulation sampleMapManipulation = new SampleMapManipulation();
        LocalDateTime startOfSampling = LocalDateTime.of(2024, 8, 9, 12, 25, 00);
        Map<MeasurementType, List<Measurement>> result =
                sampleMapManipulation.createOrderedAndSortedMap(startOfSampling, MockMeasurements.createMesurementListWithNulls());
        for (MeasurementType type : MeasurementType.values()){
            for (Measurement measurement : result.get(type)){
                System.out.println("MeasurementType: " + measurement.getMeasurementType());
                System.out.println("MeasurementTime: " + measurement.getMeasurementTime());
                System.out.println("MeasurementValue: " + measurement.getMeasurementValue());
                System.out.println("*********************************");
            }
        }

    }
}