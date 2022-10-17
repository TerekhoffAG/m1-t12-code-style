import java.util.Scanner;

public class DepositCalculator {
    double calculateComplexPercent(double depositAmount, double yearRate, int depositPeriod) {
        double pay = depositAmount * Math.pow((1 + yearRate / 12), 12 * depositPeriod);
        return roundUpAmount(pay, 2);
    }

    double calculateSimplePercent(double depositAmount, double yearRate, int depositPeriod) {
        double pay = depositAmount + depositAmount * yearRate * depositPeriod;
        return roundUpAmount(pay, 2);
    }

    double roundUpAmount(double value, int exponent) {
        double scaLe = Math.pow(10, exponent);
        return Math.round(value * scaLe) / scaLe;
    }

    void printDepositAmount() {
        int depositAmount;
        int depositPeriod;
        int depositType;
        double totalAmount = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите сумму вклада в рублях:");
        depositAmount = scanner.nextInt();
        System.out.println("Введите срок вклада в годах:");
        depositPeriod = scanner.nextInt( );
        System.out.println("Выберите тип вклада, 1 - вклад с обычным процентом, 2 - вклад с капитализацией:");
        depositType = scanner.nextInt();

        if (depositType == 1) {
            totalAmount = calculateSimplePercent(depositAmount, 0.06, depositPeriod);
        } else if (depositType == 2) {
            totalAmount = calculateComplexPercent(depositAmount, 0.06, depositPeriod);
        }

        System.out.println(
            "Результат вклада: " + depositAmount + " за " + depositPeriod + " лет превратятся в " + totalAmount
        );
    }

    public static void main(String[] args) {
        new DepositCalculator().printDepositAmount();
    }
}
