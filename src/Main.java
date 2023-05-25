import java.util.Scanner;

public class Main {
    private final StepTracker stepTracker = new StepTracker();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.program();
    }
    private void program(){
        printMenu();
        int command = scanner.nextInt();
        while (command != 0) {
            if (command == 1) {
                stepTracker.commandOne();
            } else if (command == 2) {
                stepTracker.commandTwo();
            } else if (command == 3) {
                stepTracker.commandThree();
            } else {
                System.out.println("Пожалуйста, введите правильное значение.");
            }
            printMenu();
            command = scanner.nextInt();
        }
        System.out.println("Программа завершена.");
    }
    public void printMenu(){
        System.out.println("Что вы желаете сделать?");
        System.out.println("1 - Ввести количество шагов за определённый день.");
        System.out.println("2 - Напечатать статистику за определённый месяц.");
        System.out.println("3 - Изменить цель по количеству шагов в день.");
        System.out.println("0 - Выход из приложения.");
    }
}