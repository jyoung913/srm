import java.math.BigInteger;
public  class BearPlays {
    public  int PileSize ( int A, int B, int K) {
        long S = A + B;
        BigInteger AInteger = new BigInteger ( "2" );
        BigInteger KInteger = new BigInteger (String.valueOf (K));
        BigInteger ansInteger = AInteger.modPow (KInteger,
                new BigInteger (String.valueOf (S)));

        long ans1 = ansInteger.longValue();
        ans1 %= S;
        ans1 *= A;
        ans1 %= S;
        long ANS2 = S - ans1;

        return ( int ) Math.min (ans1, ANS2);
    }

}