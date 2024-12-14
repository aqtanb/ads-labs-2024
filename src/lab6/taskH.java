package lab6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class taskH {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        char[] letters = br.readLine().toCharArray();
        char key = br.readLine().charAt(0);
        char balanced = 65499;
        for (char letter : letters) {
            if (letter > key && letter < balanced) {
                balanced = letter;
            }
        }
        if (balanced == 65499) {
            System.out.println(letters[0]);
        } else {
            System.out.println(balanced);
        }
    }
}
