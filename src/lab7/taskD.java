package lab7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class taskD {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int studentCount = Integer.parseInt(bufferedReader.readLine());

        List<String[]> students = new ArrayList<>();
        List<Double> gpas = new ArrayList<>();

        for (int i = 0; i < studentCount; i++) {
            StringTokenizer studentInfo = new StringTokenizer(bufferedReader.readLine());
            String lastName = studentInfo.nextToken();
            String firstName = studentInfo.nextToken();
            int subjectCount = Integer.parseInt(studentInfo.nextToken());
            double weightedSum = 0;
            int creditSum = 0;

            for (int j = 0; j < subjectCount; j++) {
                String grade = studentInfo.nextToken();
                int credits = Integer.parseInt(studentInfo.nextToken());
                weightedSum += getGPA(grade) * credits;
                creditSum += credits;
            }

            double gpa = weightedSum / creditSum;
            students.add(new String[]{lastName, firstName});
            gpas.add(gpa);
        }

        Collections.sort(students, (student1, student2) -> {
            double gpa1 = gpas.get(students.indexOf(student1));
            double gpa2 = gpas.get(students.indexOf(student2));

            if (Double.compare(gpa1, gpa2) != 0) {
                return Double.compare(gpa1, gpa2);
            } else if (!student1[0].equals(student2[0])) {
                return student1[0].compareTo(student2[0]);
            } else {
                return student1[1].compareTo(student2[1]);
            }
        });

        StringBuilder result = new StringBuilder();
        for (String[] student : students) {
            double gpa = gpas.get(students.indexOf(student));
            result.append(student[0]).append(" ")
                    .append(student[1]).append(" ")
                    .append(String.format("%.3f", gpa)).append("\n");
        }
        System.out.print(result);
    }

    private static double getGPA(String grade) {
        return switch (grade) {
            case "A+" -> 4.00;
            case "A" -> 3.75;
            case "B+" -> 3.50;
            case "B" -> 3.00;
            case "C+" -> 2.50;
            case "C" -> 2.00;
            case "D+" -> 1.50;
            case "D" -> 1.00;
            default -> 0.00;
        };
    }
}
