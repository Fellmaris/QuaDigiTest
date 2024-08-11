package org.example.Services;

import org.example.Objects.Measurement;
import org.example.Types.MeasurementType;

import java.time.LocalDateTime;
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
                if (!(measurement.getMeasurementTime() instanceof LocalDateTime)) {
                    throw new IllegalArgumentException("MeasurementTime must be of type LocalDateTime.");
                }

                if (!(measurement.getMeasurementValue() instanceof Double)) {
                    throw new IllegalArgumentException("MeasurementValue must be of type Double.");
                }

                if (!(measurement.getMeasurementType() instanceof MeasurementType)) {
                    throw new IllegalArgumentException("MeasurementType must be of type MeasurementType.");
                }
                validated.add(measurement);
            } catch (IllegalArgumentException e) {
            System.err.println("Validation failed for a measurement: " + e.getMessage());
            }
        }
        return validated;
    }

}
