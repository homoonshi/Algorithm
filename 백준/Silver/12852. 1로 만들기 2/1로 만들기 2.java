import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int X = Integer.parseInt(br.readLine());
        int[][] dp = new int[X+1][2];

        for(int i=1; i<=X; i++){
            dp[i][0] = Integer.MAX_VALUE;
        }

        if(X==1){
            bw.write("0\n");
            bw.write("1");
            bw.flush();
            return;
        }

        Deque<Integer> deque = new ArrayDeque<>();
        Set<Integer> visit = new HashSet<>();

        deque.addLast(X);
        visit.add(X);

        dp[X][0] = 0;

        while(!deque.isEmpty()){

            int num = deque.pollFirst();
            int count = dp[num][0];

            if(num%3==0) {
                if(dp[num/3][0] >= count+1) {
                    dp[num / 3][0] = count + 1;
                    dp[num / 3][1] = num;
                }
                if (num / 3 == 1) {
                    break;
                }
                if (!visit.contains(num / 3)) {
                    deque.addLast(num/3);
                    visit.add(num/3);
                }
            }

            if(num%2==0){
                if(dp[num/2][0] >= count+1) {
                    dp[num / 2][0] = count + 1;
                    dp[num / 2][1] = num;
                }
                if (num / 2 == 1) {
                    break;
                }
                if (!visit.contains(num / 2)) {
                    deque.addLast(num/2);
                    visit.add(num/2);
                }
            }

            if(num-1 > 0){
                if(dp[num-1][0] >= count + 1) {
                    dp[num - 1][0] = count + 1;
                    dp[num - 1][1] = num;
                }
                if(num-1 == 1){
                    break;
                }
                if(!visit.contains(num-1)){
                    deque.addLast(num-1);
                    visit.add(num-1);
                }
            }

        }

        bw.write(dp[1][0]+"\n");

        List<Integer> list = new ArrayList<>();
        list.add(1);

        while(list.get(0)!=X){
            list.add(0, dp[list.get(0)][1]);
        }

        for (Integer index : list) {
            bw.write(index+" ");
        }

        bw.flush();

    }
}