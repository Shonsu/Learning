package pl.shonsu.modifiers;

import java.math.BigDecimal;

public interface Account {
    void deposit(BigDecimal amount);
    void withdraw(BigDecimal amount);
    BigDecimal getBalance();
}
