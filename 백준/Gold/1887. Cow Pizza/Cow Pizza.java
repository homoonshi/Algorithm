
import java.io.*;
import java.util.*;

public class Main {

    static int T, N;
    static List<List<Integer>>[] pizza;
    static Set<Integer> made;
    static int res;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        T = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);

        pizza = new List[T+1];
        made = new HashSet<>();

        for(int i=1; i<=T; i++){
            pizza[i] = new ArrayList<>();
        }

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");

            int z = Integer.parseInt(input[0]);
            List<Integer> temp = new ArrayList<>();

            for(int j=1; j<=z; j++){
                temp.add(Integer.parseInt(input[j]));
            }

            Collections.sort(temp);
            pizza[z].add(temp);
        }

        res = 1;

        for(int i=1; i<=T; i++){

            combination(i, 0, 1);

        }

        bw.write(res+"");
        bw.flush();

    }

    public static void combination(int num, int count, int index){

        if(num==count){
            res++;
            return;
        }

        loof : for(int i=index; i<=T; i++){

            made.add(i);

            for(int j=1; j<=count+1; j++) {
                for (List<Integer> list : pizza[j]) {
                    int c = 0;
                    for (Integer n : list) {
                        if (made.contains(n)) {
                            c++;
                        }
                    }
                    if(c==j){
                        made.remove(i);
                        continue loof;
                    }
                }
            }

            combination(num, count+1, i+1);
            made.remove(i);

        }

    }


}