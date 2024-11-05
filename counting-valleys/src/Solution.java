import java.io.*;

class Result {
    /*
     * Complete the 'countingValleys' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER steps
     *  2. STRING path
     */

    public static int countingValleys(int steps, String path) {
        int seaLevel = 0;
        int valleys = 0;

        if (isStepCountValid(steps, path)) {
            for(char step : path.toCharArray()) {
                if(step == 'U') {
                    seaLevel++;
                } else if(step == 'D') {
                    seaLevel--;
                } else {
                    throw new IllegalArgumentException(String.format("Erro: " +
                            "Nao foi possivel identificar a direcao \"%s\".", step));
                }

                if(step == 'U' && seaLevel == 0) {
                    valleys++;
                }
            }
        }

        return valleys;
    }

    public static boolean isStepCountValid(int steps, String path) {
        if (steps != path.length()) {
            throw new IllegalArgumentException("Erro: O numero de passos nao " +
                    "corresponde a sequencia de passos inserida no caminho.");
        }
        return true;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int steps = Integer.parseInt(bufferedReader.readLine().trim());

        String path = bufferedReader.readLine();

        int result = Result.countingValleys(steps, path);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
