import java.util.Scanner;

public class Main {
    private StepTracker stepTracker = new StepTracker();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.program();
    }
    private void program(){
        printMenu();
        int command = scanner.nextInt();
        while (command != 0) {
            if (command == 1) {
                System.out.println("Какой день хотите выбрать?");
                System.out.println("Укажите месяц (цифрой):");

                int month = scanner.nextInt();
                month = this.testMonth(month)-1;

                System.out.println("Укажите день:");
                int day = scanner.nextInt();
                day = this.testDay(day) - 1;

                System.out.println("Укажите шаги:");
                int step = scanner.nextInt();
                step = this.testStep(step);

                System.out.println("Количество шагов " + (day + 1) + "." + (month + 1) + ": " + step);
                stepTracker.stepInDay(month, day, step);
            } else if (command == 2) {
                System.out.println("За какой месяц напечатать статистику?");
                int month = scanner.nextInt();
                month = this.testMonth(month)-1;
                stepTracker.statistic(month);

            } else if (command == 3) {
                System.out.println("Какую ежедневную цель хотите установить?");
                System.out.println("Поздравляю, теперь ваша ежедневная цель: " + stepTracker.target());
            } else if (command < 0 | command > 3) {
                System.out.println("Пожалуйста, введите правильное значение.");
            }
            printMenu();
            command = scanner.nextInt();
        }
        System.out.println("Программа завершена.");
    }
    private void printMenu(){
        System.out.println("Что вы желаете сделать?");
        System.out.println("1 - Ввести количество шагов за определённый день.");
        System.out.println("2 - Напечатать статистику за определённый месяц.");
        System.out.println("3 - Изменить цель по количеству шагов в день.");
        System.out.println("0 - Выход из приложения.");
    }
    public int testMonth(int month) {
        while (month < 1 | month > 12) {
            System.out.println("Прошу, проверьте вводимое значение и повторите ввод:");
            month = scanner.nextInt();
        }
        return month;
    }
    public int testDay(int day) {
        while (day < 1 | day > 30) {
            System.out.println("Прошу, проверьте вводимое значение и повторите ввод:");
            day = scanner.nextInt();
        }
        return day;
    }
    public int testStep(int step) {
        while (step < 0) {
            System.out.println("Пожалуйста, введите положительное значение.");
            step = scanner.nextInt();
        }
        return step;
    }
}