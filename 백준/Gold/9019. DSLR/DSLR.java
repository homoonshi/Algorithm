
import java.io.*;
import java.util.*;

public class Main {

    static int A, B;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        String[] input;

        for(int test_case=0; test_case<T; test_case++){

            input = br.readLine().split(" ");

            A = Integer.parseInt(input[0]);
            B = Integer.parseInt(input[1]);

            int d[] = new int[4];

            long res = BFS();

            StringBuilder str = new StringBuilder("");

            while(res>0){
                if(res%10==1){
                    str.insert(0,'D');
                }else if(res%10==2){
                    str.insert(0,'S');
                }else if(res%10==3){
                    str.insert(0,'L');
                }else{
                    str.insert(0,'R');
                }

                if(res>=10){
                    res/=10;
                }else{
                    res = 0;
                }
            }

            bw.write(str.toString());
            bw.write("\n");
        }

        bw.flush();

    }

    public static long BFS(){

        Deque<long[]> deque = new ArrayDeque<>();
        deque.addLast(new long[]{A,0});

        int[] visit = new int[10000];

        long[] temp;
        long num = 0;
        long res = 0;

        while(!deque.isEmpty()){

            temp = deque.pollFirst();

            for(int i=1; i<=4; i++){

                if(i==1){
                    num = D(temp[0]);
                }else if(i==2){
                    num = S(temp[0]);
                }else if(i==3){
                    num = L(temp[0]);
                }else if(i==4){
                    num = R(temp[0]);
                }

                if(visit[(int)num]==1){
                    continue;
                }else{
                    visit[(int)num]=1;
                }

                if(num==B){
                    res = temp[1]*10 + i;
                    return res;
                }

                deque.addLast(new long[]{num,temp[1]*10+i});

            }

        }

        return 0;
    }

    public static long D(long num){
        num *= 2;
        num %= 10000;
        return num;
    }

    public static long S(long num){
        if(num==0){
            num = 9999;
        }else{
            num -= 1;
        }
        return num;
    }

    public static long L(long num){
        if(num>=1000){
            long f = num/1000;
            num %= 1000;
            num *= 10;
            num += f;
        }else{
            num *= 10;
        }
        return num;
    }

    public static long R(long num){
        long b = num%10;
        num /= 10;
        num += (b*1000);
        return num;
    }

}
