import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        String[] inputValues = input().split("\\s");
        int m = Integer.parseInt(inputValues[0]);
        int d = Integer.parseInt(inputValues[1]);
        int k = Integer.parseInt(inputValues[2]);
        int c = Integer.parseInt(inputValues[3]);

        int result = minimumGoldToPassLevel(m, d, k, c);
        System.out.println(result);
    }

    public static String input() {
        Pattern pattern = Pattern.compile("^[0-9]{1,4}\\s[0-9]{1,4}\\s[0-9]{1,4}\\s[0-9]{1,4}$");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String raw = scanner.nextLine();
            if (!raw.isEmpty()) {
                if (pattern.matcher(raw).find()) {
                    String[] scores = raw.split("\\s");
                    try {
                        int m = Integer.parseInt(scores[0]);
                        int d = Integer.parseInt(scores[1]);
                        int k = Integer.parseInt(scores[2]);
                        int c = Integer.parseInt(scores[3]);
                        if (0 < d && d <= 1000
                                && 0 <= m && m <= 1000
                                && 0 <= k && k <= 1000
                                && 0 <= c && c <= 1000
                        ) {
                            return raw;
                        } else {
                            System.out.print("d must in 0 < d <= 1000 and m,k,c must in 0 <= m,k,c <= 1000, enter again: ");
                        }
                    } catch (Exception e) {
                        System.out.print("m, d, k, c must is number, enter again: ");
                    }
                } else {

                    System.out.print("You must enter in format \"m d k c\", enter again: ");
                }
            } else {
                System.out.print("Can not empty, enter again: ");
            }
        }
    }

    public static int minimumGoldToPassLevel(int m, int d, int k, int c) {
        int d1 = d;
        int count = 0;

        if(d <= k){
            return -1;
        }

        for (int i = 0; i < m; i++){
            if((d1 - k > 0)){
                d1 = d1 - k;
            }

            if((i == m - 2) && (d1 == k)){
                break;
            }

            if((i != m - 1) && (d1 - k <= 0)){
                count++;
                d1 = d;
            }
        }

        int totalCost = count * c;

        return totalCost <= 32767 ? totalCost : -1; // Single integer -32767 to +32767
    }
}
