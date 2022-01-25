package university.system.dto.request.mapper;

import java.util.List;
import lombok.Data;

@Data
public class StudentListRequestDto {
    private List<Long> studentsIds;
}
