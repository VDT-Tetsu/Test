import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        int n = inputInt();
        String [] stringArray = new String[n];
        for (int i = 0; i < n; i++){
            stringArray[i] = inputString();
        }
        for (int i = 0; i < n; i++){
            System.out.println(check(stringArray[i]));
        }
    }

    public static int inputInt() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String raw = scanner.nextLine();
            try {
                int num = Integer.parseInt(raw);
                if (0 < num && num <= 100) {
                    return num;
                }else{
                    System.out.print("Number of string must in 0 < number <= 100, enter again: ");
                }
            } catch (Exception e) {
                System.out.print("You must enter number, enter again: ");
            }
        }
    }

    public static String inputString() {
        Pattern pattern = Pattern.compile("^[\\[\\]\\(\\)\\{\\}]+$");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String string = scanner.nextLine();
            if (!string.isEmpty()) {
                if(pattern.matcher(string).find()){
                    if(string.length() < 100000){
                        return string;
                    }
                    else{
                        System.out.print("Only must in 100000 characters, enter again: ");
                    }
                }else {
                    System.out.print("Only contain { [ ( ) ] }, enter again: ");
                }
            } else {
                System.out.print("Can not empty, enter again: ");
            }
        }
    }

    public static boolean check(String string){
        Stack<Character> stack = new Stack<>();

        for (char ch : string.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.push(ch);
            } else if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();
                if ((ch == ')' && top != '(') || (ch == ']' && top != '[') || (ch == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
