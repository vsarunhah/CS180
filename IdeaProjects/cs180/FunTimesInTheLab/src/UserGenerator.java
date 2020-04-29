public class UserGenerator {
    public static void main(String[] args){
        String name = "John Doe";
        char firstChar = name.charAt(0);
        int startIndex = name.indexOf(" ") + 1;
        int stopIndex = name.length();
        String username = firstChar + name.substring(startIndex, stopIndex);
        username = username.toLowerCase();
        String email = username + "@purdue.edu";
        System.out.println(username);
        System.out.println(email);
    }
}
