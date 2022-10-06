import java.util.Scanner;

public class StepTracker {
    private int purpose = 10000;
    private int days = 30;
    private int[][] year = new int[12][days];
    private int allStep = 0;
    private int maxStep = 0;
    private int meanStep = 0;
    private Scanner scanner = new Scanner(System.in);
    private Converter converter = new Converter();

    public int[][] stepInDay(int month, int day, int step) {
        year[month][day] = step;
        return year;
    }

    public void statistic(int month) {
            for (int j = 0; j < year[month].length; j++) {
                System.out.println((j + 1) + " день: " + year[month][j]);
            }
            this.allStep(month);
            this.maxStep(month);
            this.meanStep(month);

            System.out.println("Пройдена дистанция в " + converter.km(allStep) + " километров");
            System.out.println("Количество сожжённых килокалорий: " + converter.kilocalories(allStep));
            allStep = 0;

            this.bestSeries(month);
    }

    private void bestSeries(int i) {
        int days = 0;
        for (int j = 0; j < year[i].length; j++) {
            if (year[i][j] >= this.purpose) {
                days++;
            }
        }
        String dayStr = "дней";
        if (days == 1 || days == 21) {
            dayStr = "день";
        } else if (days >= 2 & days <= 4 || days >= 22 & days <= 24) {
            dayStr = "дня";
        }
        System.out.println("Лучшая серия: " + days + " " + dayStr + ".");
    }

    private void maxStep(int i) {
        for (int j = 0; j < year[i].length; j++) {
            if (maxStep < year[i][j]) {
                maxStep = year[i][j];
            }
        }
        System.out.println("Максимальное количество шагов было: " + maxStep);
        maxStep = 0;
    }

    private void meanStep(int i) {
        for (int j = 0; j < year[i].length; j++) {
            meanStep = allStep / days;
        }
        System.out.println("Среднее количество шагов: " + meanStep);
        meanStep = 0;
    }

    private void allStep(int i) {
        for (int j = 0; j < year[i].length; j++) {
            allStep = allStep + year[i][j];
        }
        System.out.println("Общее количество шагов: " + allStep);
    }

    public int target() {
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