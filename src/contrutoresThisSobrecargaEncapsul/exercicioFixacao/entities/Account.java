package contrutoresThisSobrecargaEncapsul.exercicioFixacao.entities;

public class Account {
    private final Integer number;
    private String holder;
    private double balance;

    public Integer getNumber() {
        return this.number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String newName) {
        this.holder = newName;
    }

    public void deposit(Double amount) {
        balance += amount;
    }

    public void withdraw(Double amount) {
        balance -= (amount + 5.00);
    }

    public double getBalance() {
        return balance;
    }

    public Account(Integer numberAcc, String holderAcc) {
        number = numberAcc;
        holder = holderAcc;
    }

    public Account(Integer numberAcc, String holderAcc, double initialDeposit) {
        this(numberAcc, holderAcc);
        deposit(initialDeposit);
    }

    @Override
    public String toString() {
        return "Account " + number
                + ", Holder: "
                + holder + ", Balance: $ "
                + String.format("%.2f", balance);
    }
}
