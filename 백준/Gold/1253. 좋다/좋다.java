
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        Map<Integer, Integer> map = new HashMap<>();
        int[] nums = new int[N];

        String[] input = br.readLine().split(" ");

        int maxNum = 0;

        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(input[i]);
            if(map.containsKey(nums[i])){
                map.put(nums[i], map.get(nums[i])+1);
            }else{
                map.put(nums[i], 1);
            }
            maxNum = Math.max(maxNum, nums[i]);
        }

        Arrays.sort(nums);

        int result = 0;

        for(int i=0; i<N; i++){
            for(int j=i+1; j<N; j++){
                int sum = nums[i] + nums[j];
                if(maxNum<sum){
                    break;
                }
                if(map.containsKey(sum)){
                    int count = map.get(sum);
                    if(count>2){
                        result += count;
                        map.remove(sum);
                    }else if(count==2){
                        if(sum==nums[i] && nums[i]==nums[j]){
                            continue;
                        }
                        result += count;
                        map.remove(sum);
                    }else if(count==1){
                        if(sum!=nums[i] && sum!=nums[j]){
                            result += count;
                            map.remove(sum);
                        }
                    }
                }
            }
        }

        bw.write(result+"");
        bw.flush();

    }

}
