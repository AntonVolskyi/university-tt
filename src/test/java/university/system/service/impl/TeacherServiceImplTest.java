package university.system.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import university.system.dao.repository.TeacherRepository;
import university.system.model.Teacher;

class TeacherServiceImplTest {
    private static final long ID1 = 1L;
    private static final long ID2 = 2L;
    private static Teacher expected;
    private TeacherServiceImpl teacherService;
    private TeacherRepository teacherRepository;

    @BeforeAll
    static void beforeAll() {
        expected = new Teacher();
        expected.setId(ID1);
        expected.setFirstName("John");
        expected.setLastName("Johnson");
        expected.setYearsOfWork(15);
    }

    @BeforeEach
    void setUp() {
        teacherRepository = Mockito.mock(TeacherRepository.class);
        teacherService = new TeacherServiceImpl(teacherRepository);
    }

    @Test
    void save_Ok() {
        Teacher input = new Teacher();
        input.setFirstName("John");
        input.setLastName("Johnson");
        input.setYearsOfWork(15);
        Mockito.when(teacherRepository.save(input)).thenReturn(expected);
        Teacher result = teacherService.save(input);
        assertEquals(expected, result);
    }

    @Test
    void findById_NotOk() {
        Mockito.when(teacherRepository.findById(ID1)).thenReturn(Optional.of(expected));
        try {
            teacherService.findById(ID2);
        } catch (RuntimeException r) {
            assertEquals("Can`t find teacher with id: " + ID2, r.getMessage());
            return;
        }
        fail("Expected Runtime Exception");
    }

    @Test
    void findById_Ok() {
        Mockito.when(teacherRepository.findById(ID1)).thenReturn(Optional.of(expected));
        Teacher result = teacherService.findById(ID1);
        assertEquals(expected, result);
    }

    @Test
    void findAll_Ok() {
        Mockito.when(teacherRepository.findAll()).thenReturn(List.of(expected));
        List<Teacher> result = teacherService.findAll();
        assertEquals(List.of(expected), result);
    }
}
