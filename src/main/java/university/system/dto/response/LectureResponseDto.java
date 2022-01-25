package university.system.dto.response;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class LectureResponseDto {
    private Long id;
    private LocalDateTime lectureDate;
    private String teacherName;
    private String name;
    private Long lectureHallId;
}
