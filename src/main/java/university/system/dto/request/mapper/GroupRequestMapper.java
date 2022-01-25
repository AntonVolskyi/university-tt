package university.system.dto.request.mapper;

import org.springframework.stereotype.Component;
import university.system.model.Group;
import university.system.dto.request.GroupRequestDto;

@Component
public class GroupRequestMapper {
    public Group toModel(GroupRequestDto requestDto) {
        Group group = new Group();
        group.setGroupName(requestDto.getGroupName());
        return group;
    }
}
