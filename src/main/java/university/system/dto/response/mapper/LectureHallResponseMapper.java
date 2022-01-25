package university.system.dto.response.mapper;

import org.springframework.stereotype.Component;
import university.system.model.LectureHall;
import university.system.dto.response.LectureHallResponseDto;

@Component
public class LectureHallResponseMapper {
    public LectureHallResponseDto toDto(LectureHall lectureHall) {
        LectureHallResponseDto responseDto = new LectureHallResponseDto();
        responseDto.setId(lectureHall.getId());
        responseDto.setCapacity(lectureHall.getCapacity());
        responseDto.setDescription(lectureHall.getDescription());
        return responseDto;
    }
}
