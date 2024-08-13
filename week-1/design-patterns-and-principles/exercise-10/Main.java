public class Main {
    public static void main(String[] args) {
        Student model = new Student("John Doe", 123, 85.0);
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);

        controller.displayStudentDetails();

        controller.updateStudentDetails("Jane Doe", 456, 90.0);

        controller.displayStudentDetails();
    }
}

class Student {
    private String name;
    private int id;
    private double grade;

    public Student(String name, int id, double grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
}

class StudentView {
    public void displayStudentDetails(Student student) {
        System.out.println("Name: " + student.getName());
        System.out.println("ID: " + student.getId());
        System.out.println("Grade: " + student.getGrade());
    }
}

class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public void updateStudentDetails(String name, int id, double grade) {
        model.setName(name);
        model.setId(id);
        model.setGrade(grade);
    }

    public void displayStudentDetails() {
        view.displayStudentDetails(model);
    }
}


