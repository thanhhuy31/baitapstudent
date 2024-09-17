package Assignment1;
import Assignment2.Student;
import Assignment2.StudentList;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Processor {
    public static void main(String[] args) {
        StudentList studentList = new StudentList();
        try (Scanner scanner = new Scanner(System.in)) {
            boolean exit = false;
            
        
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            
            while (!exit) {
                System.out.println("Choose an option:");
                System.out.println("1. Add a new student");
                System.out.println("2. Update a student by id");
                System.out.println("3. Delete a student by id");
                System.out.println("4. Display all students");
                System.out.println("5. Find the student with the highest GPA");
                System.out.println("6. Exit");
                int choice = scanner.nextInt();
                scanner.nextLine(); 
                
                switch (choice) {
                    case 1 -> {
                       
                        System.out.println("Enter ID:");
                        String id = scanner.nextLine();
                        System.out.println("Enter Full Name:");
                        String fullName = scanner.nextLine();
                        System.out.println("Enter Date of Birth (dd/MM/yyyy):");
                        String dob = scanner.nextLine();
                        System.out.println("Enter GPA:");
                        float gpa = scanner.nextFloat();
                        scanner.nextLine(); // Consume newline
                        System.out.println("Enter Major:");
                        String major = scanner.nextLine();
                        
                        try {
                           
                            Date dateOfBirth = dateFormat.parse(dob);
                            
                           
                            Student student = new Student(id, fullName, dateOfBirth, gpa, major);
                            studentList.addStudent(student);
                            
                        } catch (ParseException e) {
                            System.out.println("Invalid date format. Please enter the date in dd/MM/yyyy format.");
                        }
                    }
                        
                    case 2 -> {
                        
                        System.out.println("Enter ID of student to update:");
                        String updateId = scanner.nextLine();
                        System.out.println("Enter new Full Name:");
                        String newFullName = scanner.nextLine();
                        System.out.println("Enter new Date of Birth (dd/MM/yyyy):");
                        String newDob = scanner.nextLine();
                        System.out.println("Enter new GPA:");
                        float newGpa = scanner.nextFloat();
                        scanner.nextLine(); 
                        System.out.println("Enter new Major:");
                        String newMajor = scanner.nextLine();
                        
                        try {
                            
                            Date newDateOfBirth = dateFormat.parse(newDob);
                            
                           
                            Student updatedStudent = new Student(updateId, newFullName, newDateOfBirth, newGpa, newMajor);
                            studentList.updateStudentById(updateId, updatedStudent);
                            
                        } catch (ParseException e) {
                            System.out.println("Invalid date format. Please enter the date in dd/MM/yyyy format.");
                        }
                    }
                        
                    case 3 -> {
                      
                        System.out.println("Enter ID of student to delete:");
                        String deleteId = scanner.nextLine();
                        studentList.deleteStudentById(deleteId);
                    }
                        
                    case 4 -> 
                        studentList.displayAllStudents();
                        
                    case 5 -> {
                       
                        Student topStudent = studentList.findTopStudent();
                        if (topStudent != null) {
                            System.out.println("Top student is:");
                            topStudent.displayInfo();
                        } else {
                            System.out.println("No students found.");
                        }
                    }
                        
                    case 6 -> // Exit
                        exit = true;
                        
                    default -> System.out.println("Invalid option.");
                }
            }
        }
    }
}
