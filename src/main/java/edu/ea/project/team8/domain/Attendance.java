package edu.ea.project.team8.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attendance {
	@Id
	private Integer id;

	@ManyToOne
	private Student student;

	@ManyToOne
	private ClassSession classSession;

	@OneToOne
	private BarCodeRecord barCodeRecord;
}
