package pl.shonsu.modifiers;

import java.math.BigDecimal;

public class ModifiersApp {
    public static void main(String[] args) {

        Bank bank = new Bank();
        
        System.out.println(BigDecimal.valueOf(1.1));
        System.out.println(new BigDecimal(1.1));
        System.out.println(new BigDecimal("1.1"));
        
        BankAccount account1 = new BankAccount(BigDecimal.valueOf(90.9));
        BankAccount account2 = new BankAccount(BigDecimal.valueOf(100.9));

        bank.transfer(account1, account2, new BigDecimal(70));

        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());
        
    }
}
