import java.util.*;

public class Solution {

    /*
     * Complete the getMoneySpent function below.
     */
    public static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int max = -1;

        for (int keyboardPrice : keyboards) {
            for (int drivePrice : drives) {
                int total = keyboardPrice + drivePrice;

                if (total <= b && total > max) {
                    max = total;
                }
            }
        }

        return max;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] bnm = scanner.nextLine().split(" ");
        int b = Integer.parseInt(bnm[0]);
        int n = Integer.parseInt(bnm[1]);
        int m = Integer.parseInt(bnm[2]);

        int[] keyboards = new int[n];
        String[] keyboardsItems = scanner.nextLine().split(" ");
        for (int i = 0; i < n; i++) {
            keyboards[i] = Integer.parseInt(keyboardsItems[i]);
        }

        int[] drives = new int[m];
        String[] drivesItems = scanner.nextLine().split(" ");
        for (int i = 0; i < m; i++) {
            drives[i] = Integer.parseInt(drivesItems[i]);
        }

        int moneySpent = getMoneySpent(keyboards, drives, b);

        System.out.println(moneySpent);

        scanner.close();
    }
}
