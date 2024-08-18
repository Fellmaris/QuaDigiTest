import MockData.MockMeasurements;
import org.example.DTO.Measurement;
import org.example.MeasurementService.MeasurementProcessor;
import org.example.Enums.MeasurementType;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

public class MeasurementProcessorTest {

    @Test
    public void createOrderedAndSortedMapWith_OrderedMap_Passing (){
        MeasurementProcessor measurementProcessor = new MeasurementProcessor();
        LocalDateTime startOfSampling = LocalDateTime.of(2024, 8, 9, 12, 25, 00);
        Map<MeasurementType, List<Measurement>> result = measurementProcessor.createOrderedAndSortedMap(startOfSampling, MockMeasurements.createMesurementList());

        List<Measurement> mockResultTempList = new ArrayList<>();
        mockResultTempList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 30, 00), 36.6, MeasurementType.TEMPERATURE));
        mockResultTempList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 40, 00), 36.3, MeasurementType.TEMPERATURE));
        List<Measurement> mockResultHeartRateList = new ArrayList<>();
        mockResultHeartRateList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 30, 00), 97.0, MeasurementType.HEART_RATE));
        mockResultHeartRateList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 35, 00), 110.0, MeasurementType.HEART_RATE));
        mockResultHeartRateList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 40, 00), 100.0, MeasurementType.HEART_RATE));
        List<Measurement> mockresultSP02List = new ArrayList<>();
        mockresultSP02List.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 30, 00), 80.9, MeasurementType.SPO2));
        mockresultSP02List.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 35, 00), 95.8, MeasurementType.SPO2));
        Map<MeasurementType, List<Measurement>> expecteddMap = new HashMap<>();
        expecteddMap.put(MeasurementType.TEMPERATURE, mockResultTempList);
        expecteddMap.put(MeasurementType.HEART_RATE, mockResultHeartRateList);
        expecteddMap.put(MeasurementType.SPO2, mockresultSP02List);

        assertIterableEquals(expecteddMap.get(MeasurementType.TEMPERATURE), result.get(MeasurementType.TEMPERATURE));
        assertIterableEquals(expecteddMap.get(MeasurementType.HEART_RATE), result.get(MeasurementType.HEART_RATE));
        assertIterableEquals(expecteddMap.get(MeasurementType.SPO2), result.get(MeasurementType.SPO2));
    }

    @Test
    public void createOrderedAndSortedMap_CompareDisorderlyMaps_Failing (){
        MeasurementProcessor measurementProcessor = new MeasurementProcessor();
        LocalDateTime startOfSampling = LocalDateTime.of(2024, 8, 9, 12, 25, 00);
        Map<MeasurementType, List<Measurement>> result = measurementProcessor.createOrderedAndSortedMap(startOfSampling, MockMeasurements.createMesurementList());

        List<Measurement> mockResultTempList = new ArrayList<>();
        mockResultTempList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 40, 00), 36.3, MeasurementType.TEMPERATURE));

        mockResultTempList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 30, 00), 36.6, MeasurementType.TEMPERATURE));
        List<Measurement> mockResultHeartRateList = new ArrayList<>();
        mockResultHeartRateList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 30, 00), 97.0, MeasurementType.HEART_RATE));
        mockResultHeartRateList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 40, 00), 100.0, MeasurementType.HEART_RATE));
        mockResultHeartRateList.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 35, 00), 110.0, MeasurementType.HEART_RATE));
        List<Measurement> mockresultSP02List = new ArrayList<>();
        mockresultSP02List.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 35, 00), 95.8, MeasurementType.SPO2));
        mockresultSP02List.add(new Measurement(LocalDateTime.of(2024, 8, 9, 12, 30, 00), 80.9, MeasurementType.SPO2));
        Map<MeasurementType, List<Measurement>> expecteddMap = new HashMap<>();
        expecteddMap.put(MeasurementType.TEMPERATURE, mockResultTempList);
        expecteddMap.put(MeasurementType.HEART_RATE, mockResultHeartRateList);
        expecteddMap.put(MeasurementType.SPO2, mockresultSP02List);

        AssertIterableNotEquals.assertIterableNotEquals(expecteddMap.get(MeasurementType.TEMPERATURE), result.get(MeasurementType.TEMPERATURE));
        AssertIterableNotEquals.assertIterableNotEquals(expecteddMap.get(MeasurementType.HEART_RATE), result.get(MeasurementType.HEART_RATE));
        AssertIterableNotEquals.assertIterableNotEquals(expecteddMap.get(MeasurementType.SPO2), result.get(MeasurementType.SPO2));

    }
}
