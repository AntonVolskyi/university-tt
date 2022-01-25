package university.system.dto.request;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class LectureRequestDto {
    private LocalDateTime lectureDate;
    private Long teacherId;
    private String name;
    private Long lectureHallId;
}
