package lab8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class taskE {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfInputs = Integer.parseInt(reader.readLine());

        ArrayList<Long> p = new ArrayList<>();
        String[] inputs = reader.readLine().split(" ");
        for (int i = 0; i < numberOfInputs; ++i) {
            p.add(Long.parseLong(inputs[i]));
        }

        StringBuilder S = new StringBuilder();
        long power = 1;
        long sum = 0;

        for (int i = 0; i < numberOfInputs; ++i) {
            long contribution = (p.get(i) - sum) / power;

            char character = (char) (contribution + 97);
            S.append(character);

            sum += contribution * power;
            power *= 2;
        }

        System.out.println(S);
    }
}

