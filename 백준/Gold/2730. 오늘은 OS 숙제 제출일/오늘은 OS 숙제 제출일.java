import java.io.*;
import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        // 포맷터 준비
        DateTimeFormatter fullFmt = DateTimeFormatter.ofPattern("M/d/yyyy");

        for (int test_case = 0; test_case < T; test_case++) {

            String[] input = br.readLine().split(" ");

            LocalDate day1 = LocalDate.parse(input[0], fullFmt);

            String day2String = input[1] + "/" + day1.getYear();
            LocalDate day2 = LocalDate.parse(day2String, fullFmt);

            if (Math.abs(day1.getMonthValue() - day2.getMonthValue()) == 11) {
                day2 = day2.getMonthValue()==12 ?
                        day2.withYear(day1.getYear() - 1)
                        : day2.withYear(day1.getYear() + 1);

            }

            long diff = ChronoUnit.DAYS.between(day1, day2);

            if(Math.abs(diff) > 7){
                bw.write("OUT OF RANGE");
            }else if(diff < 0){
                bw.write(day2.getMonthValue()+"/"+
                        day2.getDayOfMonth()+"/"+
                        day2.getYear()+" IS "+Math.abs(diff)
                +" ");
                String next = diff == -1 ? "DAY" : "DAYS";
                bw.write(next+" PRIOR");
            }else if(diff > 0){
                bw.write(day2.getMonthValue()+"/"+
                        day2.getDayOfMonth()+"/"+
                        day2.getYear()+" IS "+Math.abs(diff)
                        +" ");
                String next = diff == 1 ? "DAY" : "DAYS";
                bw.write(next+" AFTER");
            }else{
                bw.write("SAME DAY");
            }

            bw.write("\n");

        }

        bw.flush();
    }
}
