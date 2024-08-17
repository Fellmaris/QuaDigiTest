package org.example.Services;

import org.example.Objects.Measurement;

import java.util.LinkedList;
import java.util.List;

public class SampleValidation {

    public List<Measurement> validateMeasurements(List<Measurement> toValidate) {
        List<Measurement> validated = new LinkedList<>();

        for (Measurement measurement : toValidate) {
            if (isValidMeasurement(measurement)) {
                validated.add(measurement);
            } else {
                System.err.println("Validation failed for a measurement: " + getValidationError(measurement));
            }
        }

        return validated;
    }

    private boolean isValidMeasurement(Measurement measurement) {
        return measurement != null &&
                measurement.getMeasurementTime() != null &&
                measurement.getMeasurementValue() != null &&
                measurement.getMeasurementType() != null;
    }

    private String getValidationError(Measurement measurement) {
        if (measurement == null) {
            return "Measurement cannot be null.";
        }
        if (measurement.getMeasurementTime() == null) {
            return "MeasurementTime cannot be null.";
        }
        if (measurement.getMeasurementValue() == null) {
            return "MeasurementValue cannot be null.";
        }
        if (measurement.getMeasurementType() == null) {
            return "MeasurementType cannot be null.";
        }
        return "Unknown validation error.";
    }
}