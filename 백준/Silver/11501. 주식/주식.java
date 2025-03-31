
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 0; test_case < T; test_case++){

            int N = Integer.parseInt(br.readLine());

            String[] input = br.readLine().split(" ");
            int[] stock = new int[N];
            Integer[] max = new Integer[N];

            int[] nums = new int[10001];

            for(int i=0; i<N; i++){
                stock[i] = Integer.parseInt(input[i]);
                max[i] = Integer.parseInt(input[i]);
                nums[max[i]]++;
            }

            Arrays.sort(max, Collections.reverseOrder());
            int index = 0;

            int buy = 0;
            int count = 0;
            long res = 0;


            for(int i=0; i<N; i++){
                if(stock[i] < max[index]){
                    buy += stock[i];
                    count++;
                    nums[stock[i]]--;
                }else{
                    res += (long) stock[i]*count - buy;
                    buy = 0;
                    count = 0;
                    nums[max[index]]--;
                    for(int j=index; j<N; j++){
                        if(nums[max[j]]>0){
                            index = j;
                            break;
                        }
                    }
                }
            }

            bw.write(res+"\n");

        }

        bw.flush();

    }

}
