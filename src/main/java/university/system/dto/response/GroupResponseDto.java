package university.system.dto.response;

import java.util.List;
import lombok.Data;

@Data
public class GroupResponseDto {
    private Long id;
    private String groupName;
    private List<String> students;
}
