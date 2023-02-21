
public class MonthData {
    int[] days = new int[30];

    void printDaysAndStepsFromMonth(){
        for (int i = 0; i < 30; i++){
            System.out.println((i+1) + " день: " + days[i] );
        }
    }

    int sumStepsFromMonth(){
        int sumSteps = 0;
        for (int i = 0; i<30; i++){
            sumSteps= sumSteps+ days[i];
        }
        return sumSteps;
    }

    int maxSteps(){
        int maxOfSteps= 0;
        for (int i = 0; i < 30; i++ ){
            if (days[i]>maxOfSteps){
                maxOfSteps= days[i];
            }

        }
        return maxOfSteps;
    }
    int bestSeries(int goalByStepsPerDay){
        int bestSession = 0;
        int countBest = 0;
        for (int i=0; i < 30; i++){

            if (days[i] >= goalByStepsPerDay) {
                bestSession++;

                if (bestSession > countBest) {
                    countBest = bestSession;
                }
            }
            else {
                bestSession=0;
            }



        }

        return countBest;
    }

}


