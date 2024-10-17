package ASM;

import ASM.Student;

import java.util.ArrayList;
import java.util.Comparator;


// Class StudentManager manages the student list and operations on students
// Lớp StudentManager quản lý danh sách sinh viên và các thao tác với sinh viên
public class StudentManager {
    private ArrayList<Student> students;

    public StudentManager() {
        students = new ArrayList<>();
    }

    // Add a student to the list
    // Thêm sinh viên vào danh sách
    public void addStudent(Student student) {
        students.add(student);
    }

    // Edit student information by ID
    // Sửa thông tin sinh viên theo mã
    public void editStudent(String id, String newName, double newMarks) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                student.setName(newName);
                student.setMarks(newMarks);
                return;
            }
        }
        System.out.println("Student with ID: " + id + " not found.");
    }

    // Delete a student from the list
    // Xóa sinh viên khỏi danh sách
    public void deleteStudent(String id) {
        students.removeIf(student -> student.getId().equals(id));
    }

    // Search for a student by ID
    // Tìm kiếm sinh viên theo mã
    public Student searchStudent(String id) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                return student;
            }
        }
        return null;
    }

    // Sort students by marks in descending order
    // Sắp xếp sinh viên theo điểm từ cao đến thấp
    public void sortStudentsByMarks() {
        students.sort(Comparator.comparingDouble(Student::getMarks).reversed());
    }

    // Display the entire list of students
    // Hiển thị toàn bộ danh sách sinh viên
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("Student list is empty.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}