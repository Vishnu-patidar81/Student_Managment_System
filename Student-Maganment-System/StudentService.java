import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentService {

    ArrayList<Student> students = new ArrayList<>();

    String fileName = "students.txt";

    public StudentService() {
        loadStudentsFromFile();
    }

    public void addStudent(Student student) {
        students.add(student);
        saveStudentsToFile();
        System.out.println("Student Added Successfully!");
    }

    public void displayStudents() {

        if (students.isEmpty()) {
            System.out.println("No Students Found!");
            return;
        }

        for (Student s : students) {
            System.out.println("-----------------------");
            System.out.println("ID : " + s.getId());
            System.out.println("Name : " + s.getName());
            System.out.println("Age : " + s.getAge());
            System.out.println("Course : " + s.getCourse());
        }
    }

    public void searchStudent(int id) {

        for (Student s : students) {

            if (s.getId() == id) {
                System.out.println("Student Found!");
                System.out.println("Name : " + s.getName());
                System.out.println("Age : " + s.getAge());
                System.out.println("Course : " + s.getCourse());
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    public void removeStudent(int id) {

        for (Student s : students) {


            if (s.getId() == id) {
                students.remove(s);
                saveStudentsToFile();
                System.out.println("Student Removed Successfully!");
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    public void updateStudent(int id, Scanner sc) {

        for (Student s : students) {

            if (s.getId() == id) {

                System.out.print("Enter New Name : ");
                String name = sc.nextLine();

                System.out.print("Enter New Age : ");
                int age = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter New Course : ");
                String course = sc.nextLine();

                s.setName(name);
                s.setAge(age);
                s.setCourse(course);

                saveStudentsToFile();

                System.out.println("Student Updated Successfully!");
                return;
            }
        }

        System.out.println("Student Not Found!");
    }

    public void saveStudentsToFile() {

        try {
 
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName));

            for (Student s : students) {
                bw.write(s.toString());
                bw.newLine();
            }

            bw.close();

        } catch (Exception e) {
            System.out.println("Error Saving File!");
        }
    }

    public void loadStudentsFromFile() {

        try {

            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }

            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;

            while ((line = br.readLine()) != null) {

                String[] data = line.split(",");

                int id = Integer.parseInt(data[0]);
                String name = data[1];
                int age = Integer.parseInt(data[2]);
                String course = data[3];

                students.add(new Student(id, name, age, course));
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Error Loading File!");
        }
    }
}