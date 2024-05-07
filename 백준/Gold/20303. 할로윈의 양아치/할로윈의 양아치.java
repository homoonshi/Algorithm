
import java.util.*;
import java.io.*;

public class Main {

    static int N,M,K;
    static int[] c;
    static int[] parent;

    static class Friend {

        int root;
        int person;
        int candy;

        Friend(int root){
            this.root=root;
        }

    }

    static List<Friend> friends;
    static int frinedIndex;
    static int[][] res;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]); // 거리에 있는 아이들 수
        M = Integer.parseInt(input[1]); // 아이들의 친구 관계 수
        K = Integer.parseInt(input[2]); // 울음소리 최소 아이 수

        c = new int[N+1]; // 아이들이 받은 사탕의 수
        parent = new int[N+1];
        friends = new ArrayList<>();
        frinedIndex = 0;

        input = br.readLine().split(" ");

        for(int i=1; i<=N; i++){
            c[i] = Integer.parseInt(input[i-1]);
            parent[i] = i;
        }

        for(int i=1; i<=M; i++){
            input = br.readLine().split(" ");

            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            merge(a,b);
        }

        for(int i=1; i<=N; i++){

            if(find(i)==parent[i]) {
                if (find(i) != i) {
                    continue;
                }

                friends.add(new Friend(i));

                for (int j = i; j <= N; j++) {
                    if(find(j)==find(i)) {
                        parent[j] = i;
                        friends.get(frinedIndex).candy += c[j];
                        friends.get(frinedIndex).person ++;
                    }
                }
                frinedIndex++;
            }

        }
        

        res = new int[frinedIndex+1][K]; // [친구모임개수][울음소리최소인원수]

        dp();

        bw.write(res[frinedIndex][K-1]+"");

        bw.flush();


    }

    public static void dp(){

        int candy;
        int person;

        for(int i=0; i<frinedIndex; i++){

            candy = friends.get(i).candy;
            person = friends.get(i).person;

            for(int j=1; j<K; j++){

                if(j<person) {
                    res[i + 1][j] = Math.max(res[i][j], res[i][j]);
                }else{
                    res[i+1][j]=Math.max(res[i][j],res[i][j-person]+candy);
                }

            }
        }

    }

    public static void merge(int x,int y){

        x = find(x);
        y = find(y);

        if(x==y) return;
        if(x<y) parent[y]=x;
        if(y<x) parent[x]=y;

    }

    public static int find(int x){
        if(parent[x]==x){
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    boolean isUnion(int x,int y){
        x = find(x);
        y = find(y);
        if (x==y) {
            return true;
        }
        return false;
    }

}