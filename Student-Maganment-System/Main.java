import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentService service = new StudentService();

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Search Student");
            System.out.println("4. Remove Student");
            System.out.println("5. Update Student");
            System.out.println("6. Exit");

            System.out.print("Enter Choice : ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter ID : ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name : ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age : ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Course : ");
                    String course = sc.nextLine();

                    Student student = new Student(id, name, age, course);

                    service.addStudent(student);

                    break;

                case 2:

                    service.displayStudents();

                    break;

                case 3:

                    System.out.print("Enter Student ID : ");
                    int searchId = sc.nextInt();
                    service.searchStudent(searchId);
                    break;

                case 4:
                  
                    System.out.print("Enter Student ID : ");
                    int removeId = sc.nextInt();

                    service.removeStudent(removeId);

                    break;

                case 5:

                    System.out.print("Enter Student ID : ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    service.updateStudent(updateId, sc);

                    break;

                case 6:

                    System.out.println("Exiting Program...");
                    sc.close();
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice!");
            }
        }
    }
}