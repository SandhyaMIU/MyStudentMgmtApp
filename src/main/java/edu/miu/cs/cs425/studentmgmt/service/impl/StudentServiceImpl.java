package edu.miu.cs.cs425.studentmgmt.service.impl;

import edu.miu.cs.cs425.studentmgmt.model.Student;
import edu.miu.cs.cs425.studentmgmt.repository.StudentRepository;
import edu.miu.cs.cs425.studentmgmt.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student saveStudent(Student newStudent) {
        return studentRepository.save(newStudent);
    }

    @Override
    public Iterable<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    @Override
    public Student updateStudentById(Long studentId, Student editedStudent) {

        var theStudent = studentRepository.findById(studentId).orElse(null);
        Student updatedStudent = null;
        if(theStudent != null){
            theStudent.setMiddleName(editedStudent.getMiddleName());
            theStudent.setFirstName(editedStudent.getFirstName());
            theStudent.setPrimaryTranscript(editedStudent.getPrimaryTranscript());
            theStudent.setClassroom(editedStudent.getClassroom());
            updatedStudent = studentRepository.save(theStudent);
        }
        return updatedStudent;
    }


    @Override
    public void deleteStudentById(Long studentId) {

    }
}
