import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] AB = br.readLine().split(" ");
        BigInteger A = new BigInteger(AB[0]);
        BigInteger B = new BigInteger(AB[1]);
        System.out.print(A.add(B));
    }
}