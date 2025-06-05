
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static Double[] buildings;
    static int[][] looks;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        buildings = new Double[N+1];
        looks = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            buildings[i] = Double.parseDouble(input[i-1]);
        }

        int res = 0;

        for(int i=1; i<=N; i++){
            int r = 0;
            loof : for(int j=1; j<=N; j++){
                if (i==j || looks[i][j]==2 || looks[j][i]==2) continue;
                if (j==(i-1) || j==(i+1) || looks[i][j]==1 || looks[j][i]==1) {
                    looks[i][j] = 1;
                    looks[j][i] = 1;
                    r++;
                    continue;
                }
                double deno = buildings[i]-buildings[j];
                double nume = i-j;
                double frac = deno / nume;
                double c = buildings[i] - frac * i;
                if(i>j){
                    for(int k=j+1; k<i; k++){
                        double y = frac * k + c;
                        if(y<=buildings[k]){
                            looks[i][j] = 2;
                            looks[j][i] = 2;
                            continue loof;
                        }
                    }
                }else{
                    for(int k=i+1; k<j; k++){
                        double y = frac * k + c;
                        if(y<=buildings[k]){
                            looks[i][j] = 2;
                            looks[j][i] = 2;
                            continue loof;
                        }
                    }
                }
                looks[i][j] = 1;
                looks[j][i] = 1;
                r++;
            }
            res = Math.max(res, r);
        }

        bw.write(res+"");
        bw.flush();

    }
}