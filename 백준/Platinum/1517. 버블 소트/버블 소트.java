
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] A, temp;
    static long result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        temp = new int[N+1];
        result = 0;

        String[] input = br.readLine().split(" ");

        for(int i=1; i<=N; i++){
            A[i] = Integer.parseInt(input[i-1]);
            temp[i] = A[i];
        }

        mergeSort(1, N);

        bw.write(result+"");
        bw.flush();

    }

    public static void mergeSort(int start, int end){

        if(end-start<1){
            return;
        }

        int k = start;
        int mid = start + (end-start) / 2;

        int index1 = start;
        int index2 = mid+1;

        mergeSort(start, mid);
        mergeSort(mid+1, end);

        for(int i=start; i<=end; i++){
            A[i] = temp[i];
        }

        while(index1<=mid && index2<=end){

            if(A[index1] > A[index2]){
                temp[k] = A[index2];
                k++;
                index2++;
                result += index2 - k;
            }else{
                temp[k] = A[index1];
                k++;
                index1++;
            }

        }

        while(index1<=mid){
            temp[k] = A[index1];
            k++;
            index1++;
        }

        while(index2<=end){
            temp[k] = A[index2];
            k++;
            index2++;
        }

    }

}
