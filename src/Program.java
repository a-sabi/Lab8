import java.util.Scanner;
public class Program {
    public static void main(String[] args) {
        int num1, den1, num2, den2;
        String sign;
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Введите выражение: ");
            String[] mas = sc.nextLine().split(" ");
            try {
                num1 = Integer.parseInt(mas[0].split("/")[0]);
                den1 = Integer.parseInt(mas[0].split("/")[1]);
                num2 = Integer.parseInt(mas[2].split("/")[0]);
                den2 = Integer.parseInt(mas[2].split("/")[1]);
                sign = mas[1];
            } catch (Exception e) {
                System.out.println("Выражение введено неверно. Повторите еще раз.");
                continue;
            }
            Fraction fract1 = new Fraction(num1, den1);
            Fraction fract2 = new Fraction(num2, den2);
            switch (sign) {
                case "+":
                    System.out.println(fract1.add(fract2));
                    break;
                case "-":
                    System.out.println(fract1.sub(fract2));
                    break;
                case "*":
                    System.out.println(fract1.mul(fract2));
                    break;
                case ":":
                    System.out.println(fract1.div(fract2));
                    break;
                default:
                    System.out.println("Неправильный знак. Повторите снова.");
                    break;
            }
            break;
        }
    }
}
