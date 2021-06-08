package edu.ea.project.team8.util;

import edu.ea.project.team8.domain.*;
import edu.ea.project.team8.repository.*;
import edu.ea.project.team8.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Qualifier("courseRepository")
    @Autowired
    CourseRepository courseRepository;

    @Qualifier("roleRepository")
    @Autowired
    RoleRepository roleRepository;

    @Qualifier("locationRepository")
    @Autowired
    LocationRepository locationRepository;

    @Qualifier("timeslotRepository")
    @Autowired
    TimeslotRepository timeslotRepository;

    @Qualifier("faculityRepository")
    @Autowired
    FacultyRepository facultyRepository;

    @Qualifier("studentRepository")
    @Autowired
    StudentRepository studentRepository;

    @Qualifier("courseOfferingRepository")
    @Autowired
    CourseOfferingRepository courseOfferingRepository;

    @Autowired
    PersonService personService;

    @Override
    public void run(String... args) throws RuntimeException {

        createRoles();
        createLocations();
        createCourses();
        createTimeslots();
        createFaculties();
        createStudents();
        creatCourseOffering();
        createUsers();

    }

    private void createUsers() {
        //  String username, String passwordHash, String firstName, String lastName, String emailAddress
        List<Role> roles = roleRepository.findAll();
        Person admin = new Person("admin", "admin", "Admin", "Admin", "Admin@miu");
        admin.addRole(roles.get(0));
        System.out.println(admin);
        personService.addPerson(admin);
        Person faculty = new Person("faculty", "faculty", "Faculty", "Faculty", "Faculty@miu.edu");
        faculty.addRole(roles.get(2));
        faculty.addRole(roles.get(3));
        personService.addPerson(faculty);
        Person student = new Person("student", "student", "Student", "Student", "Student@miu.edu");
        student.addRole(roles.get(1));
        personService.addPerson(student);
    }

    private void creatCourseOffering() {
        //  Course course, String period, LocalDate beginDate, LocalDate endDate, int capacity, Faculty faculty
        List<Course> courses = courseRepository.findAll();
        List<Faculty> faculties = facultyRepository.findAll();
        CourseOffering febOffering = courses.get(0).createOffering("Spring", LocalDate.of(2021, Month.FEBRUARY, 1), LocalDate.of(2021, Month.FEBRUARY, 27), 30, faculties.get(0));
        CourseOffering aprilOffering = courses.get(1).createOffering("Spring", LocalDate.of(2021, Month.FEBRUARY, 1), LocalDate.of(2021, Month.FEBRUARY, 27), 30, faculties.get(1));
        CourseOffering mayOffering = courses.get(2).createOffering("Spring", LocalDate.of(2021, Month.FEBRUARY, 1), LocalDate.of(2021, Month.FEBRUARY, 27), 30, faculties.get(2));
        CourseOffering juneOffering = courses.get(3).createOffering("Spring", LocalDate.of(2021, Month.FEBRUARY, 1), LocalDate.of(2021, Month.FEBRUARY, 27), 30, faculties.get(3));

        courseOfferingRepository.saveAll(List.of(febOffering, aprilOffering, mayOffering, juneOffering));
    }

    private void createStudents() {
        //  String firstName, String lastName, String emailAddress, String studentId, String visaStatus, String status, String track, LocalDate entryDate, String barcode
        Student sam = new Student("samson", "zaid", "Samson Tekleab", "Zaid", "szaid@miu.edu", "000-xx-yyyy", "F1", "Online", "MSCS", LocalDate.of(2021, Month.JANUARY, 26), "abcdefghijklm");

        studentRepository.saveAll(List.of(sam));
    }

    private void createFaculties() {
        // String firstName, String lastName, String emailAddress, String title
        Faculty payman = new Faculty("payman", "salek", "Payman", "Salek", "psalek@miu.edu", "Associate Professor of Computer Science");
        Faculty paul = new Faculty( "paul","corazza", "Paul", "Corazza", "pcorazza@miu.edu", "Professor of Computer Science and Mathematics");
        Faculty greg = new Faculty( "greg", "guthrie","Greg", "Guthrie", "guthrie@miu.edu", "Professor of Computer Science");
        Faculty dean = new Faculty("muhyieddin","altarawneh","Muhyieddin", "Al-Tarawneh", "maltarawneh@miu.edu", "Assistant Professor of Computer Science");
        Faculty obinna = new Faculty("obinna", "kalu","Obinna", "Kalu", "okalu@miu.edu", "Assistant Professor of Computer Science");

        facultyRepository.saveAll(List.of(payman, paul, greg, dean, obinna));
    }

    private void createRoles() {
        //  String name, String description
        Role roleAdmin = new Role("ROLE_ADMIN", "Admin does everything.");
        Role roleStudent = new Role("ROLE_STUDENT", "Student does student stuff.");
        Role roleFaculty = new Role("ROLE_FACULTY", "Faculty does faculty stuff.");
        Role rolePersonnel = new Role("ROLE_PERSONNEL", "Personnel does personnel stuff.");

        roleRepository.saveAll(List.of(roleAdmin, roleStudent, roleFaculty, rolePersonnel));
    }

    private void createLocations() {
        //  String name, String building, Integer capacity
        Location v29 = new Location("V29", "Verill Hall", 30);
        Location dalby = new Location("Dalby Hall", "Argiro Student Center", 200);
        Location dreier12 = new Location("Dreier Room 12", "Dreier Building", 20);
        Location m113 = new Location("M113", "McLaughlin Building", 30);

        locationRepository.saveAll(List.of(v29, dalby, dreier12, m113));
    }

    private void createCourses() {
        //  String code, String abbreviation, String name, String description
        Course fpp = new Course("CS390", "FPP", "Fundamental Programming Practices", "This course provides a focused program for enhancing programming and analytical skills in five areas: problem solving, data structures, object-oriented programming, the Java programming language, and the use of recursion in Java programs.\n" + "\n" + "These topics are of particular importance as a prerequisite for the courses in the graduate program in Computer Science.\n" + "\n" + "Topics include: elements of Java programming, object-oriented design and implementation, data structures (including lists, stacks, queues, binary search trees, hash tables, and sets), the exception hierarchy, file i/o and streams, and JDBC. (4 credits) Prerequisite: For undergraduate students: CS 221; for graduate students: consent of the department faculty (4 units)");
        Course mpp = new Course("CS401", "MPP", "Modern Programming Practices", "This course presents the fundamental principles of object-oriented programming. Students will learn how to write reusable and better-maintained software, and integrate this knowledge with laboratory assignments and projects. Topics include: fundamental principles and models of object-oriented programming, UML class diagrams and design principles that promote re-usability and maintainability of software. (4 units)");
        Course wap = new Course("CS472", "WAP", "Web Application Programming", "This course provides a systematic introduction to programming interactive and dynamic web applications. The course is intended for individuals with little or no prior web application programming experience. This offering will use Java servlets and JSP for server side processing. The course will introduce HTML and CSS. JavaScript is a focus of the course, and is covered as a functional programming language including jQuery, Ajax, and JavaScript namespaces and modules. It is a prerequisite for the CS545 Web Application Architecture. It does not cover AngularJS or NodeJS, but the JavaScript covered here will prepare you to learn those technologies. (4 units)\n" + "Prerequisite: CS 220 or CS 401 or consent of the department faculty.");
        Course asd = new Course("CS525", "ASD", "Advanced Software Development", "This course considers the current methods and practices for good design of software systems. Topics include: software design patterns, frameworks, architectures, and designing systems to apply these multi-level abstractions. (2-4 credits) Prerequisite: CS 401 or consent of the department faculty.");
        Course alg = new Course("CS435", "ALG", "Algorithms", "This course presents methods for analyzing the efficiency of algorithms (including worst-case and average-case analysis) and introduces a variety of known, highly efficient algorithms. Analysis, design, and implementation of algorithms are given equal emphasis. Topics include searching and sorting, efficiency of operations on data structures (including lists, hashtables, balanced binary search trees, priority queues), graph algorithms, combinatorial algorithms, recurrence relations, Dynamic Programming, NP-complete problems, and some special topics as time allows. (Special topics include computational geometry, algorithms for cryptosystems, approximation, Big Data and parallel computing.)");
        Course waa = new Course("CS545", "WAA", "Web Application Architecture and Frameworks", "This course focuses web applications in an enterprise setting. An enterprise application is a large software system designed to operate in a large organization such as a corporation or a government. Enterprise applications are complex, scalable, component-based, distributed and mission critical. This course, CS545, focuses on the front end or presentation layer of an enterprise web application. CS544 Enterprise Architecture is a companion course that focuses on the back end or business layer, including business logic, transactions, and persistence. CS472, Web Application Programming, is a prerequisite course that covers HTML, CSS, JavaScript, servlets and JSP.\n" + "\n" + "The course teaches principles and patterns that are general across platforms and frameworks. The course will examine and work with the two predominant Java web frameworks, Java Server Faces (JSF) and SpringMVC. JSF is a component based framework and is the official presentation framework specification for the Java Enterprise Edition technology stack. SpringMVC is part of the Core Spring framework and has become the most widely used Java web framework in recent years. (4 units) Prerequisite: CS 472 or consent of the department faculty.");
        Course stc = new Course("FOR506", "STC", "Science and Technology of Consciousness for Computer Professionals", "Your first course is specifically designed to establish the basis of how you can become a top performing computer science professional. The course is rooted in the practice of Transcendental Meditation which leads to fulfillment of your true potential. You will learn about the benefits of TM including the ability to solve complex problems by superior mental functioning enhancing creativity and “out of the box” thinking. The course will focus upon the principles which underpin peak performance in activity by developing an optimal mix of rest and activity. You will develop and experience an ideal daily routine which supports success in life. (2 units)");
        Course ea = new Course("CS544", "EA", "Enterprise Architecture", "This course focuses on teaching the principles and practices used when developing larger scale enterprise applications. We will examine the different architectural layers that are frequently used and different technologies associated with these layers, including Object Relational Mapping (ORM), Dependency Injection (DI), Aspect Oriented Programming (AOP), and integration with other applications through Web Services (RESTfull and SOAP), Messaging and remote method invocation. Must have a working knowledge of relational databases and SQL. If you do not have a strong course or good working knowledge of SQL you should sign up for CS422 DBMS before signing up for EA. (4 units)");
        Course se = new Course("CS425", "SE", "Software Engineering", "Software Engineering is a course that introduces the student to best practices in software development through a software development methodology. Students have already had some experience in previous courses with the Object Oriented paradigm and have used some of the basic UML diagrams for purposes of modeling relationships between software objects. In Software Engineering, the student will develop skills in putting these tools together to produce robust, easily maintainable software. A software development methodology describes when and how OO concepts and UML diagrams should be used to accomplish the aim of building quality software. The course centers around a small project in which the principles discussed in the lecture format can be illustrated and applied. By the end of the course, the student will have a running application, built in accord with the high standards of the RUP (Rational Unified Process) development methodology.");

        courseRepository.saveAll(List.of(fpp, mpp, wap, asd, alg, ea, se, waa, stc));
    }

    private void createTimeslots() {
        //  String code, String title, LocalTime startTime, LocalTime endTime
        Timeslot amSession = new Timeslot("AM", "AM Session", LocalTime.of(10, 0), LocalTime.of(12, 30));
        Timeslot pmSession = new Timeslot("PM", "PM Session", LocalTime.of(14, 0), LocalTime.of(15, 0));

        timeslotRepository.saveAll(List.of(amSession, pmSession));
    }
}
