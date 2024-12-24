
import java.io.*;
import java.util.*;

public class Main {

    static class Title implements Comparable<Title>{
        int status;
        String title;

        public Title(int status, String title) {
            this.status = status;
            this.title = title;
        }

        @Override
        public int compareTo(Title o) {
            return this.status - o.status;
        }
    }

    static int N, M;
    static List<Title> titles;
    static Set<Integer> set;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        set = new HashSet<>();
        titles = new ArrayList<>();

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");

            String title = input[0];
            int status = Integer.parseInt(input[1]);

            if(!set.contains(status)) {
                titles.add(new Title(status, title));
                set.add(status);
            }
        }

        Collections.sort(titles);

        for(int i=0; i<M; i++){
            int num = Integer.parseInt(br.readLine());
            bw.write(getTitle(num)+"\n");
        }

        bw.flush();
    }

    public static String getTitle(int num){
        int start = 0;
        int end = titles.size()-1;

        while(start<=end){

            int mid = (start+end)/2;

            if(titles.get(mid).status<num){
                start = mid+1;
            }else{
                end = mid-1;
            }

        }

        return titles.get(start).title;
    }

}
