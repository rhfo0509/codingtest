import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Student implements Comparable<Student> {
        String name;
        int year;
        int month;
        int date;

        Student(String name, int year, int month, int date) {
            this.name = name;
            this.year = year;
            this.month = month;
            this.date = date;
        }

        public int compareTo(Student o) {
            if (year == o.year) {
                if (month == o.month) {
                    return date - o.date;
                } else {
                    return month - o.month;
                }
            } else {
                return year - o.year;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        List<Student> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int date = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());

           arr.add(new Student(name, year, month, date));
        }

        Collections.sort(arr);
        System.out.println(arr.get(n-1).name);
        System.out.println(arr.get(0).name);
    }
}