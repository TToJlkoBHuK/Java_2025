enum Coin {
    PENNY(1),
    NICKEL(5),
    DIME(10),
    QUARTER(25);

    private final int value;

    Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

public class CoinExample {
    public static void main(String[] args) {
        for (Coin c : Coin.values()) {
            System.out.println("Монета: " + c + ", Номинал: " + c.getValue() + " цент(ов)");
        }

        Coin myCoin = Coin.QUARTER;
        System.out.println("\nУ меня есть: " + myCoin.name() +
                " стоимостью " + myCoin.getValue());
    }
}
