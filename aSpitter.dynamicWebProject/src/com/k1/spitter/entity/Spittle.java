package com.k1.spitter.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "spittle")
public class Spittle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@ManyToOne
//	(cascade = CascadeType.ALL)
//	@JoinColumn(name = "spitter_id", referencedColumnName = "id", insertable = false, updatable = false)
	private Spitter spitter;

	@Column(name = "spittleText")
	@NotNull
	@Size(min = 1, max = 140)
	private String text;

	@Column(name = "postedTime")
	@DateTimeFormat(pattern = "hh:mma MMM d, YYYY")
	private Date when;

	public Spittle() {
	}

//	public Spittle() {
//		this.spitter = new Spitter();
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Spitter getSpitter() {
		return spitter;
	}

	public void setSpitter(Spitter spitter) {
		this.spitter = spitter;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Date getWhen() {
		return when;
	}

	public void setWhen(Date when) {
		this.when = when;
	}

	@Override
	public String toString() {
		return "Spittle [id=" + id + ", spitter=" + spitter + ", text=" + text + ", when=" + when + "]";
	}
}
