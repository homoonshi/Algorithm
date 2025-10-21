import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int g = Integer.parseInt(input[0]);
        int s = Integer.parseInt(input[1]);

        String W = br.readLine();
        String S = br.readLine();

        int[] wCount = new int[52];
        int[] sCount = new int[52];
        int res = 0;

        for (int i = 0; i < g; i++) {
            wCount[getIndex(W.charAt(i))]++;
        }

        for (int i = 0; i < s; i++) {
            sCount[getIndex(S.charAt(i))]++;
            if (i >= g) sCount[getIndex(S.charAt(i - g))]--;

            if (i >= g - 1 && Arrays.equals(wCount, sCount)) {
                res++;
            }
        }

        bw.write(res + "");
        bw.flush();
    }

    private static int getIndex(char c) {
        if (c >= 'a' && c <= 'z') return c - 'a';
        return c - 'A' + 26;
    }
}