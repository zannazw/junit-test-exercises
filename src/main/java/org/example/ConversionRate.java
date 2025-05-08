package org.example;

public record ConversionRate(double value) {
    static ConversionRate of(double value) {
        return new ConversionRate(value);
    }
}
