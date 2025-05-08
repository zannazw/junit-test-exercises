package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CurrencyConverterTest {

    private CurrencyConverter currencyConverter;

    @BeforeEach
    void setUp() {
        this.currencyConverter = new CurrencyConverter();
    }

    @Test
    void shouldThrowException_whenNegativeAmountIsToBeConverted() {
        //given
        double inputAmount = -10;
        Money input = new Money(inputAmount, Currency.EURO);
        //when & then
        assertThrows(NegativeValueException.class, () -> currencyConverter.convert(input, Currency.DOLLAR));
    }

    @Test
    void shouldConvertMoney_whenMethodIsCalled() {
        //given
        double conversionRate = 1.06304;
        double amount = 10;
        Money expectedResult = new Money(amount * conversionRate, Currency.DOLLAR);
        //when & then
        assertEquals(expectedResult, currencyConverter.convert(Currency.EURO, Currency.DOLLAR, amount));
    }

    @Test
    void shouldGetConversionRate_whenMethodIsCalled() {
        //given
        ConversionRate expectedResult = new ConversionRate(1.06304);
        //when & then
        assertEquals(expectedResult, currencyConverter.getConversionRate(Currency.EURO, Currency.DOLLAR));
    }

    @Test
    void shouldThrowException_whenCurrencyIsInvalid() {
        assertThrows(CurrencyNotSupportedException.class, () -> currencyConverter.getConversionRate(Currency.INVALID, Currency.DOLLAR));
    }
}