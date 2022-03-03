package x21_ObjectsAndClasses.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Students2 {
    private String firstName;
    private String lastName;
    private int age;
    private String homeTown;

    public Students2(String firstName, String lastName, int age, String homeTown) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.homeTown = homeTown;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        List<Students2> students = new ArrayList<>();

        while (!command.equals("end")) {

            String[] input = command.split(" ");

            String firstName = input[0];
            String lastName = input[1];
            int age = Integer.parseInt(input[2]);
            String homeTown = input[3];

            if (IsStudentExisting(students, firstName, lastName)) {
                Students2 student = getStudent(students, firstName, lastName);

                student.setFirstName(firstName);
                student.setLastName(lastName);
                student.setAge(age);
                student.setHomeTown(homeTown);
            } else {
                Students2 student = new Students2(firstName, lastName, age, homeTown);
                students.add(student);
            }

            command = scanner.nextLine();
        }

        String filterHomeTown = scanner.nextLine();

        for (Students2 student : students) {
            if (student.getHomeTown().equals(filterHomeTown)) {
                System.out.printf("%s %s is %d years old%n",
                        student.getFirstName(), student.getLastName(), student.getAge());
            }
        }
    }
    private static Students2 getStudent(List<Students2> students, String firstName, String lastName) {
        Students2 existingStudent = null;

        for (Students2 student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                existingStudent = student;
            }
        }
        return existingStudent;
    }

    private static boolean IsStudentExisting(List<Students2> students, String firstName, String lastName) {
        for (Students2 student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return true;
            }
        }
        return false;
    }
}