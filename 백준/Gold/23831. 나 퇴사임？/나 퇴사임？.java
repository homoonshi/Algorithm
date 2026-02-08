import java.io.*;
import java.util.*;

/**
 * 요양신청 최대 A
 * 휴게실 이틀연속 자습 X
 * 정독실 or 소학습실 자습 B회 이상
 */
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String[] input;

        int N = Integer.parseInt(br.readLine()); // 자습일 수
        input = br.readLine().split(" ");

        int restCount = Integer.parseInt(input[0]); // 요양신청횟수
        int studyCount = Integer.parseInt(input[1]); // 정독실/소학습실 자습횟수

        int[][][][] dp = new int[N+1][2][restCount+1][studyCount+1]; // 자습일수, 휴게실인지, 요양신청횟수, 정독실/소학습실자습횟수

        for(int i=1; i<=N; i++){
            input = br.readLine().split(" ");

            int reading = Integer.parseInt(input[0]); // 정독실
            int study   = Integer.parseInt(input[1]); // 소학습실
            int lounge  = Integer.parseInt(input[2]); // 휴게실
            int care    = Integer.parseInt(input[3]); // 요양

            int state1 = Math.min(i-1, restCount);
            int state2 = Math.min(i-1, studyCount);

            // 1. 정독실, 소학습실
            int sat = Math.max(reading, study);
            for(int j=0; j<2; j++){ // 휴게실 상관없음
                for(int k=0; k<=state1; k++){ // 요양신청횟수 상관없음
                    for(int l=0; l<=state2; l++){ // 자습횟수 상관없음
                        int next = l+1 > studyCount ? l : l+1;
                        if((i>1) && dp[i-1][j][k][l] == 0) continue;
                        dp[i][0][k][next] = Math.max(dp[i][0][k][next],
                                                    dp[i-1][j][k][l] + sat);
                    }
                }
            }

            // 2. 휴게실
            for(int k=0; k<=state1; k++){ // 요양신청횟수 상관없음
                for(int l=0; l<=state2; l++){ // 자습횟수 상관없음
                    if((i>1) && dp[i-1][0][k][l] == 0) continue;
                    dp[i][1][k][l] = Math.max(dp[i][1][k][l],
                                            dp[i-1][0][k][l] + lounge);
                }
            }

            // 3. 요양
            for(int j=0; j<2; j++){ // 휴게실 상관없음
                for(int k=0; k<=state1; k++){ // 요양신청횟수 상관있음
                    if(k==restCount) continue;
                    for(int l=0; l<=state2; l++){ // 자습횟수 상관없음
                        int next = k+1;
                        if((i>1) && dp[i-1][j][k][l] == 0) continue;
                        dp[i][0][next][l] = Math.max(dp[i][0][next][l],
                                dp[i-1][j][k][l] + care);
                    }
                }
            }

        }

        int res = 0;

        for(int i=0; i<=restCount; i++){
            for(int j=0; j<2; j++) {
                res = Math.max(res, dp[N][j][i][studyCount]);
            }
        }

        bw.write(res+"");
        bw.flush();

    }
}