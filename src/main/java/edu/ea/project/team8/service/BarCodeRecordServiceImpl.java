package edu.ea.project.team8.service;

import java.util.List;

import edu.ea.project.team8.repository.BarCodeRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.ea.project.team8.domain.BarCodeRecord;
import edu.ea.project.team8.domain.Student;


@Service("barCodeRecordService")
@Transactional(propagation=Propagation.REQUIRED)
public class BarCodeRecordServiceImpl implements BarCodeRecordService {

	private BarCodeRecordRepository repository;

	@Autowired
	public BarCodeRecordServiceImpl(BarCodeRecordRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<BarCodeRecord> findAll() {
		return repository.findAll();
	}

	@Override
	public void addRecord(BarCodeRecord barCodeRecord) {
		repository.save(barCodeRecord);
	}

}
