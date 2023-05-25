import java.util.Scanner;

public class StepTracker {
    private int purpose = 10000;
    private final int DAYS = 30;
    private final int[][] YEAR = new int[12][DAYS];
    private int allStep = 0;
    private int maxStep = 0;
    private int meanStep = 0;
    private final Scanner scanner = new Scanner(System.in);

    public void commandOne(){
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
        this.stepInDay(month, day, step);
    }

    public void commandTwo(){
        System.out.println("За какой месяц напечатать статистику?");
        int month = scanner.nextInt();
        month = this.testMonth(month)-1;
        this.statistic(month);
    }

    public void commandThree(){
        System.out.println("Какую ежедневную цель хотите установить?");
        System.out.println("Поздравляю, теперь ваша ежедневная цель: " + this.target());
    }

    private void stepInDay(int month, int day, int step) {
        YEAR[month][day] = step;
    }

    private void statistic(int month) {
        for (int j = 0; j < YEAR[month].length; j++) {
            System.out.println((j + 1) + " день: " + YEAR[month][j]);
        }
        this.allStep(month);
        this.maxStep(month);
        this.meanStep(month);

        System.out.println("Пройдена дистанция в " + Converter.km(allStep) + " километров");
        System.out.println("Количество сожжённых килокалорий: " + Converter.kilocalories(allStep));
        allStep = 0;

        this.printBestSeries(this.bestSeries(month));
    }

    private int bestSeries(int i) {
        int currentSeries = 0, bestSeries = 0;
        for (int j = 0; j < YEAR[i].length - 1; j++) {
            if (YEAR[i][j] >= this.purpose) {
                currentSeries++;
                if (currentSeries > bestSeries) {
                    bestSeries = currentSeries;
                }
            } else {
                currentSeries = 0;
            }
        }
        return bestSeries;
    }

    private void printBestSeries(int days) {
        String dayStr = "дней";
        if (days == 1 || days == 21) {
            dayStr = "день";
        } else if (days >= 2 & days <= 4 || days >= 22 & days <= 24) {
            dayStr = "дня";
        }
        System.out.println("Лучшая серия: " + days + " " + dayStr + ".");
    }

    private void maxStep(int i) {
        for (int j = 0; j < YEAR[i].length; j++) {
            if (maxStep < YEAR[i][j]) {
                maxStep = YEAR[i][j];
            }
        }
        System.out.println("Максимальное количество шагов было: " + maxStep);
        maxStep = 0;
    }

    private void meanStep(int i) {
        for (int j = 0; j < YEAR[i].length; j++) {
            meanStep = allStep / DAYS;
        }
        System.out.println("Среднее количество шагов: " + meanStep);
        meanStep = 0;
    }

    private void allStep(int i) {
        for (int j = 0; j < YEAR[i].length; j++) {
            allStep = allStep + YEAR[i][j];
        }
        System.out.println("Общее количество шагов: " + allStep);
    }

    private int target() {
        Scanner scanner = new Scanner(System.in);
        purpose = scanner.nextInt();
        while (purpose < 0) {
            System.out.println("Пожалуйста, вводите положительное значение: ");
            purpose = scanner.nextInt();
        }
        return purpose;
    }

    private int testMonth(int month) {
        while (month < 1 | month > 12) {
            System.out.println("Прошу, проверьте вводимое значение и повторите ввод:");
            month = scanner.nextInt();
        }
        return month;
    }

    private int testDay(int day) {
        while (day < 1 | day > 30) {
            System.out.println("Прошу, проверьте вводимое значение и повторите ввод:");
            day = scanner.nextInt();
        }
        return day;
    }

    private int testStep(int step) {
        while (step < 0) {
            System.out.println("Пожалуйста, введите положительное значение.");
            step = scanner.nextInt();
        }
        return step;
    }
}