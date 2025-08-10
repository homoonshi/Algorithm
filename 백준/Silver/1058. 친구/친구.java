import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] friend = new int[n];
        boolean[][] friendship = new boolean[n][n];

        for(int i=0; i<n; i++) {
            String input = br.readLine();
            for(int j=0; j<n; j++){
                if(input.charAt(j)=='Y')
                friendship[i][j] = true;
            }
        }

        int res = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j) continue;
                if(friendship[i][j]){
                    friend[i]++;
                    continue;
                }
                for(int k=0; k<n; k++){
                    if(i==k || j==k) continue;
                    if(friendship[i][k] && friendship[j][k]){
                        friend[i]++;
                        break;
                    }
                }
            }
            res = Math.max(res, friend[i]);
        }

        bw.write(res+"");
        bw.flush();
    }
}