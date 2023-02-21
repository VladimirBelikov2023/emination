//логика по сохранению и изменению количества шагов. Также в нём будет выводиться статистика.
import java.util.Scanner;
public class StepTracker {

    Converter converter = new Converter();
    Scanner scanner;
    int goalByStepsPerDay= 10000;
    MonthData[] monthToData;
    StepTracker(Scanner scan) {
        scanner = scan;
        monthToData = new MonthData[12];
        for ( int i = 0; i < 12; i++){
            monthToData[i] = new MonthData();
        }
    }
    public void addNewNumberStepsPerDay(){
            System.out.println("Введите месяц");
            int month = scanner.nextInt();
            if (month < 0 || month >11 ){
                System.out.println("Ошибка. Неверный месяц.");
                return;
            }
            System.out.println("Введите день");
            int day= scanner.nextInt();
            if (day < 1 || day >30){
                System.out.println("Ошибка. Введите день от 1 до 30.");
                return;
            }
            System.out.println("Введите количество шагов");
            int numberSteps= scanner.nextInt();
            if (numberSteps <=0){
                System.out.println("Ошибка. Неверное количество шагов");
                return;
            }
            monthToData[month].days[day-1]= numberSteps;
    }

    void changeStepGoal(){
        System.out.println("Задайте цель количecтва  шагов за 1 день.");
        int selectedGoal = scanner.nextInt();
        if (selectedGoal <= 0){
            System.out.println("Неверно");
            return;
        }
        goalByStepsPerDay= selectedGoal;
        System.out.println("Ваша цель: " + goalByStepsPerDay + " шагов в день");
    }

    void printStatistic(){
        System.out.println("За какой месяц вы хотите узнать статистику?");
        int month= scanner.nextInt();
        if (month < 0 || month >11 ){
            System.out.println("Ошибка!");
        }
        int sumSteps= monthToData[month].sumStepsFromMonth();
        System.out.println("Количество шагов");
        monthToData[month].printDaysAndStepsFromMonth( );
        System.out.println("Общее количество шагов за месяц: " + sumSteps);
        System.out.println("Самое большое количество шагов: " + monthToData[month].maxSteps());
        System.out.println("Среднее количество шагов: " + sumSteps/30);
        System.out.println("Пройденная дистанция за месяц: " + converter.convertToKm(sumSteps)+ " километра");
        System.out.println("Сожжено килокалорий: " + converter.convertStepsToKilocalories(sumSteps));
        System.out.println("Лучшая серия: " + monthToData[month].bestSeries(goalByStepsPerDay));
    }

}



