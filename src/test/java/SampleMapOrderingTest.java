import org.example.MockData.MockMeasurements;
import org.example.Objects.Measurement;
import org.example.Services.SampleMapOrdering;
import org.example.Types.MeasurementType;
import org.junit.jupiter.api.Test;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class SampleMapOrderingTest {

    @Test
    public void orderSamplesTest() {
        SampleMapOrdering sampleMapOrdering = new SampleMapOrdering();
        Map<MeasurementType, List<Measurement>> resultOrderedList = sampleMapOrdering.orderSamples(MockMeasurements.createMesurementList());

        List<Measurement> mockOrderedTempList = new ArrayList<>();
        mockOrderedTempList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 29, 53), 37.6, MeasurementType.TEMPERATURE));
        mockOrderedTempList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 30, 00), 36.6, MeasurementType.TEMPERATURE));
        mockOrderedTempList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 36, 23), 35.0, MeasurementType.TEMPERATURE));
        mockOrderedTempList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 38, 25), 36.3, MeasurementType.TEMPERATURE));
        List<Measurement> mockOrderedHeartRateList = new ArrayList<>();
        mockOrderedHeartRateList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 26, 41), 97.0, MeasurementType.HEART_RATE));
        mockOrderedHeartRateList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 32, 36), 110.0, MeasurementType.HEART_RATE));
        mockOrderedHeartRateList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 36, 16), 92.0, MeasurementType.HEART_RATE));
        mockOrderedHeartRateList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 40, 00), 100.0, MeasurementType.HEART_RATE));
        List<Measurement> mockOrderedSP02List = new ArrayList<>();
        mockOrderedSP02List.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 26, 13), 97.1, MeasurementType.SPO2));
        mockOrderedSP02List.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 27, 15), 80.9, MeasurementType.SPO2));
        mockOrderedSP02List.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 31, 54), 98.2, MeasurementType.SPO2));
        mockOrderedSP02List.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 33, 49), 95.8, MeasurementType.SPO2));
        Map<MeasurementType, List<Measurement>> expectedOrderedMap = new HashMap<>();
        expectedOrderedMap.put(MeasurementType.TEMPERATURE, mockOrderedTempList);
        expectedOrderedMap.put(MeasurementType.HEART_RATE, mockOrderedHeartRateList);
        expectedOrderedMap.put(MeasurementType.SPO2, mockOrderedSP02List);
        assertIterableEquals(expectedOrderedMap.get(MeasurementType.TEMPERATURE), resultOrderedList.get(MeasurementType.TEMPERATURE));
        assertIterableEquals(expectedOrderedMap.get(MeasurementType.HEART_RATE), resultOrderedList.get(MeasurementType.HEART_RATE));
        assertIterableEquals(expectedOrderedMap.get(MeasurementType.SPO2), resultOrderedList.get(MeasurementType.SPO2));
    }

    @Test
    public void orderSamplesTestFailing() {
        SampleMapOrdering sampleMapOrdering = new SampleMapOrdering();
        Map<MeasurementType, List<Measurement>> resultOrderedList = sampleMapOrdering.orderSamples(MockMeasurements.createMesurementList());

        List<Measurement> mockOrderedTempList = new ArrayList<>();
        mockOrderedTempList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 29, 53), 37.6, MeasurementType.TEMPERATURE));
        mockOrderedTempList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 36, 23), 35.0, MeasurementType.TEMPERATURE));
        mockOrderedTempList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 30, 00), 36.6, MeasurementType.TEMPERATURE));
        mockOrderedTempList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 38, 25), 36.3, MeasurementType.TEMPERATURE));
        List<Measurement> mockOrderedHeartRateList = new ArrayList<>();
        mockOrderedHeartRateList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 40, 00), 100.0, MeasurementType.HEART_RATE));
        mockOrderedHeartRateList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 26, 41), 97.0, MeasurementType.HEART_RATE));
        mockOrderedHeartRateList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 32, 36), 110.0, MeasurementType.HEART_RATE));
        mockOrderedHeartRateList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 36, 16), 92.0, MeasurementType.HEART_RATE));
        List<Measurement> mockOrderedSP02List = new ArrayList<>();
        mockOrderedSP02List.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 26, 13), 97.1, MeasurementType.SPO2));
        mockOrderedSP02List.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 27, 15), 80.9, MeasurementType.SPO2));
        mockOrderedSP02List.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 33, 49), 95.8, MeasurementType.SPO2));
        mockOrderedSP02List.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 31, 54), 98.2, MeasurementType.SPO2));
        Map<MeasurementType, List<Measurement>> expectedOrderedMap = new HashMap<>();
        expectedOrderedMap.put(MeasurementType.TEMPERATURE, mockOrderedTempList);
        expectedOrderedMap.put(MeasurementType.HEART_RATE, mockOrderedHeartRateList);
        expectedOrderedMap.put(MeasurementType.SPO2, mockOrderedSP02List);
        AssertIterableNotEquals.assertIterableNotEquals(expectedOrderedMap.get(MeasurementType.TEMPERATURE), resultOrderedList.get(MeasurementType.TEMPERATURE));
        AssertIterableNotEquals.assertIterableNotEquals(expectedOrderedMap.get(MeasurementType.HEART_RATE), resultOrderedList.get(MeasurementType.HEART_RATE));
        AssertIterableNotEquals.assertIterableNotEquals(expectedOrderedMap.get(MeasurementType.SPO2), resultOrderedList.get(MeasurementType.SPO2));
    }


}