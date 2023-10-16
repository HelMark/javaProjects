package javaSyntax;

public class Account {
    protected double balance;
    protected double intrestRate;

    public Account() {
        this.balance = 0.0;
        this.intrestRate = 0.0;
    }
    
    public void deposit(double x) {
        if (x > 0) {
            this.balance += x;
        }
    }

    public void addInterest() {
        double intrest = this.intrestRate / 100;
        double intrestFromBalance = this.balance * intrest;
        this.balance += intrestFromBalance;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setInterestRate(double x) {
        this.intrestRate = x;
    }

    public double getInterestRate() {
        return this.intrestRate;
    }

    public static void main(String[] args) {
        Account ola = new Account();
        ola.deposit(10000);
        ola.setInterestRate(2);
        
        System.out.println(ola.getBalance());
        ola.addInterest();
        System.out.println(ola.getBalance());
    }
}
