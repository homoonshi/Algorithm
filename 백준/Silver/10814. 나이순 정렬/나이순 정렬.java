import java.io.*;
import java.util.*;

public class Main {

    static class Member implements Comparable<Member>{
        int index;
        int age;
        String name;

        public Member(int index, int age, String name) {
            this.index = index;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Member o) {
            if(this.age==o.age){
                return this.index - o.index;
            }
            return this.age-o.age;
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Member[] members = new Member[N];

        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            int age = Integer.parseInt(input[0]);
            members[i] = new Member(i, age, input[1]);
        }

        Arrays.sort(members);

        for(int i=0; i<N; i++){
            bw.write(members[i].age+" "+members[i].name+"\n");
        }

        bw.flush();

    }
}