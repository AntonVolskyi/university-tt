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
import university.system.model.LectureHall;
import university.system.dto.request.LectureHallRequestDto;
import university.system.dto.response.LectureHallResponseDto;
import university.system.service.LectureHallService;
import university.system.dto.request.mapper.LectureHallRequestMapper;
import university.system.dto.response.mapper.LectureHallResponseMapper;

@RestController
@RequestMapping("/lecture-halls")
@AllArgsConstructor
public class LectureHallController {
    private LectureHallService lectureHallService;
    private LectureHallRequestMapper lectureHallRequestMapper;
    private LectureHallResponseMapper lectureHallResponseMapper;

    @PutMapping("/{id}")
    public LectureHallResponseDto update(@PathVariable Long id,
                                         @RequestBody LectureHallRequestDto requestDto) {
        LectureHall lectureHall = lectureHallRequestMapper.toModel(requestDto);
        lectureHall.setId(id);
        lectureHallService.save(lectureHall);
        return lectureHallResponseMapper.toDto(lectureHall);
    }

    @GetMapping("/{id}")
    public LectureHallResponseDto getById(@PathVariable Long id) {
        return lectureHallResponseMapper.toDto(lectureHallService.findById(id));
    }

    @PostMapping
    public LectureHallResponseDto add(@RequestBody LectureHallRequestDto requestDto) {
        LectureHall lectureHall = lectureHallService.save(lectureHallRequestMapper.toModel(requestDto));
        return lectureHallResponseMapper.toDto(lectureHall);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        lectureHallService.delete(id);
    }
}
