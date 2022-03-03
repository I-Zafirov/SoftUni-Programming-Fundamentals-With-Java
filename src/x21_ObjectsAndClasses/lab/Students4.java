package x21_ObjectsAndClasses.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students4 {
    static class Student {
        String firstName;
        String lastName;
        int age;
        String city;

        Student(String firstName, String lastName, int age, String city) {
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
        void setAge(int age){
            this.age = age;
        }
        void setCity(String city){
            this.city = city;
        }
    }

    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        while (!line.equals("end")) {
            String[] studentParameters = line.split("\\s+");
            String firstName = studentParameters[0];
            String lastName = studentParameters[1];
            int age = Integer.parseInt(studentParameters[2]);
            String city = studentParameters[3];

            Student existing = findStudent(students, firstName, lastName);
            if (existing == null) {
                students.add(new Student(firstName, lastName, age, city));
            } else {
                existing.setAge(age);
                existing.setCity(city);
            }
            line = scanner.nextLine();
        }
        String city = scanner.nextLine();
        for (Student student : students) {
            if (student.isFrom(city)) {
                System.out.println(student.getInfo());
            }
        }
    }
    private static Student findStudent(List<Student> students, String firstName, String lastName){
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            if (s.getFirstName().equals(firstName)
                    && s.getLastName().equals(lastName)) {
                return s;
            }
        }
        return null;
    }
    /*
    private static int indexOfStudent(List<Students.Student> students, String firstName, String lastName) {
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            if (s.getFirstName().equals(firstName)
                    && s.getLastName().equals(lastName)) {
                return i;
            }
        }
        return -1;
    }
    */
}
