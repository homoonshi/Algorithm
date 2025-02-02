import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        int[][][] res = new int[N][N][N];
        int[][] H = new int[N][N];
        int[][] R = new int[N][N];
        int[][] C = new int[N][N];

        String input;

        for(int i=0; i<N; i++){
            input = br.readLine();
            for(int j=0; j<N; j++){
                H[i][j] = (input.charAt(j)-'0') * N;
                if(H[i][j]==0){
                    H[i][j] = -1;
                }else {
                    for (int k = 0; k < N; k++) {
                        res[k][i][j] = 1;
                    }
                }
            }
        }

        for(int i=0; i<N; i++){
            input = br.readLine();
            for(int j=0; j<N; j++){
                R[i][j] = (input.charAt(j)-'0') * N;
                if(R[i][j]==0){
                    R[i][j] = -1;
                    for(int k=0; k<N; k++){
                        if(res[i][k][j]==1) {
                            res[i][k][j] = 0;
                            H[k][j]--;
                        }
                    }
                }
            }
        }

        for(int i=0; i<N; i++){
            input = br.readLine();
            for(int j=0; j<N; j++){
                C[i][j] = (input.charAt(j)-'0') * N;
                if(C[i][j]==0){
                    C[i][j] = -1;
                    for(int k=0; k<N; k++){
                        if(res[i][j][k]==1) {
                            res[i][j][k] = 0;
                            H[j][k]--;
                        }
                    }
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    if(res[i][j][k]==0){
                        if(R[i][k]>0){
                            R[i][k]--;
                        }
                        if(C[i][j]>0){
                            C[i][j]--;
                        }
                    }
                }
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(H[i][j]==0 || R[i][j]==0 || C[i][j]==0){
                    bw.write("NO");
                    bw.flush();
                    return;
                }
            }
        }

        bw.write("YES\n");

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                for(int k=0; k<N; k++){
                    bw.write(res[i][j][k]+"");
                }
                bw.write("\n");
            }
        }

        bw.flush();

    }

}
