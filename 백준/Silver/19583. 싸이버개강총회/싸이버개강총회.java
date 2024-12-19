
import java.io.*;
import java.sql.Time;
import java.time.LocalTime;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");

        LocalTime startTime = LocalTime.parse(inputs[0]);
        LocalTime endTime = LocalTime.parse(inputs[1]);
        LocalTime endStream = LocalTime.parse(inputs[2]);

        Set<String> set = new HashSet<>();
        Set<String> end = new HashSet<>();
        int result = 0;

        while(true){

            String input = br.readLine();

            if(input==null || input.isEmpty()){
                break;
            }

            inputs = input.split(" ");

            LocalTime time = LocalTime.parse(inputs[0]);
            String name = inputs[1];

             if(startTime.isAfter(time) || startTime.equals(time)){
                 set.add(name);
                 continue;
             }

             if(endTime.isBefore(time) || endTime.equals(time)){
                 if (endStream.isAfter(time) || endStream.equals(time)){
                     if (!end.contains(name) && set.contains(name)){
                         end.add(name);
                         result++;
                     }
                 }
             }

        }

        bw.write(result+"");
        bw.flush();

    }

}
