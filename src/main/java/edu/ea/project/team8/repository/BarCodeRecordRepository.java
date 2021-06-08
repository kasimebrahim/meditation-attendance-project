package edu.ea.project.team8.repository;

import edu.ea.project.team8.domain.BarCodeRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("barCodeRecordRepository")
@Transactional(propagation=Propagation.MANDATORY)
public interface BarCodeRecordRepository extends JpaRepository<BarCodeRecord, Integer> {

	@Query("SELECT bcr FROM BarCodeRecord bcr WHERE bcr.student.id = :id")
	public List<BarCodeRecord> findAllByStudentId(@Param("id") Integer id);
}
