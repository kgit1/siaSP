package com.k1.spitter.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//to show hibernate that there is model class
@Entity
// can be skipped if class name matches table name
@Table(name = "spitter")
public class Spitter {

	// marks id value
	// means primary key for database
	@Id
	// defines generation strategy for our id if we want
	// to change default primary key generation strategy
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	// mark and name column
	@Column(name = "id")
	private int id;

	@Column(name = "username")
	private String userName;

	@Column(name = "password")
	private String password;

	@Column(name = "fullname")
	private String fullName;

	@Column(name = "email")
	private String email;

	@Column(name = "update_by_email")
	private boolean updateByEmail;

	///////////
	@Column(name = "`timestamp`")
	@Temporal(TemporalType.TIME)
	private Date timestamp;
	// Hibernate will include both the DATE, the TIME and the nanoseconds in the
	// INSERT statement:
	// INSERT INTO DateEvent ( timestamp, id )
	// VALUES ( '2015-12-29 16:54:04.544', 1 )

	//////////////////// DOSN'T WORK, PUTS NOTHING TO MYSQL TABLE//////////////
	// @Column(name = "`date`")
	// // @Temporal(TemporalType.DATE)
	// private Date date;
	// // Hibernate generates the following INSERT statement:
	// // Only the year, month and the day field were saved into the database.
	// // INSERT INTO DateEvent ( timestamp, id )
	// // VALUES ( '2015-12-29', 1 )
	//
	// @Column(name = "`time`")
	// @Temporal(TemporalType.TIME)
	// private Date time;
	// // Hibernate will issue an INSERT statement containing the hour, minutes
	// and
	// // seconds.
	// // INSERT INTO DateEvent ( timestamp, id )
	// // VALUES ( '16:51:58', 1 )
	/////////////////////////////////////////////////////////////////////////////

	// empty constructor
	public Spitter() {
	}

	// constructor with fields but not id(primary key)
	public Spitter(String userName, String password, String fullName, String email, boolean updateByEmail) {
		super();
		this.userName = userName;
		this.password = password;
		this.fullName = fullName;
		this.email = email;
		this.updateByEmail = updateByEmail;
	}

	// generate getters, setters and toString for all fields
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isUpdateByEmail() {
		return updateByEmail;
	}

	public void setUpdateByEmail(boolean updateByEmail) {
		this.updateByEmail = updateByEmail;
	}

	@Override
	public String toString() {
		return "Spitter [id=" + id + ", userName=" + userName + ", password=" + password + ", fullName=" + fullName
				+ ", email=" + email + ", updateByEmail=" + updateByEmail + ", timestamp="
				+ timestamp /*
							 * + ", date=" + date + ", time=" + time
							 */ + "]";
	}

	// create table in mysql
	// create table spitter (
	// id int not null auto_increment primary key,
	// username varchar(25) not null,
	// password varchar(25) not null,
	// fullname varchar(100) not null,
	// email varchar(50) not null,
	// update_by_email boolean not null
	// );

	// fill table with data in mysql
	// insert into spitter (username, password, fullname, email,
	// update_by_email) values
	// ('habuma', 'password', 'Craig Walls', 'craig@habuma.com', false);
	// insert into spitter (username, password, fullname, email,
	// update_by_email) values
	// ('artnames', 'password', 'Art Names', 'artnames@habuma.com', false);

}

// @Entity
//// can be skipped if class name matches table name
// @Table(name = "student")
// public class Student {
//
// // means primary key for database
// @Id
// // defines generation strategy for our id if we want
// // to change default primary key generation strategy
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// // mark and name column
// @Column(name = "id")
// private int id;
//
// @Column(name = "first_name")
// private String firstName;
//
// @Column(name = "last_name")
// private String lastName;
//
// @Column(name = "email")
// private String email;
//
// // empty constructor
// public Student() {
//
// }
//
// // constructor with fields but not id(primary key)
// public Student(String firstName, String lastName, String email) {
// this.firstName = firstName;
// this.lastName = lastName;
// this.email = email;
// }
//
// // generate getters and setters for all fields
// public int getId() {
// return id;
// }
//
// public void setId(int id) {
// this.id = id;
// }
//
// public String getFirstName() {
// return firstName;
// }
//
// public void setFirstName(String firstName) {
// this.firstName = firstName;
// }
//
// public String getLastName() {
// return lastName;
// }
//
// public void setLastName(String lastName) {
// this.lastName = lastName;
// }
//
// public String getEmail() {
// return email;
// }
//
// public void setEmail(String email) {
// this.email = email;
// }
//
// // generate toString
// @Override
// public String toString() {
// return "Student [id=" + id + ", firstName=" + firstName + ", lastName="
// + lastName + ", email=" + email + "]";
// }
//
// }
