package org.example.Services;

import org.example.Objects.Measurement;

import java.util.LinkedList;
import java.util.List;

public class SampleValidation {

    public List<Measurement> validateMeasurements(List<Measurement> toValidate) {
        List<Measurement> validated = new LinkedList<>();
        for (Measurement measurement : toValidate) {
            try {
                if (measurement == null) {
                    throw new IllegalArgumentException("Measurement cannot be null.");
                }
                if (measurement.getMeasurementTime() == null) {
                    throw new IllegalArgumentException("MeasurementTime cannot be null.");
                }
                if (measurement.getMeasurementValue() == null) {
                    throw new IllegalArgumentException("MeasurementValue cannot be null.");
                }
                if (measurement.getMeasurementType() == null) {
                    throw new IllegalArgumentException("MeasurementType cannot be null.");
                }
                validated.add(measurement);
            } catch (IllegalArgumentException e) {
            System.err.println("Validation failed for a measurement: " + e.getMessage());
            }
        }
        return validated;
    }

}
