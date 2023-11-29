import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        int n = inputInt();
        String [] stringArray = new String[n];
        for (int i = 0; i < n; i++){
            stringArray[i] = inputScore();
        }
        for (int i = 0; i < n; i++){
            System.out.println(countScoreWays(stringArray[i]));
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
                } else {
                    System.out.print("Number of string must in 0 < number <= 100, enter again: ");
                }
            } catch (Exception e) {
                System.out.print("You must enter number, enter again: ");
            }
        }
    }

    public static String inputScore() {
        Pattern pattern = Pattern.compile("^[0-9]{1,2}\\s[0-9]{1,2}$");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String raw = scanner.nextLine();
            if (!raw.isEmpty()) {
                if (pattern.matcher(raw).find()) {
                    String[] scores = raw.split("\\s");
                    try {
                        int x = Integer.parseInt(scores[0]);
                        int y = Integer.parseInt(scores[1]);
                        if (0 <= x && x <= 10 && 0 <= y && y <= 10) {
                            return raw;
                        } else {
                            System.out.print("x, y must in 0 <= x, y <= 10, enter again: ");
                        }
                    } catch (Exception e) {
                        System.out.print("x, y must is number, enter again: ");
                    }
                } else {
                    System.out.print("You must enter in format \"x y\", enter again: ");
                }
            } else {
                System.out.print("Can not empty, enter again: ");
            }
        }
    }

    public static int countScoreWays(String string) {
        String[] scores = string.split("\\s");
        int x = Integer.parseInt(scores[0]);
        int y = Integer.parseInt(scores[1]);
        int[][] dp = new int[x + 1][y + 1];

        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else {
                    if (i > 0) dp[i][j] += dp[i - 1][j];
                    if (j > 0) dp[i][j] += dp[i][j - 1];
                }
            }
        }

        return dp[x][y];
    }
}
