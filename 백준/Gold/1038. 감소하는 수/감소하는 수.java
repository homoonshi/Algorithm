
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int sequence;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        long res = -1;

        for(int i=1; i<=10; i++){
            res = search(i, 9, 0);
            if(res!=-1){
                break;
            }
        }

        if(res==-1){
            res=-1;
        }

        bw.write(res+"");
        bw.flush();

    }

    public static long search(int count, int before, long res){

        if(count==0){
            if(sequence==N){
                return res;
            }
            sequence++;
            return -1;
        }

        for(int i=count-1; i<=before; i++){
            long ret = search(count-1, i-1, (long) (res+Math.pow(10, count-1)*i));
            if(ret!=-1){
                return ret;
            }
        }

        return -1;
    }

}

