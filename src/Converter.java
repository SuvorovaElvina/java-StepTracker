public class Converter {
    private static int cmInStep = 75;
    private static  int cmImKm = 100000;
    private static int caloriesInStep = 50;
    private static int caloriesInKilocalories = 1000;

    public static int km(int allStep){
        int km = allStep * cmInStep / cmImKm ;
        return km;
    }

    public static int kilocalories(int allStep){
        int kilocalories = allStep * caloriesInStep / caloriesInKilocalories;
        return kilocalories;
    }
}