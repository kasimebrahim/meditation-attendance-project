package edu.ea.project.team8.service;

import java.util.List;

import edu.ea.project.team8.domain.BarCodeRecord;

public interface BarCodeRecordService {
	public List<BarCodeRecord> findAll();
	public void addRecord(BarCodeRecord barCodeRecord);
}
