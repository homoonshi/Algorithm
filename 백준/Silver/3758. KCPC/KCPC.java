
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int test_case=0; test_case<T; test_case++){

            String[] input = br.readLine().split(" ");

            int teamNum = Integer.parseInt(input[0]);
            int problemNum = Integer.parseInt(input[1]);
            int myTeamId = Integer.parseInt(input[2]);
            int logEntryNum = Integer.parseInt(input[3]);

            int[] submitCount = new int[teamNum+1];
            int[] submitLastTime = new int[teamNum+1];

            int[][] team = new int[teamNum+1][problemNum+1];

            for(int i=1; i<=logEntryNum; i++){
                input = br.readLine().split(" ");

                int teamId = Integer.parseInt(input[0]);
                int problem = Integer.parseInt(input[1]);
                int score = Integer.parseInt(input[2]);

                submitCount[teamId]++;
                submitLastTime[teamId] = i;
                team[teamId][problem] = Math.max(team[teamId][problem], score);
            }

            int myTeamScore = 0;

            for(int i=1; i<=problemNum; i++){
                myTeamScore += team[myTeamId][i];
            }

            int result = 1;

            for(int i=1; i<=teamNum; i++){

                int currentTeamScore = 0;

                for(int j=1; j<=problemNum; j++){
                    currentTeamScore += team[i][j];
                }

                if(currentTeamScore>myTeamScore){
                    result++;
                }else if(currentTeamScore==myTeamScore){
                    if(submitCount[i]<submitCount[myTeamId]){
                        result++;
                    }else if(submitCount[i]==submitCount[myTeamId]){
                        if(submitLastTime[i]<submitLastTime[myTeamId]){
                            result++;
                        }
                    }
                }

            }

            bw.write(result+"\n");

        }

        bw.flush();

    }

}
