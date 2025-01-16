import java.math.BigInteger;
import java.util.*;
import java.io.*;

public class Main {

    static class Drink implements Comparable<Drink> {
        long w;
        long u;

        public Drink(long w, long u) {
            this.w = w;
            this.u = u;
        }

        @Override
        public int compareTo(Drink o) {
            return Long.compare(o.u * this.w, this.u * o.w);
        }
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        long N = Long.parseLong(input[0]);
        long M = Long.parseLong(input[1]);

        PriorityQueue<Drink> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            input = br.readLine().split(" ");
            long w = Long.parseLong(input[0]);
            long u = Long.parseLong(input[1]);
            pq.add(new Drink(w, u));
        }

        BigInteger numerator  = BigInteger.ZERO;
        BigInteger denominator = BigInteger.ONE;

        while(M>0 && !pq.isEmpty()){

            Drink temp = pq.poll();

            if (temp.w <= M) {
                M -= temp.w;
                numerator = numerator.add(BigInteger.valueOf(temp.u).multiply(denominator));
            } else {
                numerator = numerator.multiply(BigInteger.valueOf(temp.w))
                        .add(BigInteger.valueOf(temp.u).multiply(BigInteger.valueOf(M).multiply(denominator)));
                denominator = denominator.multiply(BigInteger.valueOf(temp.w));
                break;
            }

        }

        BigInteger gcd = numerator.gcd(denominator);

        numerator = numerator.divide(gcd);
        denominator = denominator.divide(gcd);

        if (denominator.equals(BigInteger.ONE)) {
            bw.write(numerator+"/"+1);
        } else {
            bw.write(numerator + "/" + denominator);
        }

        bw.flush();

    }

}
