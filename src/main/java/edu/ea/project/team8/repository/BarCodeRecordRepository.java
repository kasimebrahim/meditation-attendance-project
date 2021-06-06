package edu.ea.project.team8.repository;

import edu.ea.project.team8.domain.BarCodeRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository("barCodeRecordRepository")
@Transactional(propagation=Propagation.MANDATORY)
public interface BarCodeRecordRepository extends JpaRepository<BarCodeRecord, Integer> {

}
