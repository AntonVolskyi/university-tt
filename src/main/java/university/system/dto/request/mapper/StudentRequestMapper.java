package university.system.dto.request.mapper;

import org.springframework.stereotype.Component;
import university.system.model.Student;
import university.system.dto.request.StudentRequestDto;

@Component
public class StudentRequestMapper {
    public Student toModel(StudentRequestDto requestDto) {
        Student student = new Student();
        student.setFirstName(requestDto.getFirstName());
        student.setLastName(requestDto.getLastName());
        return student;
    }
}
