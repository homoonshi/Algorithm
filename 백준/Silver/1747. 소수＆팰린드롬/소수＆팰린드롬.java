
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        while(true){
            if(isPrime(N) && isPalindromeNum(N)){
                bw.write(N+"");
                bw.flush();
                return;
            }
            N++;
        }

    }

    public static boolean isPrime(int num){

        if(num < 2){
            return false;
        }
        if(num == 2){
            return true;
        }
        if(num % 2 == 0){
            return false;
        }

        for (int i=3; i <= Math.sqrt(num); i+=2){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeNum(int num){

        if (num < 0) return false;

        int original = num;
        int reversed = 0;

        while(num > 0){

            int digit = num % 10;
            reversed = reversed * 10 + digit;
            num /= 10;

        }

        return original == reversed;
    }

}
