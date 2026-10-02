import java.util.*;

class Student {
    int roll;
    String name;
    double marks;

    
    Student(int roll, String name, double marks) {
        this.roll = roll;
        this.name = name;
        this.marks = marks;
    }

    
    Student(Student s) {
        this.roll = s.roll;
        this.name = s.name;
        this.marks = s.marks;
    }

    String getGrade() {
        if (marks >= 90) return "A+";
        else if (marks >= 80) return "A";
        else if (marks >= 60) return "B";
        else if (marks >= 40) return "C";
        else return "Fail";
    }

    void display() {
        System.out.println("Roll: " + roll + " | Name: " + name + " | Marks: " + marks + " | Grade: " + getGrade());
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();
        
        
        list.add(new Student(1, "Aman", 85));
        list.add(new Student(2, "Sneha", 92));

        int choice;
        do {
            System.out.println("\n--- STUDENT MENU ---");
            System.out.println("1. Add Student");
            System.out.println("2. Show All");
            System.out.println("3. Search by Roll");
            System.out.println("4. Copy Student (Copy Constructor Demo)");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Roll: ");
                    int r = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String n = sc.nextLine();
                    System.out.print("Marks: ");
                    double m = sc.nextDouble();
                    list.add(new Student(r, n, m));
                    System.out.println("Added!");
                    break;

                case 2:
                    if(list.isEmpty()) System.out.println("No students!");
                    else for(Student s : list) s.display();
                    break;

                case 3:
                    System.out.print("Enter roll to search: ");
                    int searchRoll = sc.nextInt();
                    boolean found = false;
                    for(Student s : list) {
                        if(s.roll == searchRoll) {
                            s.display();
                            found = true;
                        }
                    }
                    if(!found) System.out.println("Not Found!");
                    break;

                case 4:
                    if(list.size() > 0) {
                        Student original = list.get(0);
                        Student copied = new Student(original); // copy constructor
                        System.out.println("Original:");
                        original.display();
                        System.out.println("Copied:");
                        copied.display();
                    }
                    break;
            }
        } while (choice != 5);
        sc.close();
    }
}