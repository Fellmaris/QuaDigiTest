package org.example.Objects;

import org.example.Types.MeasurementType;

import java.time.LocalDateTime;
import java.util.Objects;

public class Measurement {

    private LocalDateTime measurementTime;
    private Double measurementValue;
    private MeasurementType measurementType;

    public Measurement(LocalDateTime measurementTime, Double measurementValue, MeasurementType measurementType) {
        this.measurementTime = measurementTime;
        this.measurementValue = measurementValue;
        this.measurementType = measurementType;
    }

    public LocalDateTime getMeasurementTime() {
        return measurementTime;
    }

    public void setMeasurementTime(LocalDateTime measurementTime) {
        this.measurementTime = measurementTime;
    }

    public Double getMeasurementValue() {
        return measurementValue;
    }

    public void setMeasurementValue(Double measurementValue) {
        this.measurementValue = measurementValue;
    }

    public MeasurementType getMesurementType() {
        return measurementType;
    }

    public void setMesurementType(MeasurementType measurementType) {
        this.measurementType = measurementType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Measurement that = (Measurement) o;
        return Objects.equals(measurementTime, that.measurementTime) && Objects.equals(measurementValue, that.measurementValue) && measurementType == that.measurementType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(measurementTime, measurementValue, measurementType);
    }
}
