
import java.io.*;
import java.util.*;

public class Main {

    static class Room implements Comparable<Room> {
        int start;
        int end;

        public Room(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Room o) {
            return this.end - o.end;
        }
    }

    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Room> rooms = new PriorityQueue<>();
        PriorityQueue<Meeting> meetings = new PriorityQueue<>();

        String[] input;

        for(int i=0; i<N; i++){

            input = br.readLine().split(" ");

            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);

            meetings.add(new Meeting(s, e));

        }

        int result = 0;

        for(int i=0; i<N; i++){

            Meeting meeting = meetings.poll();

            while(!rooms.isEmpty()){
                Room room = rooms.poll();

                if(room.end <= meeting.start) {
                    continue;
                }else {
                    rooms.add(room);
                    break;
                }
            }

            rooms.add(new Room(meeting.start, meeting.end));
            result = Math.max(result, rooms.size());

        }

        bw.write(result+"");
        bw.flush();

    }

}
