package university.system.dto.response.mapper;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import university.system.model.Lecture;
import university.system.model.Student;
import university.system.dto.response.StudentResponseDto;

@Component
public class StudentResponseMapper {
    public StudentResponseDto toDto(Student student) {
        StudentResponseDto studentResponseDto = new StudentResponseDto();
        studentResponseDto.setId(student.getId());
        studentResponseDto.setFirstName(student.getFirstName());
        studentResponseDto.setLastName(student.getLastName());
        List<String> collect = student.getLectures()
                .stream()
                .map(this::parseLecture)
                .collect(Collectors.toList());
        studentResponseDto.setLectures(collect);
        return studentResponseDto;
    }

    private String parseLecture(Lecture lecture) {
        StringBuilder sb = new StringBuilder();
        sb.append(lecture.getName()).append(", ");
        sb.append(lecture.getLectureDate()).append(", ");
        sb.append(lecture.getTeacher().getFirstName()).append(" ")
                .append(lecture.getTeacher().getLastName()).append(", ");
        sb.append(lecture.getLectureHall().getId());
        return sb.toString();
    }
}
