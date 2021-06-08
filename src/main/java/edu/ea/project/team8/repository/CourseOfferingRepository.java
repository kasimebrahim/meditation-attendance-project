package edu.ea.project.team8.repository;

import edu.ea.project.team8.domain.CourseOffering;
import edu.ea.project.team8.service.dto.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Repository("courseOfferingRepository")
@Transactional(propagation=Propagation.MANDATORY)
public interface CourseOfferingRepository extends JpaRepository<CourseOffering, Integer> {
	@Query("SELECT distinct cof FROM CourseOffering cof WHERE cof.course.id = :cid")
	public List<CourseOffering> findAllByCourse(@Param("cid") Integer cid);

	@Query("SELECT distinct cof FROM CourseOffering cof join cof.registrations rg WHERE rg.student.id = :sid")
	public List<CourseOffering> findAllByStudent(@Param("sid") Integer sid);

	public List<CourseOffering> findAllByBeginDate(LocalDate beginDate);

	@Query("SELECT distinct cof FROM CourseOffering cof join cof.registrations rg WHERE rg.student.id = :sid and cof.course.id = :cid and cof.beginDate = :beginDate")
	public CourseOffering findByStuCouDate(@Param("sid") Integer sid, @Param("cid") Integer cid, @Param("beginDate") LocalDate beginDate);

	@Query("SELECT distinct new edu.ea.project.team8.service.dto.Attendance(rg.student.id, br.id, cs.id) " +
			"FROM CourseOffering cof join cof.registrations rg, ClassSession cs, BarCodeRecord br " +
			"WHERE br.location.id = cs.location.id " +
			"and rg.student.id = :sid " +
			"and br.student.id = :sid " +
			"and cs.offering.id = cof.id " +
			"and year(cs.date) = year(br.timeStamp) and month(cs.date) = month(br.timeStamp) and day(cs.date) = day(br.timeStamp) " +
			"and hour(cs.timeslot.endTime) >= hour(br.timeStamp) " +
			"and hour(cs.timeslot.startTime) <= hour(br.timeStamp)")
	List<Attendance> findAttendanceById(@Param("sid") Integer sid);

	@Query("SELECT distinct new edu.ea.project.team8.service.dto.Attendance(rg.student.id, br.id, cs.id) " +
			"FROM CourseOffering cof join cof.registrations rg, ClassSession cs, BarCodeRecord br " +
			"WHERE br.location.id = cs.location.id " +
			"and cof.course.id = :cid " +
			"and br.student.id = rg.student.id " +
			"and cs.offering.id = cof.id " +
			"and year(cs.date) = year(br.timeStamp) and month(cs.date) = month(br.timeStamp) and day(cs.date) = day(br.timeStamp) " +
			"and hour(cs.timeslot.endTime) >= hour(br.timeStamp) " +
			"and hour(cs.timeslot.startTime) <= hour(br.timeStamp)")
	List<Attendance> findAttendanceByCourse(@Param("cid") Integer cid);

	@Query("SELECT distinct new edu.ea.project.team8.service.dto.Attendance(rg.student.id, br.id, cs.id) " +
			"FROM CourseOffering cof join cof.registrations rg, ClassSession cs, BarCodeRecord br " +
			"WHERE br.location.id = cs.location.id " +
			"and rg.student.id = :sid " +
			"and br.student.id = :sid " +
			"and cof.course.id = :cid " +
			"and cs.offering.id = cof.id " +
			"and year(cs.date) = year(br.timeStamp) and month(cs.date) = month(br.timeStamp) and day(cs.date) = day(br.timeStamp) " +
			"and hour(cs.timeslot.endTime) >= hour(br.timeStamp) " +
			"and hour(cs.timeslot.startTime) <= hour(br.timeStamp)")
	List<Attendance> findAttendanceOfByCourse(@Param("sid") Integer sid, @Param("cid") Integer cid);

	@Query("SELECT distinct new edu.ea.project.team8.service.dto.Attendance(rg.student.id, br.id, cs.id) " +
			"FROM CourseOffering cof join cof.registrations rg, ClassSession cs, BarCodeRecord br " +
			"WHERE br.location.id = cs.location.id " +
			"and cof.id = :offeringId " +
			"and rg.student.id = br.student.id " +
			"and cs.offering.id = cof.id " +
			"and year(cs.date) = year(br.timeStamp) and month(cs.date) = month(br.timeStamp) and day(cs.date) = day(br.timeStamp) " +
			"and hour(cs.timeslot.endTime) >= hour(br.timeStamp) " +
			"and hour(cs.timeslot.startTime) <= hour(br.timeStamp)")
	List<Attendance> findAttendancesByCourseOffering(@Param("offeringId") Integer offeringId);

	@Query("SELECT distinct new edu.ea.project.team8.service.dto.Attendance(rg.student.id, br.id, cs.id) " +
			"FROM CourseOffering cof join cof.registrations rg, ClassSession cs, BarCodeRecord br " +
			"WHERE br.location.id = cs.location.id " +
			"and cof.id = :offeringId " +
			"and rg.student.id = :sid " +
			"and rg.student.id = br.student.id " +
			"and cs.offering.id = cof.id " +
			"and year(cs.date) = year(br.timeStamp) and month(cs.date) = month(br.timeStamp) and day(cs.date) = day(br.timeStamp) " +
			"and hour(cs.timeslot.endTime) >= hour(br.timeStamp) " +
			"and hour(cs.timeslot.startTime) <= hour(br.timeStamp)")
	List<Attendance> findAttendancesOfByCourseOffering(@Param("sid") Integer sid, @Param("offeringId") Integer offeringId);
}
