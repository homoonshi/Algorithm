
import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        List<BigInteger> nums = new ArrayList<>();

        for(int i=0; i<N; i++){
            String str = br.readLine();
            boolean beforeStr = true;
            StringBuilder sb = new StringBuilder("");
            boolean leadingZero = true;
            for(int j=0; j<str.length(); j++){
                char c = str.charAt(j);
                boolean res = Character.isDigit(c);
                if(!res){
                    if(!beforeStr) {
                        BigInteger num;
                        if(sb.length() == 0){
                            num = BigInteger.ZERO;
                        }else {
                            num = new BigInteger(sb.toString());
                        }
                        nums.add(num);
                        sb.setLength(0);
                        beforeStr = true;
                        leadingZero = true;
                        continue;
                    }
                    continue;
                }
                beforeStr = false;
                if(leadingZero && c == '0') {
                    continue;
                }
                sb.append(c);
                leadingZero = false;
            }
            if(!beforeStr){
                BigInteger num;
                if(sb.length() == 0){
                    num = BigInteger.ZERO;
                }else {
                    num = new BigInteger(sb.toString());
                }
                nums.add(num);
            }
        }

        Collections.sort(nums);

        for (BigInteger num : nums) {
            bw.write(num.toString()+"\n");
        }

        bw.flush();

    }

}
