import org.example.dto.Measurement;
import org.example.MeasurementService.MeasurementSortingIntoIntervals;
import org.example.Enum.MeasurementType;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class MeasurementSortingIntoIntervalsTest {

    @Test
    void sampleMapSorting_SortedIntoIntervals_Passing () {
        LocalDateTime startOfSampling = LocalDateTime.of(2024, 8, 9, 12, 25, 00);
        List<Measurement> mockToSortTempList = new ArrayList<>();
        mockToSortTempList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 29, 53), 37.6, MeasurementType.TEMPERATURE));
        mockToSortTempList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 30, 00), 36.6, MeasurementType.TEMPERATURE));
        mockToSortTempList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 36, 23), 35.0, MeasurementType.TEMPERATURE));
        mockToSortTempList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 38, 25), 36.3, MeasurementType.TEMPERATURE));
        List<Measurement> mockToSortHeartRateList = new ArrayList<>();
        mockToSortHeartRateList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 26, 41), 97.0, MeasurementType.HEART_RATE));
        mockToSortHeartRateList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 32, 36), 110.0, MeasurementType.HEART_RATE));
        mockToSortHeartRateList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 36, 16), 92.0, MeasurementType.HEART_RATE));
        mockToSortHeartRateList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 40, 00), 100.0, MeasurementType.HEART_RATE));
        List<Measurement> mockToSortSP02List = new ArrayList<>();
        mockToSortSP02List.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 26, 13), 97.1, MeasurementType.SPO2));
        mockToSortSP02List.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 27, 15), 80.9, MeasurementType.SPO2));
        mockToSortSP02List.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 31, 54), 98.2, MeasurementType.SPO2));
        mockToSortSP02List.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 33, 49), 95.8, MeasurementType.SPO2));
        Map<MeasurementType, List<Measurement>> resultOfSorting = new HashMap<>();
        resultOfSorting.put(MeasurementType.TEMPERATURE, mockToSortTempList);
        resultOfSorting.put(MeasurementType.HEART_RATE, mockToSortHeartRateList);
        resultOfSorting.put(MeasurementType.SPO2, mockToSortSP02List);

        MeasurementSortingIntoIntervals sampleMapSorting = new MeasurementSortingIntoIntervals();
        resultOfSorting = sampleMapSorting.sampleMapSorting(startOfSampling, resultOfSorting);

        List<Measurement> mockSortedTempList = new ArrayList<>();
        mockSortedTempList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 30, 00), 36.6, MeasurementType.TEMPERATURE));
        mockSortedTempList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 40, 00), 36.3, MeasurementType.TEMPERATURE));
        List<Measurement> mockSortedHeartRateList = new ArrayList<>();
        mockSortedHeartRateList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 30, 00), 97.0, MeasurementType.HEART_RATE));
        mockSortedHeartRateList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 35, 00), 110.0, MeasurementType.HEART_RATE));
        mockSortedHeartRateList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 40, 00), 100.0, MeasurementType.HEART_RATE));
        List<Measurement> mockSortedSP02List = new ArrayList<>();
        mockSortedSP02List.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 30, 00), 80.9, MeasurementType.SPO2));
        mockSortedSP02List.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 35, 00), 95.8, MeasurementType.SPO2));
        Map<MeasurementType, List<Measurement>> expectedSortedMap = new HashMap<>();
        expectedSortedMap.put(MeasurementType.TEMPERATURE, mockSortedTempList);
        expectedSortedMap.put(MeasurementType.HEART_RATE, mockSortedHeartRateList);
        expectedSortedMap.put(MeasurementType.SPO2, mockSortedSP02List);

        assertIterableEquals(expectedSortedMap.get(MeasurementType.TEMPERATURE), resultOfSorting.get(MeasurementType.TEMPERATURE));
        assertIterableEquals(expectedSortedMap.get(MeasurementType.HEART_RATE), resultOfSorting.get(MeasurementType.HEART_RATE));
        assertIterableEquals(expectedSortedMap.get(MeasurementType.SPO2), resultOfSorting.get(MeasurementType.SPO2));
    }

    @Test
    void sampleMapSorting_BadlySortedIntoIntervals_Failing () {
        LocalDateTime startOfSampling = LocalDateTime.of(2024, 8, 9, 12, 25, 00);
        List<Measurement> mockToSortTempList = new ArrayList<>();
        mockToSortTempList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 29, 53), 37.6, MeasurementType.TEMPERATURE));
        mockToSortTempList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 30, 00), 36.6, MeasurementType.TEMPERATURE));
        mockToSortTempList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 36, 23), 35.0, MeasurementType.TEMPERATURE));
        mockToSortTempList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 38, 25), 36.3, MeasurementType.TEMPERATURE));
        List<Measurement> mockToSortHeartRateList = new ArrayList<>();
        mockToSortHeartRateList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 26, 41), 97.0, MeasurementType.HEART_RATE));
        mockToSortHeartRateList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 32, 36), 110.0, MeasurementType.HEART_RATE));
        mockToSortHeartRateList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 36, 16), 92.0, MeasurementType.HEART_RATE));
        mockToSortHeartRateList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 40, 00), 100.0, MeasurementType.HEART_RATE));
        List<Measurement> mockToSortSP02List = new ArrayList<>();
        mockToSortSP02List.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 26, 13), 97.1, MeasurementType.SPO2));
        mockToSortSP02List.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 27, 15), 80.9, MeasurementType.SPO2));
        mockToSortSP02List.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 31, 54), 98.2, MeasurementType.SPO2));
        mockToSortSP02List.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 33, 49), 95.8, MeasurementType.SPO2));
        Map<MeasurementType, List<Measurement>> resultOfSorting = new HashMap<>();
        resultOfSorting.put(MeasurementType.TEMPERATURE, mockToSortTempList);
        resultOfSorting.put(MeasurementType.HEART_RATE, mockToSortHeartRateList);
        resultOfSorting.put(MeasurementType.SPO2, mockToSortSP02List);

        MeasurementSortingIntoIntervals sampleMapSorting = new MeasurementSortingIntoIntervals();
        resultOfSorting = sampleMapSorting.sampleMapSorting(startOfSampling, resultOfSorting);

        List<Measurement> mockSortedTempList = new ArrayList<>();
        mockSortedTempList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 40, 00), 36.3, MeasurementType.TEMPERATURE));
        mockSortedTempList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 30, 00), 36.6, MeasurementType.TEMPERATURE));
        List<Measurement> mockSortedHeartRateList = new ArrayList<>();
        mockSortedHeartRateList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 40, 00), 100.0, MeasurementType.HEART_RATE));
        mockSortedHeartRateList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 30, 00), 97.0, MeasurementType.HEART_RATE));
        mockSortedHeartRateList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 35, 00), 110.0, MeasurementType.HEART_RATE));
        List<Measurement> mockSortedSP02List = new ArrayList<>();
        mockSortedSP02List.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 35, 00), 95.8, MeasurementType.SPO2));
        mockSortedSP02List.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 30, 00), 80.9, MeasurementType.SPO2));
        Map<MeasurementType, List<Measurement>> expectedSortedMap = new HashMap<>();
        expectedSortedMap.put(MeasurementType.TEMPERATURE, mockSortedTempList);
        expectedSortedMap.put(MeasurementType.HEART_RATE, mockSortedHeartRateList);
        expectedSortedMap.put(MeasurementType.SPO2, mockSortedSP02List);



        AssertIterableNotEquals.assertIterableNotEquals(expectedSortedMap.get(MeasurementType.TEMPERATURE), resultOfSorting.get(MeasurementType.TEMPERATURE));
        AssertIterableNotEquals.assertIterableNotEquals(expectedSortedMap.get(MeasurementType.HEART_RATE), resultOfSorting.get(MeasurementType.HEART_RATE));
        AssertIterableNotEquals.assertIterableNotEquals(expectedSortedMap.get(MeasurementType.SPO2), resultOfSorting.get(MeasurementType.SPO2));
    }
}

