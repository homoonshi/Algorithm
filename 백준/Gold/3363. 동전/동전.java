import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] nums = new int[13]; // 0 기본, 1 낮음(후보자), 2 높음(후보자), 3 후보 X, 4 모순

        for(int i=0; i<3; i++) {
            String line = br.readLine();
            if (line == null) return;
            if (line.trim().isEmpty()) continue;
            String[] input = line.trim().replaceAll("\\s+", " ").split(" ");
            boolean[] check = new boolean[13];
            for (int j = 0; j < 9; j++) {
                if (j!=4) {
                    int n = Integer.parseInt(input[j]);
                    check[n] = true;
                    int flag;
                    if(input[4].equals(">")){
                        flag = j < 4 ? 1 : -1;
                    }else if(input[4].equals("<")){
                        flag = j < 4 ? -1 : 1;
                    }else{
                        flag = 0;
                    }
                    nums = find(flag, nums, n);
                }
            }
            if(input[4].equals(">") || input[4].equals("<")) {
                for (int j = 1; j <= 12; j++) {
                    if (!check[j] && nums[j]!=4) {
                        nums[j] = 3;
                    }
                }
            }
        }

        int count = 0;
        int infe = 0;
        int res = 0;
        int flag = 0;

        for(int i=1; i<=12; i++){
            if(nums[i]==4) infe++;
            if(nums[i]==1 || nums[i]==2){
                res = i;
                flag = nums[i];
                count++;
            }
        }

        if(count==0 && infe > 0){
            bw.write("impossible");
        }else if(count > 1){
            bw.write("indefinite");
        }else{
            bw.write(res+(flag==1 ? "-" : "+"));
        }

        bw.flush();

    }

    private static int[] find(int flag, int[] nums, int n) {
        if(nums[n]==3 || nums[n]==4) return nums;
        switch (flag){
            case 0:
                nums[n] = 3;
                break;
            case 1:
                if(nums[n]==1){
                    nums[n] = 4;
                    break;
                }
                nums[n] = 2;
                break;
            case -1:
                if(nums[n]==2){
                    nums[n] = 4;
                    break;
                }
                nums[n] = 1;
                break;
        }
        return nums;
    }
}