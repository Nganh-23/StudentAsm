package ASM;

import ASM.Student;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.ArrayList;

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
        System.out.println("Student added successfully.");
    }

    // Edit student information by ID
    // Sửa thông tin sinh viên theo mã
    public void editStudent(String id, String newName, double newMarks) {
        for (Student student : students) {
            if (student.getId().equals(id)) {
                student.setName(newName);
                student.setMarks(newMarks);
                System.out.println("Student updated successfully.");
                return;
            }
        }
        System.out.println("Student with ID: " + id + " not found.");
    }

    // Delete a student from the list
    public void deleteStudent(String id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(id)) {
                students.remove(i);
                System.out.println("Student deleted successfully.");
                // Điều chỉnh chỉ số sau khi xóa
                i--;
                return;
            }
        }
        System.out.println("Student with ID: " + id + " not found.");
    }

    // Search for a student by ID
    // Tìm kiếm sinh viên theo mã
    public Student searchById(String id) {
        for (Student student : students) { // Duyệt qua danh sách sinh viên
            if (id.equals(student.getId())) { // So sánh mã sinh viên
                return student; // Trả về sinh viên nếu tìm thấy
            }
        }
        return null; // Trả về null nếu không tìm thấy
    }


    // Sắp xếp sinh viên theo điểm từ cao đến thấp bằng thuật toán Insertion Sort
    // Sort students by marks in descending order using Insertion Sort
    public void sortStudentsByMarks() {
        for (int i = 1; i < students.size(); i++) {
            Student key = students.get(i);
            int j = i - 1;


            while (j >= 0 && students.get(j).getMarks() < key.getMarks()) {
                students.set(j + 1, students.get(j));
                j = j - 1;
            }
            students.set(j + 1, key);
        }
        System.out.println("Students sorted by marks in descending order.");
    }

    // Display the entire list of students
    // Hiển thị toàn bộ danh sách sinh viên
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }
}
