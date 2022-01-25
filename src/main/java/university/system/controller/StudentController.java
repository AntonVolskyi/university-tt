package university.system.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import university.system.dto.response.LectureResponseDto;
import university.system.dto.response.mapper.LecturerResponseMapper;
import university.system.model.Student;
import university.system.dto.request.StudentRequestDto;
import university.system.dto.response.StudentResponseDto;
import university.system.service.LectureService;
import university.system.service.StudentService;
import university.system.dto.request.mapper.StudentRequestMapper;
import university.system.dto.response.mapper.StudentResponseMapper;

@RestController
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {
    private StudentService studentService;
    private LectureService lectureService;
    private StudentRequestMapper studentRequestMapper;
    private StudentResponseMapper studentResponseMapper;
    private LecturerResponseMapper lecturerResponseMapper;

    @PutMapping("/{id}")
    public StudentResponseDto update(@PathVariable Long id,
                                     @RequestBody StudentRequestDto requestDto) {
        Student student = studentRequestMapper.toModel(requestDto);
        student.setId(id);
        studentService.save(student);
        return studentResponseMapper.toDto(student);
    }

    @GetMapping()
    public List<LectureResponseDto> getByIdAndDate(@RequestParam Long studentId,
                                            @RequestParam
                                      @DateTimeFormat(pattern = "yyyy-MM-dd")
                                              LocalDate lectureDate) {
        return lectureService.findByStudentIdAndDate(studentId, lectureDate)
                .stream()
                .map(lecturerResponseMapper::toDto)
                .collect(Collectors.toList());
    }

    @PostMapping
    public StudentResponseDto add(@RequestBody StudentRequestDto requestDto) {
        Student student = studentService.save(studentRequestMapper.toModel(requestDto));
        return studentResponseMapper.toDto(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }
}
