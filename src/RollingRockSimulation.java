/*
RollingRockSimulation.java
By Pratyush Chand and Seth Kreysar
Period 5
11/11/19
*/

import java.util.Random;
public class RollingRockSimulation{
    public static void main(String [] agrs){
        Random gen = new Random();
        rockAndRoll(gen);

    }

    public static void rockAndRoll(Random gen){
        int totalrolls = 0;
        double TotalAttempts = 0.0;
        double NumOfTimesToCheck = 10000.0;

        while(totalrolls < NumOfTimesToCheck){

            TotalAttempts = TotalAttempts + AttemptsForTwoInARow(gen);

            totalrolls++;
            //System.out.println(totalrolls);
            //System.out.println(TotalAttempts);
        }

        double AvgToRollTwo = TotalAttempts/NumOfTimesToCheck;
        System.out.println("The Average to have 2 consecutive rocks without a reset is: " + AvgToRollTwo);

    }

    public static int AttemptsForTwoInARow(Random gen) {
        int twoinarowrolls = 0;
        int totalDistance = 0;
        int attempts = 0;

        while (twoinarowrolls < 2){
            int numofattempts = hundredfeetPush(gen);
            if (numofattempts == 0) {
                twoinarowrolls = 0;
                attempts = 0;
            }
            else {
                twoinarowrolls++;
                attempts = attempts + numofattempts;
            }
        }
        return attempts;
    }

    public static int hundredfeetPush(Random gen){
        int totalDistance = 0;
        int attempts = 0;

        while(totalDistance != 100){
            int check1 = gen.nextInt(10);
            if(check1 != 0){
                totalDistance += check1;
                attempts++;
            }else{
                totalDistance = 0;
                return 0;
            }

        }
        return attempts;
    }

}