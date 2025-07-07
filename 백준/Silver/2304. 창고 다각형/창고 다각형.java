import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] num = new int[N][2];

        int maxX = 0;
        int maxY = 0;

        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            maxY = Math.max(maxY, y);
            num[i][0] = x;
            num[i][1] = y;
        }

        Arrays.sort(num, ((o1, o2) -> o1[0]-o2[0]));

        int mx = num[0][0];
        int my = num[0][1];

        int res = 0;

        for(int i=1; i<N; i++){
            if(my==maxY){
                maxX = i-1;
                break;
            }
            if(my<=num[i][1]){
                res += (num[i][0]-mx) * my;
                my = num[i][1];
                mx = num[i][0];
            }
        }

        mx = num[N-1][0];
        my = num[N-1][1];

        for(int i=N-2; i>=maxX; i--){
            if(my<=num[i][1]){
                res += (mx-num[i][0]) * my;
                my = num[i][1];
                mx = num[i][0];
            }
        }

        res += maxY;

        bw.write(res+"");
        bw.flush();

    }
}