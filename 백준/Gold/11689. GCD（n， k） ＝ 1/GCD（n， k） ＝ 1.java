import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(br.readLine());

        if(n==1){
            bw.write("1");
            bw.flush();
            return;
        }

        long res = n;

        if(!isPrime(n)) {
            res = searchDiv(n);
        }else{
            res = res - res/n;
        }

        bw.write(res+"");
        bw.flush();

    }

    public static long searchDiv(long num){
        long res = num;
        for (long i = 2; i*i <= num; i++){
            if (num%i==0 && isPrime(i)) {
                res = res - res/i;
                while(num % i == 0) {
                    num /= i;
                }
            }
        }
        if(num > 1 && isPrime(num)){
            res = res - res/num;
        }
        return res;
    }

    public static boolean isPrime(long n){
        if (n<2) return false;
        if (n==2 || n==3) return true;
        if (n%2==0 || n%3==0) return false;
        for(long i = 5; i * i <= n; i += 2){
            if (n%i == 0) return false;
        }
        return true;
    }

}