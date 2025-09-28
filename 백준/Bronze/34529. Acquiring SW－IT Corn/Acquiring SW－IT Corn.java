import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");
        int[] cost = new int[3];
        int[] buy = new int[3];
        int[] weight = {100, 50, 20};
        int res = 0;
        for(int i=0; i<3; i++) {
            cost[i] = Integer.parseInt(input[i]);
            buy[i] = Integer.parseInt(input2[i]);
            int count = buy[i] % weight[i] == 0 ? buy[i]/weight[i] : buy[i]/weight[i] + 1;
            res += count * cost[i];
        }
        bw.write(res+"");
        bw.flush();
    }
}