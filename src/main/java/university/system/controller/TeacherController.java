package university.system.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import university.system.model.Teacher;
import university.system.dto.request.TeacherRequestDto;
import university.system.dto.response.TeacherResponseDto;
import university.system.service.TeacherService;
import university.system.dto.request.mapper.TeacherRequestMapper;
import university.system.dto.response.mapper.TeacherResponseMapper;

@RestController
@RequestMapping("/teachers")
@AllArgsConstructor
public class TeacherController {
    private TeacherService teacherService;
    private TeacherRequestMapper teacherRequestMapper;
    private TeacherResponseMapper teacherResponseMapper;

    @PutMapping("/{id}")
    public TeacherResponseDto update(@PathVariable Long id,
                                            @RequestBody TeacherRequestDto requestDto) {
        Teacher teacher = teacherRequestMapper.toModel(requestDto);
        teacher.setId(id);
        teacherService.save(teacher);
        return teacherResponseMapper.toDto(teacher);
    }

    @GetMapping("/{id}")
    public TeacherResponseDto getById(@PathVariable Long id) {
        return teacherResponseMapper.toDto(teacherService.findById(id));
    }

    @PostMapping
    public TeacherResponseDto add(@RequestBody TeacherRequestDto requestDto) {
        Teacher teacher = teacherService.save(teacherRequestMapper.toModel(requestDto));
        return teacherResponseMapper.toDto(teacher);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        teacherService.delete(id);
    }
}
