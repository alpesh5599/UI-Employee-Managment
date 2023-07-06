package com.nexscend.employee.management.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="setInterview")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SetInterview {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer interviewId;
	private String interviewerName;
	private LocalDateTime interviewDateTime;
	private String interviewOutCome;
	private String feedback;
	
}