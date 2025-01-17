
import java.io.*;
import java.util.*;

public class Main {

    static List<int[]> inputs;
    static int[] result;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = -1;
        int size = 0;
        int maxNum = 0;

        inputs = new ArrayList<>();

        while(input!=0){
            input = Integer.parseInt(br.readLine());

            if(input==0){
                break;
            }

            int[] temp = new int[2];
            temp[0] = input;
            temp[1] = size++;

            maxNum = Math.max(maxNum, input);

            inputs.add(temp);
        }

        result = new int[size];
        boolean[] visited = new boolean[maxNum*2+1];

        for(int i=2; i<=maxNum*2; i++){

            if(visited[i]){
                continue;
            }

            visited[i] = true;

            for (int j = i * 2; j <= maxNum * 2; j += i) {
                if(j<0 || j > maxNum*2){
                    break;
                }
                visited[j] = true;
            }

            for (int j=0; j<inputs.size();) {
                if(inputs.get(j)[0]<i && i<=inputs.get(j)[0]*2){
                    result[inputs.get(j)[1]]++;
                }
                if(inputs.get(j)[0]*2<i) {
                    inputs.remove(j);
                    continue;
                }
                j++;
            }

        }

        for (int i : result) {
            bw.write(i+"\n");
        }

        bw.flush();

    }


}
