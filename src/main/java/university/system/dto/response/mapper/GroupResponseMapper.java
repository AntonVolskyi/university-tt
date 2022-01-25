package university.system.dto.response.mapper;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import university.system.model.Group;
import university.system.dto.response.GroupResponseDto;

@Component
public class GroupResponseMapper {
    public GroupResponseDto toDto(Group group) {
        GroupResponseDto responseDto = new GroupResponseDto();
        responseDto.setId(group.getId());
        responseDto.setGroupName(group.getGroupName());
        List<String> students = group.getStudents()
                .stream()
                .map(s -> s.getFirstName() + " " + s.getLastName())
                .collect(Collectors.toList());
        responseDto.setStudents(students);
        return responseDto;
    }
}
