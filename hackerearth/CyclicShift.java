// PROBLEM : Cyclic shifts

import java.util.*;

// Warning: Printing unwanted or ill-formatted data to output will cause the test cases to fail
// cyclic shift
// convert into binary
// append zeros to make it binary of 16 bits
// whenever you hear a word cyclic its mostly '%' modulo operator. so think in that terms
// see some patterns. what happens to right shift 011101  2>  010111. 
// based on the patterns just substring and concatenate
class TestClass {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();                 
        for(int x = 0; x < t; x++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            char c = sc.next().charAt(0);
            StringBuilder binary = new StringBuilder();
            while(n > 0) {
                binary.append(n % 2);
                n = n /2;
            }
            while(binary.length() < 16) {
                binary.append("0");
            }

            binary.reverse();
        
            m = m % binary.length();
            String res = "";
            if(c == 'L') {
                res =  binary.substring(m) + binary.substring(0, m);
                
            } else {
                res = binary.substring(binary.length() - m) + binary.substring(0, binary.length() - m);
            }

            int sum = 0;
            int count = 0;
            for(int i = res.length() - 1; i >= 0; i--) {
                sum = sum + Character.getNumericValue(res.charAt(i)) * (int)Math.pow(2, count++);
            }
            System.out.println(sum);
        }  

    }
}


public class CyclicShift {

}