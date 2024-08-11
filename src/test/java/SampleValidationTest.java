import org.example.Objects.Measurement;
import org.example.Services.SampleValidation;
import org.example.Types.MeasurementType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SampleValidationTest {

    private SampleValidation sampleValidation;

    @BeforeEach
    public void setUp() {
        sampleValidation = new SampleValidation();
    }

    @Test
    public void testValidMeasurement() {
        Measurement validMeasurement = new Measurement(LocalDateTime.now(), 25.5, MeasurementType.TEMPERATURE);
        List<Measurement> result = sampleValidation.validateMeasurements(Collections.singletonList(validMeasurement));
        assertEquals(1, result.size());
        assertEquals(validMeasurement, result.get(0));
    }

    @Test
    public void testNullMeasurement() {
        Measurement nullMeasurement = null;
        List<Measurement> result = sampleValidation.validateMeasurements(Collections.singletonList(nullMeasurement));
        assertEquals(0, result.size());
    }

    @Test
    public void testNullMeasurementTime() {
        Measurement invalidMeasurement = new Measurement(null, 25.5, MeasurementType.TEMPERATURE);
        List<Measurement> result = sampleValidation.validateMeasurements(Collections.singletonList(invalidMeasurement));
        assertEquals(0, result.size());
    }

    @Test
    public void testNullMeasurementValue() {
        Measurement invalidMeasurement = new Measurement(LocalDateTime.now(), null, MeasurementType.TEMPERATURE);
        List<Measurement> result = sampleValidation.validateMeasurements(Collections.singletonList(invalidMeasurement));
        assertEquals(0, result.size());
    }

    @Test
    public void testNullMeasurementType() {
        Measurement invalidMeasurement = new Measurement(LocalDateTime.now(), 25.5, null);
        List<Measurement> result = sampleValidation.validateMeasurements(Collections.singletonList(invalidMeasurement));
        assertEquals(0, result.size());
    }

    @Test
    public void testMultipleMeasurements() {
        Measurement validMeasurement1 = new Measurement(LocalDateTime.now(), 25.5, MeasurementType.TEMPERATURE);
        Measurement validMeasurement2 = new Measurement(LocalDateTime.now(), 15.3, MeasurementType.SPO2);
        Measurement invalidMeasurement = new Measurement(null, 30.0, MeasurementType.TEMPERATURE);
        List<Measurement> result = sampleValidation.validateMeasurements(Arrays.asList(validMeasurement1, validMeasurement2, invalidMeasurement));
        assertEquals(2, result.size());
        assertEquals(validMeasurement1, result.get(0));
        assertEquals(validMeasurement2, result.get(1));
    }
}

