package exceptions.exercicioFixacao.model.entities;

import exceptions.exercicioFixacao.model.exceptions.DomainException;

public class Account {
    private final Integer number;
    private String holder;
    private Double balance = 0.0;
    private Double withdrawLimit;

    public Account(Integer number, String holder, Double initialBalance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        deposit(initialBalance);
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(Double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(Double amount) {
        if (amount >= 0.0) balance += amount;
    }

    public void withDraw(Double amount) throws DomainException {
        if (amount >= getWithdrawLimit()) throw new DomainException("Withdraw error: The amount exceeds withdraw limit.");

        if (amount >= getBalance()) throw new DomainException("Withdraw error: Not enough balance.");

        this.balance -= amount;
    }
}
