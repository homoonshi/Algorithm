import java.io.*;
import java.util.*;

public class Main {

    static class Food implements Comparable<Food>{
        int spicy, sweet;

        public Food(int spicy, int sweet) {
            this.spicy = spicy;
            this.sweet = sweet;
        }

        @Override
        public int compareTo(Food o) {
            return this.spicy - o.spicy;
        }
    }

    static Food[] foods;
    static int lunchMenu;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        lunchMenu = Integer.parseInt(input[0]);
        int lunchTime = Integer.parseInt(input[1]);

        foods = new Food[lunchMenu];

        for(int i=0; i<lunchMenu; i++){
            input = br.readLine().split(" ");

            int spicy = Integer.parseInt(input[0]);
            int sweet = Integer.parseInt(input[1]);

            foods[i] = new Food(spicy, sweet);
        }

        Arrays.sort(foods);

        for(int i=0; i<lunchTime; i++){
            input = br.readLine().split(" ");

            int min = Integer.parseInt(input[0]);
            int max = Integer.parseInt(input[1]);

            int start = search(min, 1);
            int end = search(max, 0);

            int count = 0;

            min = Integer.parseInt(input[2]);
            max = Integer.parseInt(input[3]);

            for(int j=start; j<=end; j++){
                if(min <= foods[j].sweet && foods[j].sweet <= max){
                    count++;
                }
            }

            bw.write(count+"\n");
        }

        bw.flush();
    }

    public static int search(long standard, int set){
        int start = 0;
        int end = lunchMenu - 1;

        while(start<=end){
            int mid = (start + end) / 2;

            if(set==1) {
                if (foods[mid].spicy < standard) start = mid + 1;
                else end = mid - 1;
            }else{
                if (foods[mid].spicy <= standard) start = mid + 1;
                else end = mid - 1;
            }
        }

        return set == 1 ? start : end;
    }

}