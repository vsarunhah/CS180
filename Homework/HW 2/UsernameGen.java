import java.util.Scanner;
public class UsernameGen    {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        System.out.println("What is your full name?");
        String[] name = s.nextLine().split(" ");
        System.out.println("What is your birth year?");
        int year = s.nextInt();
        int age = 2019-year;
        String fname = name[0];
        String username = fname.charAt(0) + name[1] + age;
        username = username.toLowerCase();
        System.out.println("Your username is " + username);
    }
}
