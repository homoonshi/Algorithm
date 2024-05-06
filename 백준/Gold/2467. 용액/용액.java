import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] sol = new int[N];

        for(int i=0; i<N; i++){
            sol[i] = Integer.parseInt(input[i]);
        }

        int[] res = new int[2];

        res = search(N,sol);

        for(int i=0; i<2; i++){
            bw.write(sol[res[i]]+" ");
        }

        bw.flush();
    }

    public static int[] search(int n, int[] s){

        int front = 0;
        int back = n-1;

        int distance = Math.abs(s[front]+s[back]);

        int[] res = new int[2];
        res[0] = front;
        res[1] = back;

        int current;

        while(front<back){

            current = s[front] + s[back];

            if(current<0){
                if(Math.abs(current)<distance){
                    distance = Math.abs(current);
                    res[0]=front;
                    res[1]=back;
                }
                front++;
            }else{
                if(Math.abs(current)<distance){
                    distance = Math.abs(current);
                    res[0]=front;
                    res[1]=back;
                }
                back--;
            }

        }

        return res;
    }

}
