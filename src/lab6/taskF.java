package lab6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class taskF {

    static void random(String[][] arr, int low, int high) {
        Random random = new Random();
        int pivot = random.nextInt(high - low) + low;
        String[] temp = arr[pivot];
        arr[pivot] = arr[high];
        arr[high] = temp;
    }

    static int partition(String[][] arr, int low, int high) {
        random(arr, low, high);
        String[] pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (compare(arr[j], pivot) <= 0) {
                i++;
                String[] temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        String[] temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    static void quickSort(String[][] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int compare(String[] student1, String[] student2) {
        double gpa1 = Double.parseDouble(student1[2]);
        double gpa2 = Double.parseDouble(student2[2]);

        if (gpa1 != gpa2) {
            return Double.compare(gpa1, gpa2);
        }

        int lastNameCompare = student1[0].compareTo(student2[0]);
        if (lastNameCompare != 0) {
            return lastNameCompare;
        }

        return student1[1].compareTo(student2[1]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[][] students = new String[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String lastName = st.nextToken();
            String firstName = st.nextToken();
            int numberOfSubjects = Integer.parseInt(st.nextToken());
            double totalGpa = 0;
            int totalCredits = 0;

            for (int j = 0; j < numberOfSubjects; j++) {
                String grade = st.nextToken();
                int credits = Integer.parseInt(st.nextToken());
                totalGpa += getGPA(grade) * credits;
                totalCredits += credits;
            }

            double gpa = totalGpa / totalCredits;
            students[i][0] = lastName;
            students[i][1] = firstName;
            students[i][2] = String.format("%.3f", gpa);
        }

        quickSort(students, 0, n - 1);

        for (String[] student : students) {
            System.out.printf("%s %s %s%n", student[0], student[1], student[2]);
        }
    }

    private static double getGPA(String grade) {
        return switch (grade) {
            case "A+" -> 4.0;
            case "A" -> 3.75;
            case "B+" -> 3.5;
            case "B" -> 3.0;
            case "C+" -> 2.5;
            case "C" -> 2.0;
            case "D+" -> 1.5;
            case "D" -> 1.0;
            case "F" -> 0.0;
            default -> 0.0;
        };
    }
}
