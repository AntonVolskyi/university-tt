package university.system.dto.request.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import university.system.model.Lecture;
import university.system.dto.request.LectureRequestDto;
import university.system.service.LectureHallService;
import university.system.service.TeacherService;

@Component
@AllArgsConstructor
public class LectureRequestMapper {
    private TeacherService teacherService;
    private LectureHallService lectureHallService;

    public Lecture toModel(LectureRequestDto requestDto) {
        Lecture lecture = new Lecture();
        lecture.setLectureDate(requestDto.getLectureDate());
        lecture.setTeacher(teacherService.findById(requestDto.getTeacherId()));
        lecture.setName(requestDto.getName());
        lecture.setLectureHall(lectureHallService.findById(requestDto.getLectureHallId()));
        return lecture;
    }
}
