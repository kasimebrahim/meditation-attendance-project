package edu.ea.project.team8.service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Attendance {
	private Integer studentId;
	private Integer barCodeRecordId;
	private Integer classSessionId;
}
