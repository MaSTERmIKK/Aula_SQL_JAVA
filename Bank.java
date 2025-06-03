// ===== Classe BankAccount =====
public class BankAccount {
    private String accountHolderName;
    private double balance;

    // Costruttore
    public BankAccount(String accountHolderName, double balance) {
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    // ===== Metodo per il deposito =====
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposito di " + amount + " effettuato.");
        } else {
            System.out.println("Importo non valido per il deposito.");
        }
    }

    // ===== Metodo per il prelievo =====
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Prelievo di " + amount + " effettuato.");
        } else {
            System.out.println("Impossibile effettuare il prelievo. Saldo insufficiente o importo non valido.");
        }
    }

    // ===== Metodo per mostrare il saldo =====
    public void displayBalance() {
        System.out.println("Saldo attuale: " + balance);
    }

    // Getter (opzionali per test)
    public String getAccountHolderName() {
        return accountHolderName;
    }
    public double getBalance() {
        return balance;
    }

    // ===== MAIN di esempio =====
    public static void main(String[] args) {
        BankAccount conto = new BankAccount("Mario Rossi", 100.0);

        conto.displayBalance();   // Saldo iniziale
        conto.deposit(50);       // Deposito
        conto.displayBalance();   // Saldo dopo deposito
        conto.withdraw(30);      // Prelievo
        conto.displayBalance();   // Saldo dopo prelievo
        conto.withdraw(200);     // Prelievo non valido
        conto.displayBalance();   // Saldo finale
    }
}
