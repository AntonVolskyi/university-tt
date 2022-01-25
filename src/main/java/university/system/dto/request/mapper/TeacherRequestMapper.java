package university.system.dto.request.mapper;

import org.springframework.stereotype.Component;
import university.system.model.Teacher;
import university.system.dto.request.TeacherRequestDto;

@Component
public class TeacherRequestMapper {
    public Teacher toModel(TeacherRequestDto requestDto) {
        Teacher teacher = new Teacher();
        teacher.setFirstName(requestDto.getFirstName());
        teacher.setLastName(requestDto.getLastName());
        teacher.setYearsOfWork(requestDto.getYearsOfWork());
        return teacher;
    }
}
