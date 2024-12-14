package lab3;
import java.util.Scanner;

public class taskH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfBlocks = sc.nextInt();
        int numberOfMistakes = sc.nextInt();
        int[] linesInBlocks = new int[numberOfBlocks];
        for (int i = 0; i < numberOfBlocks; i++) {
            linesInBlocks[i] = sc.nextInt();
        }
        int[] cumulativeLines = new int[numberOfBlocks];
        cumulativeLines[0] = linesInBlocks[0];
        for (int i = 1; i < numberOfBlocks; i++) {
            cumulativeLines[i] = cumulativeLines[i - 1] + linesInBlocks[i];
        }
        for (int i = 0; i < numberOfMistakes; i++) {
            int mistakeLine = sc.nextInt();
            int blockNumber = findBlock(cumulativeLines, mistakeLine);
            System.out.println(blockNumber);
        }
        sc.close();
    }

    private static int findBlock(int[] cumulativeLines, int line) {
        int low = 0;
        int high = cumulativeLines.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (cumulativeLines[mid] < line) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low + 1;
    }
}
