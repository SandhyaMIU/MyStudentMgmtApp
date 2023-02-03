package edu.miu.cs.cs425.studentmgmt;

import edu.miu.cs.cs425.studentmgmt.model.Classroom;
import edu.miu.cs.cs425.studentmgmt.model.Student;
import edu.miu.cs.cs425.studentmgmt.model.Transcript;
import edu.miu.cs.cs425.studentmgmt.service.ClassroomService;
import edu.miu.cs.cs425.studentmgmt.service.StudentService;
import edu.miu.cs.cs425.studentmgmt.service.TranscriptService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

@SpringBootApplication
public class MyStudentMgmtAppApplication implements CommandLineRunner {

    @Autowired
    private StudentService studentService;

    @Autowired
    private TranscriptService transcriptService;

    @Autowired
    private ClassroomService classroomService;

    public static void main(String[] args) {
        SpringApplication.run(MyStudentMgmtAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sprint Boot version 3.0.2");
        System.out.println("Starting StudentManagementApp....");

        //Create 1 new student

        /*Student anna = new Student(null, "000-61-0001","Anna" , "Lynn", "Smith", 3.45 , LocalDate.of(2019, 05, 24));
        studentService.saveStudent(anna);
        Iterable<Student> students = studentService.getAllStudents();

        for(Student student: students) {
            System.out.println(student.toString());
        }*/

        //CREATE Students
        var anna = new Student(null, "000-61-0001","Anna" , "Lynn", "Smith", 3.45 , LocalDate.of(2019, 05, 24), null);
        var david = new Student(null, "000-61-0002","David" , "Hoid", "Wesley", 3.20 , LocalDate.of(2021, 01, 03), null);
        var sandhya = new Student(null, "000-61-0003","Sandhya" , " ", "Gupta", 3.80 , LocalDate.of(2022, 03, 18), null);

        var savedAnna = saveNewStudent(anna);
        var savedDavid = saveNewStudent(david);
        var savedSandhya = saveNewStudent(sandhya);

        //READ Students
        var students = getAllStudents();
        students.forEach(System.out::println);

        //Find Student by Id
        Long studentId = 2L;
        var student = getStudentById(studentId);
        if (student != null){
            System.out.printf("Student with Id %d is: %s", studentId,student);
        } else {
            System.out.printf("Student with Id %d is not found: %s", studentId,student);
        }

        //Update Student By Id
        /*var updatedStudent = updateStudent(studentId);
        System.out.println("Hello" + updatedStudent);
        if(updatedStudent != null){
            System.out.printf("Student with Id %d is updated: %s", studentId, student);
        } else {
            System.out.printf("Student with Id %d doesn't exit:", studentId);
        }*/

        //Create Transcript
        /*Transcript tr1 = new Transcript(null, "BS Computer Science",null);
        Transcript tr2 = new Transcript(null,"MS Computer Science",null);
        Transcript tr3 = new Transcript(null,"BS Mathematics",null);*/

        //Add Transcript
        var davidTranscript = new Transcript(null,"BS Computer Science",null);
        var savedDavidTranscript = transcriptService.addNewTranscript(davidTranscript);
        var davidData = getStudentById(studentId);
        davidData.setPrimaryTranscript(savedDavidTranscript);
        studentService.updateStudentById(studentId,davidData);

        //Create classrooms
        // Create 3 new classrooms
        Classroom cr1 = new Classroom(null, "McLaughlin building", "M105", null);
        Classroom cr2 = new Classroom(null, "Verrill Hall", "V29", null);
        Classroom cr3 = new Classroom(null, "Dreier Building", "#3", null);

        Classroom[] classrooms = {cr1, cr2, cr3};
        createClassrooms(classrooms);

        davidData.setClassroom(cr1);
        studentService.updateStudentById(studentId,davidData);




        System.out.println("StudentManagementApp completed....");
    }

    //CRUD Operations

//    CREATE new student
    private Student saveNewStudent(Student newStudent){
        return studentService.saveStudent(newStudent);
    }

    //READ - getAllStudents
    private Iterable<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    //Find Student by Id
    private Student getStudentById(Long studentId){
        return studentService.getStudentById(studentId).orElse(null);
    }

    //Update Student by Id
    private Student updateStudent(Long studentId){
        var stu = studentService.getStudentById(studentId);
        if(stu.isPresent()){
            var david = stu.get();
            david.setMiddleName("Keith");
            return studentService.updateStudentById(studentId, david);
        } else {
            return null;
        }

    }

    private void createClassrooms(Classroom[] classrooms) {
        for(Classroom cr : classrooms) {
            classroomService.saveClassroom(cr);
        }
    }

}
