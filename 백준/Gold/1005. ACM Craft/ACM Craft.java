
import java.io.*;
import java.util.*;

public class Main {

    static public class Building implements Comparable<Building>{

        int num; // 건물 번호
        int time; // 건설 시간
        int start; // 건물 공사 시작 시간
        int end; // 건물 공사가 끝나는 시간

        Building(int num, int time){
            this.num=num;
            this.time=time;
            this.start = 0;
            this.end = 0;
        }

        int getNum(){
            return this.num;
        }
        int getStart(){
            return this.start;
        }
        void setStart(int start){
            this.start=start;
        }
        int getEnd(){
            return this.end;
        }
        void setEnd(int end){
            this.end=end;
        }

        @Override
        public int compareTo(Building o) {
            return this.time-o.time;
        }
    }

    static int N; // 건물 개수
    static int K; // 건설 순서 규칙의 개수
    static Building[] buildings; // 건물 객체

    static PriorityQueue<Integer>[] beforeBuild; // 선행 조건
    static PriorityQueue<Integer>[] afterBuild; // 이 건물이 끝난 후 지을 수 있는 건물
    static int W;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        String[] input;

        for(int test_case=1; test_case<=T; test_case++){

            input = br.readLine().split(" ");

            N = Integer.parseInt(input[0]);
            K = Integer.parseInt(input[1]);

            buildings = new Building[N+1];

            beforeBuild = new PriorityQueue[N+1];
            afterBuild = new PriorityQueue[N+1];

            input = br.readLine().split(" ");
            for(int i=1; i<=N; i++){
                buildings[i]=new Building(i,Integer.parseInt(input[i-1]));
                beforeBuild[i] = new PriorityQueue<>();
                afterBuild[i] = new PriorityQueue<>();
            }

            for(int i=0; i<K; i++){

                input = br.readLine().split(" ");
                int X = Integer.parseInt(input[0]);
                int Y = Integer.parseInt(input[1]);

                afterBuild[X].add(Y);
                beforeBuild[Y].add(X);

            }

            W = Integer.parseInt(br.readLine()); // 목표 건물

            gameStart(W);

            int res = buildings[W].getEnd();

            bw.write(res+"\n");
        }

        bw.flush();
    }

    public static void gameStart(int num){

        if(beforeBuild[num].isEmpty()){ // 선행 조건이 없으면 바로 리턴
            buildings[num].setEnd(buildings[num].time);
            return;
        }

        int time = 0;

        while(!beforeBuild[num].isEmpty()){
            int n = beforeBuild[num].poll();
            treat(n);
            time = Math.max(buildings[n].getEnd(),time); // 시작지점 찾기
        }

        buildings[num].setEnd(buildings[num].time+time);
    }

    public static void treat(int num){

        if(beforeBuild[num].isEmpty()){ // 선행 조건이 없을 경우
            buildings[num].setEnd(buildings[num].time+buildings[num].getStart()); // 끝나는 시간 저장
            while(!afterBuild[num].isEmpty()){ // num을 선행 조건으로 가진 건물들 찾기
                int n = afterBuild[num].poll();
                beforeBuild[n].remove(num); // n의 선행 조건에서 num 제거
                int time = Math.max(buildings[n].getStart(),buildings[num].getEnd());
                buildings[n].setStart(time); // n의 시작 시간 갱신
            }
        }else{
            while(!beforeBuild[num].isEmpty()){ // 선행 조건이 있을 경우
                int n = beforeBuild[num].poll();
                treat(n);
                int time = Math.max(buildings[num].getStart(),buildings[n].getEnd());
                buildings[num].setStart(time);
            }
            buildings[num].setEnd(buildings[num].time+buildings[num].getStart());
        }

    }

}