package org.example;

import org.example.DTO.Measurement;
import org.example.MeasurementService.MeasurementProcessor;
import org.example.Enums.MeasurementType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        MeasurementProcessor measurementProcessor = new MeasurementProcessor();
        LocalDateTime startOfSampling = LocalDateTime.of(2024, 8, 9, 12, 25, 00);
        Map<MeasurementType, List<Measurement>> result =
                measurementProcessor.createOrderedAndSortedMap(startOfSampling, createMesurementList());
        for (MeasurementType type : MeasurementType.values()){
            for (Measurement measurement : result.get(type)){
                System.out.println("MeasurementType: " + measurement.getMeasurementType());
                System.out.println("MeasurementTime: " + measurement.getMeasurementTime());
                System.out.println("MeasurementValue: " + measurement.getMeasurementValue());
                System.out.println("*********************************");
            }
        }
    }

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