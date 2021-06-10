package edu.ea.project.team8.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.Pattern;

@Data
@ToString(callSuper = true)
@NoArgsConstructor
@Entity
public class Student extends Person implements Serializable, Comparable<Student>{

	@Column(name="personid", columnDefinition = "char(11)")
	@Pattern(regexp = "[A-Za-z0-9]{3}-[A-Za-z0-9]{2}-[A-Za-z0-9]{4}", message = "Invalid Format")
	private String studentId;

	@Column(name="visastatus", columnDefinition = "nvarchar(50)")
	private String visaStatus;

	@Column(columnDefinition = "nvarchar(50)")
	private String status;

	@Column(columnDefinition = "varchar(50)")
	private String track;

	@Column(name="entry", columnDefinition = "datetime")
	private LocalDate entryDate;

	@Column(columnDefinition = "char(13)")
	private String barcode;

	public Student(String username, String password, String firstName, String lastName, String emailAddress,
	               String studentId, String visaStatus, String status,
	               String track, LocalDate entryDate, String barcode) {
		super(username, password, firstName, lastName, emailAddress);
		this.studentId = studentId;
		this.visaStatus = visaStatus;
		this.status = status;
		this.track = track;
		this.entryDate = entryDate;
		this.barcode = barcode;
	}

	/**
	 * Compares this object with the specified object for order.  Returns a
	 * negative integer, zero, or a positive integer as this object is less
	 * than, equal to, or greater than the specified object.
	 *
	 * <p>The implementor must ensure
	 * {@code sgn(x.compareTo(y)) == -sgn(y.compareTo(x))}
	 * for all {@code x} and {@code y}.  (This
	 * implies that {@code x.compareTo(y)} must throw an exception iff
	 * {@code y.compareTo(x)} throws an exception.)
	 *
	 * <p>The implementor must also ensure that the relation is transitive:
	 * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
	 * {@code x.compareTo(z) > 0}.
	 *
	 * <p>Finally, the implementor must ensure that {@code x.compareTo(y)==0}
	 * implies that {@code sgn(x.compareTo(z)) == sgn(y.compareTo(z))}, for
	 * all {@code z}.
	 *
	 * <p>It is strongly recommended, but <i>not</i> strictly required that
	 * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
	 * class that implements the {@code Comparable} interface and violates
	 * this condition should clearly indicate this fact.  The recommended
	 * language is "Note: this class has a natural ordering that is
	 * inconsistent with equals."
	 *
	 * <p>In the foregoing description, the notation
	 * {@code sgn(}<i>expression</i>{@code )} designates the mathematical
	 * <i>signum</i> function, which is defined to return one of {@code -1},
	 * {@code 0}, or {@code 1} according to whether the value of
	 * <i>expression</i> is negative, zero, or positive, respectively.
	 *
	 * @param o the object to be compared.
	 * @return a negative integer, zero, or a positive integer as this object
	 * is less than, equal to, or greater than the specified object.
	 * @throws NullPointerException if the specified object is null
	 * @throws ClassCastException   if the specified object's type prevents it
	 *                              from being compared to this object.
	 */
	@Override
	public int compareTo(@NotNull Student o) {
		return this.studentId.compareTo(o.studentId);
	}
}
