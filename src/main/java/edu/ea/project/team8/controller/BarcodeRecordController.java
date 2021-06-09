package edu.ea.project.team8.controller;

import edu.ea.project.team8.common.controller.BaseController;
import edu.ea.project.team8.domain.BarCodeRecord;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/barcodes")
public class BarcodeRecordController extends BaseController<BarCodeRecord, BarCodeRecord, Integer> {
}
