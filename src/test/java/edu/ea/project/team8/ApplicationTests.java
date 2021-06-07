package edu.ea.project.team8;

import edu.ea.project.team8.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class ApplicationTests {
    @Autowired
    private BarCodeRecordService barCodeRecordService;
    @Autowired
    private ClassSessionService classSessionService;
    @Autowired
    private CourseOfferingService courseOfferingService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private PersonService personService;
    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TimeslotService timeSlotService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private FacultyService facultyService;

    /*
    * A collection of sanity tests.
    * */
    @Test
    void contextLoads() {
        assertThat(barCodeRecordService).isNotNull();
        assertThat(classSessionService).isNotNull();
        assertThat(courseOfferingService).isNotNull();
        assertThat(courseService).isNotNull();
        assertThat(locationService).isNotNull();
        assertThat(personService).isNotNull();
        assertThat(registrationService).isNotNull();
        assertThat(studentService).isNotNull();
        assertThat(timeSlotService).isNotNull();
        assertThat(userService).isNotNull();
        assertThat(roleService).isNotNull();
        assertThat(facultyService).isNotNull();
    }

}
