package university.system.controller;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import university.system.model.Group;
import university.system.model.Lecture;
import university.system.model.LectureHall;
import university.system.model.Student;
import university.system.model.Teacher;
import university.system.service.GroupService;
import university.system.service.LectureHallService;
import university.system.service.LectureService;
import university.system.service.StudentService;
import university.system.service.TeacherService;

@RestController
@RequestMapping("/inject-data")
public class InjectDataController {
    private Group group1;
    private Group group2;
    private Student student1;
    private Student student2;
    private Student student3;
    private Student student4;
    private Teacher teacher1;
    private Teacher teacher2;
    private Lecture lecture1;
    private Lecture lecture2;
    private Lecture lecture3;
    private Lecture lecture4;
    private Lecture lecture5;
    private Lecture lecture6;
    private LectureHall lectureHall1;
    private LectureHall lectureHall2;
    private GroupService groupService;
    private TeacherService teacherService;
    private LectureService lectureService;
    private StudentService studentService;
    private LectureHallService lectureHallService;

    public InjectDataController(GroupService groupService,
                                TeacherService teacherService,
                                LectureService lectureService,
                                StudentService studentService,
                                LectureHallService lectureHallService) {
        this.groupService = groupService;
        this.teacherService = teacherService;
        this.lectureService = lectureService;
        this.studentService = studentService;
        this.lectureHallService = lectureHallService;
    }

    @PostMapping("/all")
    public String injectAll() {
        injectTeachers();
        injectLectureHalls();
        injectStudents();
        injectLectures();
        injectGroups();
        return "All data injected";
    }

    private void injectTeachers() {
        teacher1 = new Teacher();
        teacher2 = new Teacher();
        teacher1.setFirstName("Bob");
        teacher2.setFirstName("Andrew");
        teacher1.setLastName("Kinsi");
        teacher2.setLastName("Bobkinson");
        teacher1.setYearsOfWork(3);
        teacher2.setYearsOfWork(5);
        teacherService.save(teacher1);
        teacherService.save(teacher2);
    }

    private void injectLectureHalls() {
        lectureHall1 = new LectureHall();
        lectureHall2 = new LectureHall();
        lectureHall1.setCapacity(250);
        lectureHall2.setCapacity(120);
        lectureHall1.setDescription("Big Lecture hall");
        lectureHall2.setDescription("Small lecture hall");
        lectureHallService.save(lectureHall1);
        lectureHallService.save(lectureHall2);
    }

    private void injectLectures() {
        lecture1 = new Lecture();
        lecture2 = new Lecture();
        lecture3 = new Lecture();
        lecture4 = new Lecture();
        lecture5 = new Lecture();
        lecture6 = new Lecture();
        lecture1.setName("Math");
        lecture2.setName("Physics");
        lecture3.setName("History");
        lecture4.setName("English");
        lecture5.setName("Polish");
        lecture6.setName("DB");
        lecture1.setLectureDate(LocalDateTime.now());
        lecture2.setLectureDate(LocalDateTime.now().plusHours(2L));
        lecture3.setLectureDate(LocalDateTime.now());
        lecture4.setLectureDate(LocalDateTime.now().plusDays(2));
        lecture5.setLectureDate(LocalDateTime.now().plusDays(1));
        lecture6.setLectureDate(LocalDateTime.now().plusDays(2));
        lecture1.setTeacher(teacher1);
        lecture2.setTeacher(teacher1);
        lecture3.setTeacher(teacher2);
        lecture4.setTeacher(teacher1);
        lecture5.setTeacher(teacher1);
        lecture6.setTeacher(teacher2);
        lecture1.setLectureHall(lectureHall2);
        lecture2.setLectureHall(lectureHall2);
        lecture3.setLectureHall(lectureHall1);
        lecture4.setLectureHall(lectureHall1);
        lecture5.setLectureHall(lectureHall1);
        lecture6.setLectureHall(lectureHall2);
        lecture1.setStudents(List.of(student1));
        lecture2.setStudents(List.of(student1, student3, student4));
        lecture3.setStudents(List.of(student1, student2, student3));
        lecture4.setStudents(List.of(student1, student3));
        lecture5.setStudents(List.of(student1, student2, student3));
        lecture6.setStudents(List.of(student1, student2,student4));
        lectureService.save(lecture1);
        lectureService.save(lecture2);
        lectureService.save(lecture3);
        lectureService.save(lecture4);
        lectureService.save(lecture5);
        lectureService.save(lecture6);
    }

    private void injectGroups() {
        group1 = new Group();
        group2 = new Group();
        group1.setGroupName("First group");
        group2.setGroupName("Second group");
        group1.setStudents(List.of(student1, student2));
        group2.setStudents(List.of(student3, student4));
        groupService.save(group1);
        groupService.save(group2);
    }

    private void injectStudents() {
        student1 = new Student();
        student2 = new Student();
        student3 = new Student();
        student4 = new Student();
        student1.setFirstName("John");
        student2.setFirstName("Alice");
        student3.setFirstName("Gregory");
        student4.setFirstName("Bob");
        student1.setLastName("Hopkins");
        student2.setLastName("Johnson");
        student3.setLastName("Dortson");
        student4.setLastName("Fingan");
        studentService.save(student1);
        studentService.save(student2);
        studentService.save(student3);
        studentService.save(student4);
    }
}
