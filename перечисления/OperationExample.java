enum Operation {
    PLUS {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    },
    MULTIPLY {
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE {
        @Override
        public double apply(double x, double y) {
            if (y == 0) throw new ArithmeticException("Деление на ноль!");
            return x / y;
        }
    };
    public abstract double apply(double x, double y);
}

public class OperationExample {
    public static void main(String[] args) {
        double a = 10.0;
        double b = 2.0;

        for (Operation op : Operation.values()) {
            System.out.printf("%.1f %s %.1f = %.1f%n",
                    a, op.name(), b, op.apply(a, b));
        }

        Operation op = Operation.MULTIPLY;
        System.out.println("\nОтдельный тест умножения: " + op.apply(5, 5));
    }
}