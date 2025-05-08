package org.example;

public class PayDude {
    private long balance = 0; // Steht für eine beliebige Währung in Cents

    void deposit(long amount) { // Geld einzahlen
        assertNotNegative(amount);
        balance += amount;
    }

    void transfer(long amount, PayDude recipient) { // Geld überweisen
        assertNotNegative(amount);
        assertBalanceIsSufficient(amount);
        balance -= amount;
        recipient.deposit(amount);
    }

    private void assertBalanceIsSufficient(long amount) { // Prüfen, ob ausreichend Geld vorhanden ist
        if (balance < amount) {
            throw new PayDudeException("Go get some money, dude.");
        }
    }

    private void assertNotNegative(long amount) {
        if (amount < 0) {
            throw new PayDudeException("Negative amounts are not allowed.");
        }
    }

    long getBalance() {
        return balance;
    }
}
