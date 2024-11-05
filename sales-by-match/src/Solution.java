import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {
    /*
     * Complete the 'sockMerchant' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY ar
     */

    public static int sockMerchant(int n, List<Integer> ar) {
        Map<Integer, Integer> countSocksByColorMap = countSocksByColor(ar);

        return calculatePairs(countSocksByColorMap);
    }

    private static Map<Integer, Integer> countSocksByColor(List<Integer> colorArray) {
        Map<Integer, Integer> countSocksMap = new HashMap<>();

        for(int color : colorArray) {
            if(countSocksMap.containsKey(color)){
                countSocksMap.put(color, countSocksMap.get(color) + 1);
            } else {
                countSocksMap.put(color, 1);
            }
        }

        return countSocksMap;
    }

    private static int calculatePairs(Map<Integer, Integer> countSocksMap) {
        int pairs = 0;

        for(int count : countSocksMap.values()) {
            pairs += count / 2;
        }

        return pairs;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ar = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
