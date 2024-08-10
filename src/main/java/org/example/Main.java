package org.example;

import org.example.MockData.MockMeasurements;
import org.example.Services.SampleMapManipulation;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        SampleMapManipulation sampleMapManipulation = new SampleMapManipulation();
        LocalDateTime startOfSampling = LocalDateTime.of(2024, 8, 9, 12, 25, 00);
        sampleMapManipulation.createOrderedAndSortedMap(startOfSampling, MockMeasurements.createMesurementList());

    }
}