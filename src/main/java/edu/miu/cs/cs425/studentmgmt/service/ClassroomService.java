package edu.miu.cs.cs425.studentmgmt.service;

import edu.miu.cs.cs425.studentmgmt.model.Classroom;
import edu.miu.cs.cs425.studentmgmt.model.Student;

public interface ClassroomService {

    public Classroom addNewClassroom(Classroom newClassroom);

    Classroom saveClassroom(Classroom newClassroom);


}
