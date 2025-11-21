public class CustomException {

    public static void main(String[] args) {
        BankAccount account = new BankAccount(100.00);

        try {
            System.out.println("Попытка снять 50...");
            account.withdraw(50.00);
            System.out.println("Успешно.");

            System.out.println("Попытка снять 200...");
            account.withdraw(200.00);
            System.out.println("Успешно.");

        } catch (InsufficientFundsException e) {
            System.out.println("\n--- ПЕРЕХВАЧЕНО ИСКЛЮЧЕНИЕ ---");
            System.out.println("Сообщение: " + e.getMessage());
            System.out.println("Не хватает средств: " + e.getAmountShort());
        }
    }
}

// 1. Собственное исключение
class InsufficientFundsException extends Exception {
    private double amountShort;

    public InsufficientFundsException(String message, double amountShort) {
        super(message);
        this.amountShort = amountShort;
    }

    public double getAmountShort() {
        return amountShort;
    }
}

class BankAccount {
    private double balance;

    public BankAccount(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            double needs = amount - balance;
            throw new InsufficientFundsException("Недостаточно денег на счете", needs);
        }
        balance -= amount;
        System.out.println("Новый баланс: " + balance);
    }
}