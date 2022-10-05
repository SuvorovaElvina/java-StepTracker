import java.util.Scanner;

public class StepTracker {

    public static int[][] stepInDay(int month, int day, int step, int[][] year){
        for (int i = month; i == month; i++){
            for (int j = day; j == day; j++){
                year[i][j] = step;
            }
        }
        return year;
    }
    public static void statistic(int month, int purpose, int[][] year){
        int stepInMonth = 0;
        int maxStep = 0;
        int meanStep = 0;
        int k =0;
        int days = 30;
        for (int i = month; i == month; i++) {
            for (int j = 0; j < year[i].length; j++) {
                System.out.println((j + 1) + " день: " + year[i][j]);
            }
            for (int j = 0; j < year.length; j++) {
                stepInMonth = stepInMonth + year[i][j];
            }
            System.out.println("Общее количество шагов: " + stepInMonth);
            for (int j = 0; j < year.length; j++) {
                if (maxStep < year[i][j]) {
                    maxStep = year[i][j];
                }
            }
            System.out.println("Максимальное количество шагов было: " + maxStep);
            for (int j = 0; j < year.length; j++) {
                meanStep = stepInMonth / days;
            }
            System.out.println("Среднее количество шагов: " + meanStep);
            System.out.println("Пройдена дистанция в " + Converter.km(stepInMonth) + " километров");
            System.out.println("Количество сожжённых килокалорий: " + Converter.kl(stepInMonth));
            for (int j = 0; j < year.length; j++) {
                if (year[i][j] >= purpose) {
                    k = k + 1;
                }
            }
            if (k == 1 | k == 21) {
                System.out.println("Лучшая серия: " + k + " день.");
            } else if (k == 2 | k == 3 | k == 4 | k == 22 | k == 23 | k == 24) {
                System.out.println("Лучшая серия: " + k + "дня.");
            } else {
                System.out.println("Лучшая серия: " + k + "дней.");
            }

        }
    }
    public static int target(){
        Scanner scanner = new Scanner(System.in);
        int purpose;
        purpose = scanner.nextInt();
        while (purpose < 0) {
            System.out.println("Пожалуйста, вводите положительное значение: ");
            purpose = scanner.nextInt();
        }
        return purpose;
    }
}


