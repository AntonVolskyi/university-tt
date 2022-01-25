package university.system.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import university.system.model.Group;
import university.system.model.Student;
import university.system.dto.request.GroupRequestDto;
import university.system.dto.response.GroupResponseDto;
import university.system.service.GroupService;
import university.system.service.StudentService;
import university.system.dto.request.mapper.GroupRequestMapper;
import university.system.dto.request.mapper.StudentListRequestDto;
import university.system.dto.response.mapper.GroupResponseMapper;

@RestController
@RequestMapping("/groups")
@AllArgsConstructor
public class GroupController {
    private GroupService groupService;
    private StudentService studentService;
    private GroupRequestMapper groupRequestMapper;
    private GroupResponseMapper groupResponseMapper;

    @PutMapping("/add-students")
    public GroupResponseDto addStudentsToGroup(@RequestParam Long groupId,
                                               @RequestBody StudentListRequestDto requestDto) {
        List<Student> students = studentService.findByIds(requestDto.getStudentsIds());
        Group group = groupService.findById(groupId);
        group.getStudents().addAll(students);
        groupService.save(group);
        return groupResponseMapper.toDto(group);
    }

    @GetMapping("/{id}")
    public GroupResponseDto getById(@PathVariable Long id) {
        return groupResponseMapper.toDto(groupService.findById(id));
    }

    @PostMapping
    public GroupResponseDto add(@RequestBody GroupRequestDto requestDto){
        Group group = groupService.save(groupRequestMapper.toModel(requestDto));
        return groupResponseMapper.toDto(group);
    }
}
