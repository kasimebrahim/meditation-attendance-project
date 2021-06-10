package edu.ea.project.team8.service;

import java.util.List;

import edu.ea.project.team8.common.service.BaseServiceImpl;
import edu.ea.project.team8.domain.Attendance;
import edu.ea.project.team8.domain.ClassSession;
import edu.ea.project.team8.repository.AttendanceRepository;
import edu.ea.project.team8.repository.BarCodeRecordRepository;
import edu.ea.project.team8.repository.ClassSessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.ea.project.team8.domain.BarCodeRecord;
import edu.ea.project.team8.domain.Student;


@Service("barCodeRecordService")
@Transactional(propagation=Propagation.REQUIRED)
public class BarCodeRecordServiceImpl extends BaseServiceImpl<BarCodeRecord, BarCodeRecord, Integer> implements BarCodeRecordService{

	@Autowired
	AttendanceRepository attendanceRepository;
	@Autowired
	ClassSessionRepository classSessionRepository;


	@Override
	protected List<BarCodeRecord> convertToResponseList(List<BarCodeRecord> list) {
		return list;
	}

	@Override
	public BarCodeRecord createAttendanceWithBarcode(BarCodeRecord barCodeRecord) {
		ClassSession classSession= classSessionRepository.findClassSessionByTime(
				barCodeRecord.getTimeStamp().toLocalDate(), barCodeRecord.getTimeStamp().toLocalTime(),
				barCodeRecord.getLocation().getId(), barCodeRecord.getStudent().getId());
		BarCodeRecord savedBarcode = add(barCodeRecord);
		if (classSession != null){
			Attendance attendance = new Attendance();
			attendance.setStudent(barCodeRecord.getStudent());
			attendance.setBarCodeRecord(savedBarcode);
			attendance.setClassSession(classSession);
			attendance.setPresent(false);
			attendanceRepository.save(attendance);
		}
		return savedBarcode;
	}
}
