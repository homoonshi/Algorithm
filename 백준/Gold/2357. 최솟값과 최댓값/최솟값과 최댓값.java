
import java.util.*;
import java.io.*;

public class Main {

    static class Segment{

        int n;
        int[] segmentMin;
        int[] segmentMax;

        Segment(int[] temp){

            n = temp.length;
            segmentMin = new int[n*2];
            segmentMax = new int[n*2];

            build(temp);
        }

        public void build(int[] temp){

            for(int i=0; i<n; i++){
                segmentMax[n+i] = temp[i];
                segmentMin[n+i] = temp[i];
            }

            for(int i=n-1; i>0; i--){
                segmentMax[i] = Math.max(segmentMax[i*2],segmentMax[i*2+1]);
                segmentMin[i] = Math.min(segmentMin[i*2],segmentMin[i*2+1]);
            }

        }

        public int searchMin(int l,int r){

            int result = Integer.MAX_VALUE;

            l += n;
            r += n;

            while( l<r ){

                if (l%2 == 1){
                    result = Math.min(result, segmentMin[l++]);
                }
                if (r%2 == 1){
                    result = Math.min(result, segmentMin[--r]);
                }

                l /= 2;
                r /= 2;

            }

            return result;
        }

        public int searchMax(int l,int r){

            int result = Integer.MIN_VALUE;

            l += n;
            r += n;

            while( l<r ){

                if ( (l%2)==1 ){
                    result = Math.max(result, segmentMax[l++]);
                }

                if( (r%2)==1 ){
                    result = Math.max(result, segmentMax[--r]);
                }

                l /= 2;
                r /= 2;

            }

            return result;
        }

    }

    static int N, M;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        int[] temp = new int[N];

        for(int i=0; i<N; i++){
            temp[i] = Integer.parseInt(br.readLine());
        }

        Segment seg = new Segment(temp);

        for(int j=0; j<M; j++){

            input = br.readLine().split(" ");

            int l = Integer.parseInt(input[0])-1;
            int r = Integer.parseInt(input[1]);

            int min = seg.searchMin(l,r);
            int max = seg.searchMax(l,r);

            bw.write(min+" "+max+"\n");
        }

        bw.flush();

    }
}
