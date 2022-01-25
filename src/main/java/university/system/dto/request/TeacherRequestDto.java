package university.system.dto.request;

import lombok.Data;

@Data
public class TeacherRequestDto {
    private String firstName;
    private String lastName;
    private Integer yearsOfWork;
}
