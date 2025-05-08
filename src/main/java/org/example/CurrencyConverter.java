package org.example;

import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {
    private record CurrencyPair(Currency from, Currency to) {
        public static CurrencyPair of(Currency from, Currency to) {
            return new CurrencyPair(from, to);
        }
    }

    private final Map<CurrencyPair, ConversionRate> conversions = new HashMap<>();

    CurrencyConverter() {
        initConversionRates();
    }

    private void initConversionRates() {
        conversions.put(CurrencyPair.of(Currency.EURO, Currency.DOLLAR), ConversionRate.of(1.06304));
        conversions.put(CurrencyPair.of(Currency.DOLLAR, Currency.EURO), ConversionRate.of(0.94056));
    }

    Money convert(Money fromMoney, Currency toCurrency) {
        return convert(fromMoney.currency(), toCurrency, fromMoney.value());
    }

    Money convert(Currency fromCurrency, Currency toCurrency, double amount) {
        if (amount < 0) {
            throw new NegativeValueException("Negative amount cannot be converted.");
        }
        var conversionRate = getConversionRate(fromCurrency, toCurrency);
        var result = amount * conversionRate.value();
        return new Money(result, toCurrency);
    }

    ConversionRate getConversionRate(Currency fromCurrency, Currency toCurrency) {
        var currencyPair = CurrencyPair.of(fromCurrency, toCurrency);
        var currencyPairExists = conversions.containsKey(currencyPair);
        if (!currencyPairExists) {
            throw new CurrencyNotSupportedException(currencyPair.toString());
        }
        return conversions.get(currencyPair);
    }
}
