package university.system.dto.response.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import university.system.model.Lecture;
import university.system.model.Teacher;
import university.system.dto.response.LectureResponseDto;

@Component
@AllArgsConstructor
public class LecturerResponseMapper {
    public LectureResponseDto toDto(Lecture lecture) {
        LectureResponseDto responseDto = new LectureResponseDto();
        responseDto.setId(lecture.getId());
        responseDto.setLectureDate(lecture.getLectureDate());
        Teacher teacher = lecture.getTeacher();
        responseDto.setTeacherName(teacher.getFirstName() + " " + teacher.getLastName());
        responseDto.setName(lecture.getName());
        responseDto.setLectureHallId(lecture.getLectureHall().getId());
        return responseDto;
    }
}
