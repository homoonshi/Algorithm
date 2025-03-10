
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int test_case=0; test_case<T; test_case++){

            String str = br.readLine();

            int left = 0;
            int right = str.length()-1;

            boolean isPalindrome = true;
            boolean isFirstRemove = false;
            boolean isSecondRemove = false;

            int firstRemoveLeft = 0;
            int firstRemoveRight = 0;

            while(left<right){

                char l = str.charAt(left);
                char r = str.charAt(right);

                if(l==r){
                    left+=1;
                    right-=1;
                    continue;
                }

                if(isSecondRemove){
                    isPalindrome = false;
                    break;
                }

                // left + 1
                if(isFirstRemove){
                    left = firstRemoveLeft;
                    right = firstRemoveRight;
                    isSecondRemove = true;
                }else {
                    l = str.charAt(left + 1);

                    if (l == r) {
                        firstRemoveLeft = left;
                        firstRemoveRight = right;
                        left += 2;
                        right -= 1;
                        isFirstRemove = true;
                        continue;
                    }
                }

                // right + 1;
                l = str.charAt(left);
                r = str.charAt(right-1);

                if(l==r){
                    left+=1;
                    right-=2;
                    isSecondRemove = true;
                    continue;
                }

                isPalindrome = false;
                break;

            }

            if(!isPalindrome){
                bw.write("2\n");
                continue;
            }

            if(!isFirstRemove && !isSecondRemove){
                bw.write("0\n");
                continue;
            }

            bw.write("1\n");

        }

        bw.flush();

    }

}
