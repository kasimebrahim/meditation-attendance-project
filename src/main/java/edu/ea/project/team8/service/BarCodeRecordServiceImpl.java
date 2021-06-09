package edu.ea.project.team8.service;

import java.util.List;

import edu.ea.project.team8.common.service.BaseServiceImpl;
import edu.ea.project.team8.repository.BarCodeRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.ea.project.team8.domain.BarCodeRecord;
import edu.ea.project.team8.domain.Student;


@Service("barCodeRecordService")
@Transactional(propagation=Propagation.REQUIRED)
public class BarCodeRecordServiceImpl extends BaseServiceImpl<BarCodeRecord, BarCodeRecord, Integer> {

	@Override
	protected List<BarCodeRecord> convertToResponseList(List<BarCodeRecord> list) {
		return list;
	}
}
