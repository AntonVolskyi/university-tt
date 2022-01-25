package university.system.dto.request.mapper;

import org.springframework.stereotype.Component;
import university.system.model.LectureHall;
import university.system.dto.request.LectureHallRequestDto;

@Component
public class LectureHallRequestMapper {
    public LectureHall toModel(LectureHallRequestDto requestDto) {
        LectureHall lectureHall = new LectureHall();
        lectureHall.setCapacity(requestDto.getCapacity());
        lectureHall.setDescription(requestDto.getDescription());
        return lectureHall;
    }
}
