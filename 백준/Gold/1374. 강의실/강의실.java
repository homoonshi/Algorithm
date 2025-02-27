
import java.io.*;
import java.util.*;

public class Main {

    static class Room implements Comparable<Room> {
        int number;
        int startTime;
        int endTime;

        public Room(int number, int startTime, int endTime) {
            this.number = number;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Room o) {
            return this.endTime - o.endTime;
        }
    }

    static class Study implements Comparable<Study> {
        int number;
        int startTime;
        int endTime;

        public Study(int number, int startTime, int endTime) {
            this.number = number;
            this.startTime = startTime;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Study o) {
            return this.startTime - o.startTime;
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] input;
        PriorityQueue<Room> rooms = new PriorityQueue<>();
        List<Study> studies = new ArrayList<>();

        int result = 0;

        for(int i=0; i<N; i++){

            input = br.readLine().split(" ");

            int num = Integer.parseInt(input[0]);
            int st = Integer.parseInt(input[1]);
            int ed = Integer.parseInt(input[2]);

            studies.add(new Study(num, st, ed));

        }

        Collections.sort(studies);

        for(int i=0; i<N; i++){

            Study study = studies.get(i);

            while(!rooms.isEmpty()){
                Room room = rooms.poll();
                if(room.endTime > study.startTime){
                    rooms.add(room);
                    break;
                }
            }

            rooms.add(new Room(study.number, study.startTime, study.endTime));
            result = Math.max(result, rooms.size());

        }

        bw.write(result+"");
        bw.flush();

    }

}
