package edu.ea.project.team8.service;

import edu.ea.project.team8.common.service.BaseService;
import edu.ea.project.team8.domain.BarCodeRecord;

public interface BarCodeRecordService extends BaseService<BarCodeRecord, BarCodeRecord, Integer> {

    BarCodeRecord createAttendanceWithBarcode(BarCodeRecord barCodeRecord);
}
