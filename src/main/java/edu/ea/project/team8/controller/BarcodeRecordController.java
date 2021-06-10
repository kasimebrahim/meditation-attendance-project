package edu.ea.project.team8.controller;

import edu.ea.project.team8.common.controller.BaseController;
import edu.ea.project.team8.domain.BarCodeRecord;
import edu.ea.project.team8.service.BarCodeRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/barcodes")
public class BarcodeRecordController extends BaseController<BarCodeRecord, BarCodeRecord, Integer> {

    @Autowired
    BarCodeRecordService barCodeRecordService;

    @Override
    @PostMapping
    public BarCodeRecord add(@RequestBody BarCodeRecord entity) {
        return barCodeRecordService.createAttendanceWithBarcode(entity);
    }
}
