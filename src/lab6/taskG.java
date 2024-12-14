package lab6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class taskG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Map<String, String> nicknames = new TreeMap<>();
        Map<String, String> reverseMap = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            String[] names = br.readLine().split(" ");
            String oldName = names[0], newName = names[1];

            String originalName = reverseMap.getOrDefault(oldName, oldName);
            nicknames.put(originalName, newName);
            reverseMap.put(newName, originalName);
            reverseMap.remove(oldName);
        }

        System.out.println(nicknames.size());
        for (Map.Entry<String, String> entry : nicknames.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
