import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int purpose = 10000;
        int days = 30;
        int[][] year = new int[12][days];

        Scanner scanner = new Scanner(System.in);
        printMenu();
        int command = scanner.nextInt();
        while (command != 0) {
            if (command == 1) {
                System.out.println("Какой день хотите выбрать?");
                System.out.println("Укажите месяц (цифрой):");

                int monthPersonal = scanner.nextInt();
                int month = monthPersonal - 1;
                while (monthPersonal < 0){
                    System.out.println("Прошу, проверьте вводимое значение и повторите ввод:");
                    monthPersonal = scanner.nextInt();
                    month = monthPersonal - 1;
                }
                while (monthPersonal > 12){
                    System.out.println("Прошу, проверьте вводимое значение и повторите ввод:");
                    monthPersonal = scanner.nextInt();
                    month = monthPersonal -1;
                }
                System.out.println("Укажите день:");
                int dayPersonal = scanner.nextInt();
                int day = dayPersonal - 1;
                while (dayPersonal < 1){
                    System.out.println("Прошу, проверьте вводимое значение и повторите ввод:");
                    dayPersonal = scanner.nextInt();
                    day = dayPersonal - 1;
                }
                while (dayPersonal > 30){
                    System.out.println("Прошу, проверьте вводимое значение и повторите ввод:");
                    dayPersonal = scanner.nextInt();
                    day = dayPersonal - 1;
                }
                System.out.println("Укажите шаги:");
                int step = scanner.nextInt();
                while (step < 0){
                    System.out.println("Пожалуйста, введите положительное значение.");
                }
                System.out.println("Количество шагов " + (day+1) + "." + (month+1) + ": " + step);
                StepTracker.stepInDay(month, day, step, year);
            } else if (command == 2) {
                System.out.println("За какой месяц напечатать статистику?");
                int monthPersonal = scanner.nextInt();
                int month = monthPersonal -1;
                StepTracker.statistic(month, purpose, year);

            } else if (command == 3) {
                System.out.println("Какую ежедневную цель хотите установить?");
                purpose = StepTracker.target();
                System.out.println("Поздравляю, теперь ваша ежедневная цель: " + purpose);
            } else if (command < 0) {
                System.out.println("Пожалуйста, введите правильное значение.");
            } else if (command > 3){
                System.out.println("Пожалуйста, введите правильное значение.");
            }
            printMenu();
            command = scanner.nextInt();
        }
        System.out.println("Программа завершена.");
    }
    private static void printMenu(){
        System.out.println("Что вы желаете сделать?");
        System.out.println("1 - Ввести количество шагов за определённый день.");
        System.out.println("2 - Напечатать статистику за определённый месяц.");
        System.out.println("3 - Изменить цель по количеству шагов в день.");
        System.out.println("0 - Выход из приложения.");
    }
}
