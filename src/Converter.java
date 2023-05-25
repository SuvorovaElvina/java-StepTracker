public class Converter {
    private static final int CM_IN_STEP = 75;
    private static final int CM_IN_KM = 100000;
    private static final int CALORIES_IN_STEP = 50;
    private static final int CALORIES_IN_KILOCALORIES = 1000;

    public static int km(int allStep){
        return allStep * CM_IN_STEP / CM_IN_KM;
    }

    public static int kilocalories(int allStep){
        return allStep * CALORIES_IN_STEP / CALORIES_IN_KILOCALORIES;
    }
}