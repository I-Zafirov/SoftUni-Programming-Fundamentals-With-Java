package x21_ObjectsAndClasses.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students3 {
    String firstName;
    String lastName;
    int age;
    String city;

    Students3(String firstName, String lastName, int age, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.city = city;
    }

    boolean isFrom(String city) {
        return this.city.equals(city);
    }

    String getInfo() {
        return String.format("%s %s is %d years old.", this.firstName, this.lastName, this.age);
    }

    String getFirstName() {
        return this.firstName;
    }

    String getLastName() {
        return this.lastName;
    }

    public class Students {
        public static void main(String[] args) {
            List<Students3> students = new ArrayList<>();
            Scanner scanner = new Scanner(System.in);
            String line = scanner.nextLine();
            while (!line.equals("end")) {
                String[] studentParameters = line.split("\\s+");
                String firstName = studentParameters[0];
                String lastName = studentParameters[1];
                int age = Integer.parseInt(studentParameters[2]);
                String city = studentParameters[3];

                int index = indexOfStudent(students, firstName, lastName);
                if (index == -1) {
                    students.add(new Students3(firstName, lastName, age, city));
                } else {
                    students.set(index, new Students3(firstName, lastName, age, city));
                }
                line = scanner.nextLine();
            }
            String city = scanner.nextLine();
            for (Students3 student : students) {
                if (student.isFrom(city)) {
                    System.out.println(student.getInfo());
                }
            }
        }

        private static int indexOfStudent(List<Students3> students, String firstName, String lastName) {
            for (int i = 0; i < students.size(); i++) {
                Students3 s = students.get(i);
                if (s.getFirstName().equals(firstName)
                        && s.getLastName().equals(lastName)) {
                    return i;
                }
            }
            return -1;
        }
    }
}
