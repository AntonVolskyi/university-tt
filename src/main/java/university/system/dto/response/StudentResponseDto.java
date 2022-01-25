package university.system.dto.response;

import java.util.List;
import lombok.Data;

@Data
public class StudentResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private List<String> lectures;
}
