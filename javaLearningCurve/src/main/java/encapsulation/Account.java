package encapsulation;

public class Account extends javaSyntax.Account {
    
    public Account(double balance, double intrestRate) {
        if (!isValidNubers(balance, intrestRate)){
            throw new IllegalArgumentException("Ugyldige nummer");
        }
        this.balance = balance;
        this.intrestRate = intrestRate;
    }

    //Validering
    public boolean isValidNubers(double balance, double intrestRate) {
        if(balance < 0 || intrestRate < 0){
            return false;
        }
        return true;
    }

    public boolean isValidNum(double number) {
        if (number < 0) {
            return false;
        }
        return true;
    }

    @Override
    public void setInterestRate(double x) {
        if (!isValidNum(x)){
            throw new IllegalArgumentException("Ugyldig rente");
        }
        super.setInterestRate(x);
    }

    @Override
    public void deposit(double x) {
        if(!isValidNum(x)) {
            throw new IllegalArgumentException("Ugyldig nummer");
        }
        super.deposit(x);
    }
    
    public void withdraw(double x) {
        if (!isValidNum(x)) {
            throw new IllegalArgumentException("Ugyldig nummer");
        }
        if ((getBalance() - x) < 0 ) {
            throw new IllegalArgumentException("Kan ikke ta ut mer enn på konto");
        }
        this.balance -= x;
    }

    public static void main(String[] args) {
     Account p = new Account(100, 2);
     

     System.out.println(p.getBalance());
     p.addInterest();
     System.out.println(p.getBalance());
    }
}
