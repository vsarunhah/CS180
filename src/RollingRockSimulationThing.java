import java.util.Random;

public class RollingRockSimulationThing {
    public static void main(String[] args) {
        int height = 0;
        //int success = 0;
        int numSuccession = 0;
        int numTrials = 0;
        int tries = 0;
        for(int i = 0; i < 10000; i++) {
            int rolls = roll();
            numTrials++;
            System.out.println(rolls);
            if (rolls == 0) {
                height = 0;
                numTrials = 0;
                numSuccession = 0;
            } else {
                height += rolls;
            }
            if(height >= 100){
                height = 0;
                numSuccession++;
                if(numSuccession > 2){
                    //success++;
                    numSuccession = 0;
                    tries += numTrials;
                    numTrials = 0;
                }
            }
        }
        double num = tries/10000.00;
        System.out.println("-----------------------------------");
        System.out.println(num);
    }
    public static int roll(){
        Random rand = new Random();
        int increase = rand.nextInt(10);
        return increase;
    }
}
