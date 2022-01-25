package university.system.dto.response.mapper;

import org.springframework.stereotype.Component;
import university.system.model.Teacher;
import university.system.dto.response.TeacherResponseDto;

@Component
public class TeacherResponseMapper {
    public TeacherResponseDto toDto(Teacher teacher) {
        TeacherResponseDto responseDto = new TeacherResponseDto();
        responseDto.setId(teacher.getId());
        responseDto.setFirstName(teacher.getFirstName());
        responseDto.setLastName(teacher.getLastName());
        responseDto.setYearsOfWork(teacher.getYearsOfWork());
        return responseDto;
    }
}
