package edu.miu.cs.cs425.studentmgmt.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

@Entity
@Table (name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

//    @NotNull(message = "Student number cannot be null")
//    @NotEmpty(message = "Student number cannot be empty or null")
    @NotBlank(message = "Student number cannot be blank or empty or null")
    @Column(name="student-number", nullable = false)
    private String studentNumber;

    @NotBlank
    private String firstName;
    private String middleName;

    @NotBlank
    private String lastName;
    private double cgpa;
    private LocalDate dateOfEnrollment;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="primary_transcipt_id", nullable = true)
    private Transcript primaryTranscript;

    @ManyToOne()
    @JoinColumn(name = "classroom_id", nullable = true)
    private Classroom classroom;

    public Student(Long studentId, String studentNumber, String firstName, String middleName,String lastName,
                   Double cgpa, LocalDate dateOfEnrollment, Transcript primaryTranscript) {
        this.studentId = studentId;
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollment = dateOfEnrollment;
        this.primaryTranscript = primaryTranscript;
    }

    public Student(Long studentId, String studentNumber, String firstName, String middleName,String lastName,
                   Double cgpa, LocalDate dateOfEnrollment, Transcript primaryTranscript, Classroom classroom) {
        this.studentId = studentId;
        this.studentNumber = studentNumber;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.cgpa = cgpa;
        this.dateOfEnrollment = dateOfEnrollment;
        this.primaryTranscript = primaryTranscript;
        this.classroom = classroom;
    }

    public Student() {

    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(double cgpa) {
        this.cgpa = cgpa;
    }

    public LocalDate getDateOfEnrollment() {
        return dateOfEnrollment;
    }

    public void setDateOfEnrollment(LocalDate dateOfEnrollment) {
        this.dateOfEnrollment = dateOfEnrollment;
    }

    public Transcript getPrimaryTranscript() {
        return primaryTranscript;
    }

    public void setPrimaryTranscript(Transcript primaryTranscript) {
        this.primaryTranscript = primaryTranscript;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentNumber='" + studentNumber + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", cgpa=" + cgpa + '\'' +
                ", dateOfEnrollment=" + dateOfEnrollment + '\'' +
                ", primaryTranscript=" + primaryTranscript + '\'' +
                ", classroom=" + classroom + '\'' +
                '}';
    }

}
