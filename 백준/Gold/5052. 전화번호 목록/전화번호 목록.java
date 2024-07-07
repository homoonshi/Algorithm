
import java.io.*;
import java.util.*;

public class Main {

    static int n;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        for(int test_case = 0; test_case < t ; test_case++){

            Set<String> phone = new HashSet<>();
            Deque<String> list = new ArrayDeque<>();

            int n = Integer.parseInt(br.readLine());

            for(int i=0; i<n; i++){
                String p = br.readLine();
                phone.add(p);
                list.addLast(p);
            }

            boolean find = false;

            while(!list.isEmpty()){

                StringBuffer sb = new StringBuffer();
                String p = list.pollFirst();
                int length = p.length();

                for(int i=0; i<length-1; i++){

                    sb.append(p.charAt(i));

                    if(phone.contains(sb.toString())){
                        find = true;
                        break;
                    }

                }

                if(find){
                    break;
                }

            }

            if(find){
                bw.write("NO"+"\n");
            }else{
                bw.write("YES"+"\n");
            }

        }

        bw.flush();

    }
}