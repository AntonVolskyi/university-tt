package university.system.dto.response;

import lombok.Data;

@Data
public class TeacherResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Integer yearsOfWork;
}
