package edu.ea.project.team8.repository;

import edu.ea.project.team8.common.repository.BaseRepository;
import edu.ea.project.team8.domain.Course;
import edu.ea.project.team8.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository("studentRepository")
@Transactional(propagation=Propagation.MANDATORY)
public interface StudentRepository extends BaseRepository<Student, Integer> {

	@Query("SELECT co.course FROM CourseOffering co join co.registrations rgs WHERE rgs.student.id = :id")
	public List<Course> findAllCourses(@Param("id") Integer id);

	@Query("SELECT co.course FROM CourseOffering co join co.registrations rgs WHERE rgs.student.id = :id and co.endDate > :dt and co.beginDate < :dt")
	public List<Course> findAllCoursesTaking(@Param("id") Integer id, @Param("dt") LocalDate date);

	@Query("SELECT co.course FROM CourseOffering co join co.registrations rgs WHERE rgs.student.id = :id and co.endDate < :dt")
	public List<Course> findAllCoursesTakenBefore(@Param("id") Integer id, @Param("dt") LocalDate date);

	Student findByUsername(String name);
}
