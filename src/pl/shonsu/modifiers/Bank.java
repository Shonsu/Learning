package pl.shonsu.modifiers;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Bank implements BankTransfer {

    private BigDecimal fixedFee;

    public BigDecimal getFixedFee() {
        return this.fixedFee;
    }

    public void setFixedFee(BigDecimal fixedFee) {
        this.fixedFee = fixedFee.setScale(2,RoundingMode.HALF_EVEN);
    }

    public Bank() {
        //fixedFee = new BigDecimal("1");
        fixedFee = BigDecimal.valueOf(Long.parseLong("1"));
    }

    public Bank(BigDecimal fixedFee) {
        this.fixedFee = fixedFee.setScale(2,RoundingMode.HALF_EVEN);
    }


    @Override
    final public void transfer(Account from, Account to, BigDecimal amount) {
        if(amount.compareTo(BigDecimal.ZERO)==0 || from.getBalance().compareTo(amount.add(fixedFee))<0){
            throw new IllegalArgumentException("Not enough funds or amount = 0");
        }
       from.withdraw(amount.setScale(2,RoundingMode.HALF_EVEN).add(fixedFee));
       to.deposit(amount.setScale(2,RoundingMode.HALF_EVEN));
    }

}
