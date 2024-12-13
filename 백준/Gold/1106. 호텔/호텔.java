
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int C = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);

        int[] money = new int[C+1];
        int[][] city = new int[N][2];

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");

            city[i][0] = Integer.parseInt(input[0]);
            city[i][1] = Integer.parseInt(input[1]);

            if(city[i][1]>=C){
                if(money[C]==0){
                    money[C] = city[i][0];
                }else{
                    money[C] = Math.min(money[C],city[i][0]);
                }
                continue;
            }

            if(money[city[i][1]]==0){
                money[city[i][1]]=city[i][0];
            }else{
                money[city[i][1]]=Math.min(money[city[i][1]], city[i][0]);
            }
        }

        for(int i=0; i<C; i++){

            if(money[i]==0){
                continue;
            }

            for(int j=0; j<N; j++){

                int cost = city[j][0];
                int person = city[j][1];

                if(i+person >= C){
                    if(money[C] == 0){
                        money[C] = money[i]+cost;
                    }
                    if(money[C] > money[i]+cost){
                        money[C] = money[i]+cost;
                    }
                    continue;
                }

                if(money[i+person]==0){
                    money[i+person] = money[i]+cost;
                }else{
                    money[i+person] = Math.min(money[i+person], money[i]+cost);
                }

            }

        }

        bw.write(money[C]+"");
        bw.flush();

    }

}
