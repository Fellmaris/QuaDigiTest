package org.example.MockData;

import org.example.Objects.Measurement;
import org.example.Types.MeasurementType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MockMeasurements {

    public static List<Measurement> createMesurementList (){
        List<Measurement> mockList = new ArrayList<>();

        mockList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 30, 00), 36.6, MeasurementType.TEMPERATURE));
        mockList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 27, 15), 80.9, MeasurementType.SPO2));
        mockList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 29, 53), 37.6, MeasurementType.TEMPERATURE));
        mockList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 40, 00), 100.0, MeasurementType.HEART_RATE));
        mockList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 38, 25), 36.3, MeasurementType.TEMPERATURE));
        mockList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 26, 13), 97.1, MeasurementType.SPO2));
        mockList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 26, 41), 97.0, MeasurementType.HEART_RATE));
        mockList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 36, 16), 92.0, MeasurementType.HEART_RATE));
        mockList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 32, 36), 110.0, MeasurementType.HEART_RATE));
        mockList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 31, 54), 98.2, MeasurementType.SPO2));
        mockList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 33, 49), 95.8, MeasurementType.SPO2));
        mockList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 36, 23), 35.0, MeasurementType.TEMPERATURE));
        return mockList;
    }

    public static List<Measurement> createMesurementListWithNulls (){
        List<Measurement> mockList = new ArrayList<>();
        mockList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 30, 00), 36.6, MeasurementType.TEMPERATURE));
        mockList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 27, 15), 80.9, MeasurementType.SPO2));
        mockList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 29, 53), 37.6, MeasurementType.TEMPERATURE));
        mockList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 40, 00), 100.0, MeasurementType.HEART_RATE));
        mockList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 38, 25), 36.3, MeasurementType.TEMPERATURE));
        mockList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 26, 13), 97.1, MeasurementType.SPO2));
        mockList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 26, 41), 97.0, MeasurementType.HEART_RATE));
        mockList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 36, 16), 92.0, MeasurementType.HEART_RATE));
        mockList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 32, 36), 110.0, MeasurementType.HEART_RATE));
        mockList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 31, 54), 98.2, MeasurementType.SPO2));
        mockList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 33, 49), 95.8, MeasurementType.SPO2));
        mockList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 36, 23), 35.0, MeasurementType.TEMPERATURE));
        mockList.add(new Measurement(null, 35.0, MeasurementType.HEART_RATE));
        mockList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 36, 23), null, MeasurementType.TEMPERATURE));
        mockList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 36, 23), 35.0, null));

        return mockList;
    }

}
