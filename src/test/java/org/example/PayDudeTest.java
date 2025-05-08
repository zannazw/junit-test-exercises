package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PayDudeTest {

    PayDude payDude;

    @BeforeEach
    void setUp() {
        this.payDude = new PayDude();
    }

    @Test
    void shouldAddAmountToBalance_whenAmountIsDeposited() {
        //given
        long expectedResult = 7;
        //when
        payDude.deposit(expectedResult);
        long actualResult = payDude.getBalance();
        //then
        assertEquals(expectedResult, actualResult);
    }

    @Test
    void shouldThrowException_whenNegativeAmountIsDeposited() {
        //given
        long expectedResult = 0;
        long input = -10;
        //when & then
        assertThrows(PayDudeException.class, () -> payDude.deposit(input));
        assertEquals(expectedResult, payDude.getBalance());
    }

    @Test
    void shouldTransferAmountToRecipient_whenBalanceIsSufficient() {
        //given
        PayDude recipient = new PayDude();
        long amount = 10;
        payDude.deposit(amount);
        long expectedResult = 0;
        //when
        payDude.transfer(amount, recipient);
        long actualResult = payDude.getBalance();
        //then
        assertAll(
                () -> assertEquals(expectedResult, actualResult),
                () -> assertEquals(amount, recipient.getBalance())
        );
    }

    @Test
    void shouldThrowException_whenTransferringAmountWhileBalanceIsNotSufficient() {
        //given
        PayDude recipient = new PayDude();
        long amount = 10;
        Class<PayDudeException> expectedResult = PayDudeException.class;
        //when & then
        assertThrows(expectedResult, () -> payDude.transfer(amount, recipient));
        assertEquals(0, recipient.getBalance());
    }

    @Test
    void shouldReturnBalance_whenMethodIsCalled() {
        //given
        long expectedResult = 100;
        payDude.deposit(expectedResult);
        //when
        long actualResult = payDude.getBalance();
        //then
        assertEquals(expectedResult, actualResult);
    }
}