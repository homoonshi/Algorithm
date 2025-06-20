
import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static Deque<Integer>[] deque;
    static int[] multitap;
    static int[] connect;
    static int[] sequence;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        multitap = new int[N];
        connect = new int[K+1];
        sequence = new int[K];
        deque = new Deque[K+1];

        input = br.readLine().split(" ");

        for(int i=1; i<=K; i++){
            deque[i] = new ArrayDeque<>();
        }

        Arrays.fill(connect, -1);

        for(int i=0; i<K; i++){
            sequence[i] = Integer.parseInt(input[i]);
            deque[sequence[i]].add(i);
        }

        int res = 0;
        int count = 0;

        loof : for(int i=0; i<K; i++){

            if(connect[sequence[i]]==-1){
                int index = -1;
                int max = 0;
                for (int j = 0; j < N; j++) {
                    if(count < N) {
                        if (multitap[j] == 0) {
                            connect[sequence[i]] = j;
                            multitap[j] = sequence[i];
                            deque[sequence[i]].pollFirst();
                            count++;
                            continue loof;
                        }
                        continue;
                    }
                    if(deque[multitap[j]].isEmpty()){
                        index = j;
                        break;
                    }
                    int next = deque[multitap[j]].peekFirst() - i;
                    if(max - i < next){
                        max = next + i;
                        index = j;
                    }
                }
                connect[multitap[index]] = -1;
                connect[sequence[i]] = index;
                multitap[index] = sequence[i];
                deque[sequence[i]].pollFirst();
                res++;
            }else{
                deque[sequence[i]].pollFirst();
            }

        }

        bw.write(res+"");
        bw.flush();

    }
}