public class Converter {

    public static int km(int allStep){
        int cmInStep = 75;
        int cmImKm = 100000;
        int km = allStep * cmInStep / cmImKm ;
        return km;
    }

    public static int kilocalories(int allStep){
        int caloriesInStep = 50;
        int caloriesInKilocalories = 1000;
        int kilocalories = allStep * caloriesInStep / caloriesInKilocalories;
        return kilocalories;
    }
}