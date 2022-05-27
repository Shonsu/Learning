package pl.shonsu.modifiers;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BankAccount implements Account {

    private BigDecimal balance;

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BankAccount() {
        this(BigDecimal.valueOf(0));
    }

    public BankAccount(BigDecimal balance) {
        this.balance = balance.setScale(2, RoundingMode.HALF_EVEN);
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    @Override
    final public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("amount must be >= 0");
        }
        setBalance(this.balance.add(amount.setScale(2, RoundingMode.HALF_EVEN)));

    }

    @Override
    final public void withdraw(BigDecimal amount) { // new BigDecimal(String "1")
        if (amount.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("amount must be >= 0");
        }
        setBalance(this.balance.subtract(amount.setScale(2, RoundingMode.HALF_EVEN)));

    }
}
