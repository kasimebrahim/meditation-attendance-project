package edu.ea.project.team8.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.ea.project.team8.domain.BarCodeRecord;
import edu.ea.project.team8.domain.Student;


@Service("barCodeRecordService")
@Transactional(propagation=Propagation.REQUIRED)
public class BarCodeRecordServiceImpl implements BarCodeRecordService {

	@Override
	public List<BarCodeRecord> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
