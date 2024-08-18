import org.example.dto.Measurement;
import org.example.Validator.Validation;
import org.example.Enum.MeasurementType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidationTest {

    private Validation sampleValidation;

    @BeforeEach
    public void setUp() {
        sampleValidation = new Validation();
    }

    @Test
    public void validateMeasurements_ValidMesurements_EqualLists() {
        Measurement validMeasurement = new Measurement(LocalDateTime.now(), 25.5, MeasurementType.TEMPERATURE);
        List<Measurement> result = sampleValidation.validateMeasurements(Collections.singletonList(validMeasurement));
        assertEquals(1, result.size());
        assertEquals(validMeasurement, result.get(0));
    }

    @Test
    public void validateMeasurements_NullMeasurements_EmptyList() {
        Measurement nullMeasurement = null;
        List<Measurement> result = sampleValidation.validateMeasurements(Collections.singletonList(nullMeasurement));
        assertEquals(0, result.size());
    }

    @Test
    public void validateMeasurements_NullTime_EmptyList() {
        Measurement invalidMeasurement = new Measurement(null, 25.5, MeasurementType.TEMPERATURE);
        List<Measurement> result = sampleValidation.validateMeasurements(Collections.singletonList(invalidMeasurement));
        assertEquals(0, result.size());
    }

    @Test
    public void validateMeasurements_NullValue_EmptyList() {
        Measurement invalidMeasurement = new Measurement(LocalDateTime.now(), null, MeasurementType.TEMPERATURE);
        List<Measurement> result = sampleValidation.validateMeasurements(Collections.singletonList(invalidMeasurement));
        assertEquals(0, result.size());
    }

    @Test
    public void validateMeasurements_NullType_EmptyList() {
        Measurement invalidMeasurement = new Measurement(LocalDateTime.now(), 25.5, null);
        List<Measurement> result = sampleValidation.validateMeasurements(Collections.singletonList(invalidMeasurement));
        assertEquals(0, result.size());
    }

    @Test
    public void validateMeasurements_MultipleMeasurements_2ValuesInList() {
        Measurement validMeasurement1 = new Measurement(LocalDateTime.now(), 25.5, MeasurementType.TEMPERATURE);
        Measurement validMeasurement2 = new Measurement(LocalDateTime.now(), 15.3, MeasurementType.SPO2);
        Measurement invalidMeasurement = new Measurement(null, 30.0, MeasurementType.TEMPERATURE);
        List<Measurement> result = sampleValidation.validateMeasurements(Arrays.asList(validMeasurement1, validMeasurement2, invalidMeasurement));
        assertEquals(2, result.size());
        assertEquals(validMeasurement1, result.get(0));
        assertEquals(validMeasurement2, result.get(1));
    }
}

