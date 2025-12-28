import java.io.*;
import java.util.*;

public class Main {

    static int[] friend;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case<=T; test_case++){

            int n = Integer.parseInt(br.readLine());
            int k = Integer.parseInt(br.readLine());

            friend = new int[n];

            for(int i=0; i<n; i++){
                friend[i] = i;
            }

            String[] input;

            for(int i=0; i<k; i++){
                input = br.readLine().split(" ");

                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);

                isParty(a, b);
            }

            int m = Integer.parseInt(br.readLine());
            bw.write("Scenario "+test_case+":\n");

            for(int i=0; i<m; i++){
                input = br.readLine().split(" ");

                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);

                if(getPrime(a)==getPrime(b)){
                    bw.write("1\n");
                }else{
                    bw.write("0\n");
                }
            }

            bw.write("\n");

        }

        bw.flush();

    }

    public static int getPrime(int num){
        if(friend[num]==num){
            return num;
        }
        return friend[num] = getPrime(friend[num]);
    }

    public static void isParty(int a, int b){
        int primeA = getPrime(a);
        int primeB = getPrime(b);

        if(a==b) return;

        if(a < b){
            friend[primeB] = primeA;
        }else{
            friend[primeA] = primeB;
        }
    }

}