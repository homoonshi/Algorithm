
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] res = new int[N];

        Map<Integer,Integer> map = new HashMap<>();
        int maxNum = 0;

        for(int i=0; i<N; i++){
            int num = Integer.parseInt(input[i]);

            for(int j=1; j*j <= num; j++){
                if(j*j==num){
                    if(map.containsKey(j)){
                        res[i]--;
                        res[map.get(j)]++;
                    }
                }else if(num%j==0){
                    if(map.containsKey(j)){
                        res[i]--;
                        res[map.get(j)]++;
                    }
                    if(map.containsKey(num/j)){
                        res[i]--;
                        res[map.get(num/j)]++;
                    }
                }
            }

            for(int j=1; j*num <= maxNum; j++){
                if(map.containsKey(j*num)){
                    res[i]++;
                    res[map.get(j*num)]--;
                }
            }

            map.put(num,i);
            maxNum = Math.max(maxNum, num);
        }



        for(int i=0; i<N; i++){
            bw.write(res[i]+" ");
        }

        bw.flush();

    }

}
