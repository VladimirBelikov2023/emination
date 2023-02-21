public class Converter {
    int convertToKm(int steps){
        return steps*75/100000;
    }
    int convertStepsToKilocalories(int steps){
        int CALORIES_PER_STEP = 50;
        int CALORIES_TO_K_CALORIES = 1000;
        return steps * CALORIES_PER_STEP / CALORIES_TO_K_CALORIES;
    }



}
