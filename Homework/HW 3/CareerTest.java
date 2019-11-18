import java.util.Scanner;

class CareerTest{
    
    public void careerTesting(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Would you like a career test?");
        String ans = scan.nextLine();
        if(ans.equals("yes")){
            int counter = 0;
            System.out.println("Is money important to you?");
            ans = scan.nextLine().toLowerCase();
            if(ans.equals("yes")){
                counter += 3;
            }
            System.out.println("Are you an introvert or an extrovert?");
            ans = scan.nextLine().toLowerCase();
            if (ans.equals("introvert")){
                counter += 4;
            }
            System.out.println("Would you like to work with animals or people?");
            ans = scan.nextLine().toLowerCase();
            if (ans.equals("animals")){
                counter += 8;
            }
            System.out.println("Are you scared of blood?");
            ans = scan.nextLine().toLowerCase();
            if (ans.equals("yes")){
                counter += 10;
            }
            switch(counter){
                case 25:
                    System.out.println("Ecologist");
                    break;
                case 15: case 21:
                    System.out.println("Veterinarian");
                    break;
                case 17:
                    System.out.println("Software Engineer");
                    break;
                case 7:
                    System.out.println("Investment Banker");
                    break;
                case 11:
                    System.out.println("Farmer");
                    break;
                case 13:
                    System.out.println("Actor");
                    break;
                case 3:
                    System.out.println("Doctor");
                    break;
                case 22: case 18:
                    System.out.println("Zookeeper");
                    break;
                case 12:
                    System.out.println("Cook");
                    break;
                case 14:
                    System.out.println("College Professor");
                    break;
                case 4:
                    System.out.println("Artist");
                    break;
                case 8:
                    System.out.println("Animal Control Worker");
                    break;
                default:
                    System.out.println("Teacher");
            }

        }else{
            System.out.println("Ok, maybe next time.");
        }
        scan.close();
    }

    public static void main(String[] args) {
        CareerTest careerTest = new CareerTest();
        careerTest.careerTesting();
    }
}
