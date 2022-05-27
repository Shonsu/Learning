package pl.shonsu.modifiers;

import java.math.BigDecimal;

public interface BankTransfer {
    void transfer(Account from, Account to, BigDecimal amount);
}
