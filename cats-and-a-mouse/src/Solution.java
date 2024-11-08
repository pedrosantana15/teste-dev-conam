import java.io.*;
import java.util.*;

public class Solution {

    // Complete the catAndMouse function below.
    public static String catAndMouse(int x, int y, int z) {
        int distanceCatA = Math.abs(x - z);
        int distanceCatB = Math.abs(y - z);

        if(distanceCatA < distanceCatB) {
            return "Cat A";
        } else if(distanceCatB < distanceCatA) {
            return "Cat B";
        } else {
            return "Mouse C";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] xyz = scanner.nextLine().split(" ");

            int x = Integer.parseInt(xyz[0]);

            int y = Integer.parseInt(xyz[1]);

            int z = Integer.parseInt(xyz[2]);

            String result = catAndMouse(x, y, z);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
