package university.system.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import university.system.dao.repository.LectureRepository;
import university.system.model.Lecture;
import university.system.model.Student;
import university.system.service.LectureService;

class LectureServiceImplTest {
    private static final long LECTURE_ID1 = 1L;
    private static final long LECTURE_ID2 = 2L;
    private static final long STUDENT_ID1 = 1L;
    private static final LocalDateTime LECTURE_DATE = LocalDateTime.now();
    private static final String LECTURE_NAME = "Math";
    private LectureRepository lectureRepository;
    private LectureService lectureService;
    private static Lecture expected;

    @BeforeAll
    static void beforeAll() {
        expected = new Lecture();
        expected.setId(LECTURE_ID1);
        expected.setName(LECTURE_NAME);
        expected.setLectureDate(LECTURE_DATE);
    }

    @BeforeEach
    void setUp() {
        lectureRepository = Mockito.mock(LectureRepository.class);
        lectureService = new LectureServiceImpl(lectureRepository);
    }

    @Test
    void save_Ok() {
        Lecture input = new Lecture();
        input.setName("Math");
        input.setLectureDate(LECTURE_DATE);
        Mockito.when(lectureRepository.save(input)).thenReturn(expected);
        Lecture result = lectureService.save(input);
        assertEquals(expected, result);
    }

    @Test
    void getById_Ok() {
        Mockito.when(lectureRepository.findById(LECTURE_ID1)).thenReturn(Optional.of(expected));
        Lecture result = lectureService.findById(LECTURE_ID1);
        assertEquals(expected, result);
    }

    @Test
    void getById_NotOk() {
        Mockito.when(lectureRepository.findById(LECTURE_ID1)).thenReturn(Optional.of(expected));
        try {
            lectureService.findById(LECTURE_ID2);
        } catch (RuntimeException r) {
            assertEquals("Can`t find lecture with id: " + LECTURE_ID2, r.getMessage());
            return;
        }
        fail("Expected Runtime exception");
    }

    @Test
    void findAll_Ok() {
        Mockito.when(lectureRepository.findAll()).thenReturn(List.of(expected));
        List<Lecture> result = lectureService.findAll();
        assertEquals(List.of(expected), result);
    }

    @Test
    void findByStudentIdAndDate_Ok() {
        Student student = new Student();
        student.setId(STUDENT_ID1);
        student.setFirstName("John");
        student.setLastName("Johnson");
        student.setLectures(List.of(expected));
        Mockito.when(lectureRepository
                .findLecturesByStudentIdAndDate(STUDENT_ID1, LECTURE_DATE.toLocalDate().toString()))
                .thenReturn(List.of(expected));
        List<Lecture> result = lectureService
                .findByStudentIdAndDate(STUDENT_ID1, LECTURE_DATE.toLocalDate());
        assertEquals(List.of(expected), result);
    }
}
