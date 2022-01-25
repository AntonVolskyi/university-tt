package university.system.controller;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import university.system.dto.request.mapper.StudentListRequestDto;
import university.system.model.Group;
import university.system.model.Lecture;
import university.system.model.Student;
import university.system.dto.request.LectureRequestDto;
import university.system.dto.response.LectureResponseDto;
import university.system.service.GroupService;
import university.system.service.LectureService;
import university.system.service.StudentService;
import university.system.dto.request.mapper.LectureRequestMapper;
import university.system.dto.response.mapper.LecturerResponseMapper;

@RestController
@RequestMapping("/lectures")
@AllArgsConstructor
public class LectureController {
    private GroupService groupService;
    private StudentService studentService;
    private LectureService lectureService;
    private LectureRequestMapper lectureRequestMapper;
    private LecturerResponseMapper lecturerResponseMapper;

    @PutMapping("/add-group")
    public LectureResponseDto addStudentsFromGroup(@RequestParam Long groupId,
                                                   @RequestParam Long lectureId) {
        Group group = groupService.findById(groupId);
        Lecture lecture = lectureService.findById(lectureId);
        lecture.getStudents().addAll(group.getStudents());
        lectureService.save(lecture);
        return lecturerResponseMapper.toDto(lecture);
    }

    @PutMapping("/add-students")
    public LectureResponseDto addStudent(@RequestParam Long lectureId,
                                         @RequestBody StudentListRequestDto requestDto) {
        List<Student> students = studentService.findByIds(requestDto.getStudentsIds());
        Lecture lecture = lectureService.findById(lectureId);
        lecture.getStudents().addAll(students);
        lectureService.save(lecture);
        return lecturerResponseMapper.toDto(lecture);
    }

    @GetMapping("/{id}")
    public LectureResponseDto getById(@PathVariable Long id) {
        return lecturerResponseMapper.toDto(lectureService.findById(id));
    }

    @PostMapping
    public LectureResponseDto add(@RequestBody LectureRequestDto requestDto) {
        Lecture lecture = lectureService.save(lectureRequestMapper.toModel(requestDto));
        return lecturerResponseMapper.toDto(lecture);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        lectureService.delete(id);
    }
}
