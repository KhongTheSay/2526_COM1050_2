package TranDucManh_25020258_Week8.Bai06.src;

class StudentManager {
    public  Infor studentInfo;
    public void printStudentInfo(Infor student  ) {
        student.showInfor();
}
}
class calGrade{
    private double midtermScore;
    private double finalScore;
    private double assignmentScore;
    public double total = 0;
    public double calculateFinalGrade() {
        total =  assignmentScore * 0.2 + midtermScore * 0.3 + finalScore * 0.5;
        return total ;
    }  
}
class getHL{
    public String getAcademicStatus(double grade ) {
        if (grade >= 8.5) return "Giỏi";
        if (grade >= 7.0) return "Khá";
        if (grade >= 5.5) return "Trung bình";
        return "Yếu";
    }
}
class Infor{
    private String studentId;
    private String name;
    private String courseId;
    private String courseName;
    private double midtermScore;
    private double finalScore;
    private double assignmentScore;
    private int credits;
    public getHL hl = new getHL();
    public calGrade grade = new calGrade();
    public Infor (String studentId, String name, String courseId, String courseName, double midtermScore, double finalScore, double assignmentScore, int credits) {
        this.studentId = studentId;
        this.name = name;
        this.courseId = courseId;
        this.courseName = courseName;
        this.midtermScore = midtermScore;
        this.finalScore = finalScore;
        this.assignmentScore = assignmentScore;
        this.credits = credits;
    }
    public void showInfor(){
        System.out.println("Sinh viên: " + name + " (" + studentId + ")");
        System.out.println("Môn học: " + courseName + " (" + courseId + ") - " + credits + " tín chỉ");
        System.out.println("Điểm GK: " + midtermScore + " | Điểm CK: " + finalScore + " | Điểm BT: " + assignmentScore);
        System.out.printf("Điểm tổng kết: %.1f - Học lực: %s%n", grade.calculateFinalGrade(), hl.getAcademicStatus(grade.total));
    }

}

public class chap6 {
    public static void main(String[] args) {
        Infor sv1 = new Infor("25020258", "Trần Đức Mạnh", "INT2204", "OOP", 8.0, 9.0, 8.5, 3);
        StudentManager manager = new StudentManager();
        System.out.println("--- KẾT QUẢ HỌC TẬP ---");
        manager.printStudentInfo(sv1);
    }
}
