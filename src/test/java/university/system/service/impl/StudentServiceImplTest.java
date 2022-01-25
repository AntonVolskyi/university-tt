package university.system.service.impl;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import university.system.dao.repository.StudentRepository;
import university.system.model.Student;
import university.system.model.Teacher;
import university.system.service.StudentService;

class StudentServiceImplTest {
    private static final long ID1 = 1L;
    private static final long ID2 = 2L;
    private static final long ID3 = 3L;
    private static Student firstExpected;
    private static Student secondExpected;
    private StudentRepository studentRepository;
    private StudentService studentService;

    @BeforeAll
    static void beforeAll() {
        firstExpected = new Student();
        firstExpected.setId(ID1);
        firstExpected.setFirstName("Alice");
        firstExpected.setLastName("Hopkins");
        secondExpected = new Student();
        secondExpected.setId(ID2);
        secondExpected.setFirstName("Bob");
        secondExpected.setLastName("Dolphin");
    }

    @BeforeEach
    void setUp() {
        studentRepository = Mockito.mock(StudentRepository.class);
        studentService = new StudentServiceImpl(studentRepository);
    }

    @Test
    void save_Ok() {
        Student input = new Student();
        input.setFirstName("Alice");
        input.setLastName("Hopkins");
        Mockito.when(studentRepository.save(input)).thenReturn(firstExpected);
        Student result = studentService.save(input);
        assertEquals(firstExpected, result);
    }

    @Test
    void findById_NotOk() {
        Mockito.when(studentRepository.findById(ID1)).thenReturn(Optional.of(firstExpected));
        Mockito.when(studentRepository.findById(ID2)).thenReturn(Optional.of(secondExpected));
        try {
            studentService.findById(ID3);
        } catch (RuntimeException r) {
            assertEquals("Can`t find student with id: " + ID3, r.getMessage());
            return;
        }
        fail("Expected Runtime Exception");
    }

    @Test
    void findById_Ok() {
        Mockito.when(studentRepository.findById(ID1)).thenReturn(Optional.of(firstExpected));
        Student result = studentService.findById(ID1);
        assertEquals(firstExpected, result);
    }

    @Test
    void findByIds_Ok() {
        Mockito.when(studentRepository.findStudentsByIdIn(List.of(ID1, ID2)))
                .thenReturn(List.of(firstExpected, secondExpected));
        List<Student> result = studentService.findByIds(List.of(ID1, ID2));
        assertEquals(List.of(firstExpected, secondExpected).size(), result.size());
        assertEquals(List.of(firstExpected, secondExpected), result);
    }

    @Test
    void findAll_Ok() {
        Mockito.when(studentRepository.findAll()).thenReturn(List.of(firstExpected, secondExpected));
        List<Student> result = studentService.findAll();
        assertEquals(List.of(firstExpected, secondExpected), result);
    }
}
