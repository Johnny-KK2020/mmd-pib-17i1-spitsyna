import static java.lang.Double.NaN;

public class Calc {
    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Отсутствуют агрументы");
            return;
        }
        if (args.length < 3) {
            System.out.println("Меньше 3 аргументов");
            return;
        }
        if (args.length > 3) {
            System.out.println("Больше 3 аргументов");
            return;
        }
        try {
            double a = Double.parseDouble(args[0]);
            double b = Double.parseDouble(args[2]);
            char operation = args[1].charAt(0);
            double result = calc(a,b,operation);
            if (operation == '/' && -1e-12 < b && b < 1e-12) {
                System.out.println("Делить на ноль нельзя");
                return;
            }
            System.out.println("Результат : " + result);
        } catch (NumberFormatException exception) {
            System.out.println("Введите цифры!");
        }
    }

    public static double calc(double x, double y, char z) {
        switch (z) {
            case '+':
                return x + y;
            case '-':
                return x - y;
            case '*':
                return x * y;
            case '/':
                return x / y;
            default:
                return NaN;
        }
    }
}
