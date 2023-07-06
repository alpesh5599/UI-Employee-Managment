package com.nexscend.employee.management.model;

import org.springframework.stereotype.Component;

@Component
public class CandidateResponse {
	
	private Integer id;
	private String applyingPosition;
	private String candidateFirstName;
	private String candidateLastName;
	private String candidateEmail;
	private Long candidatePhoneNo;
	private String candidateSkills;
	private String joiningAvailability;
	private ResumeFileModel resume;
	private String comments;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getApplyingPosition() {
		return applyingPosition;
	}
	public void setApplyingPosition(String applyingPosition) {
		this.applyingPosition = applyingPosition;
	}
	public String getCandidateFirstName() {
		return candidateFirstName;
	}
	public void setCandidateFirstName(String candidateFirstName) {
		this.candidateFirstName = candidateFirstName;
	}
	public String getCandidateLastName() {
		return candidateLastName;
	}
	public void setCandidateLastName(String candidateLastName) {
		this.candidateLastName = candidateLastName;
	}
	public String getCandidateEmail() {
		return candidateEmail;
	}
	public void setCandidateEmail(String candidateEmail) {
		this.candidateEmail = candidateEmail;
	}
	public Long getCandidatePhoneNo() {
		return candidatePhoneNo;
	}
	public void setCandidatePhoneNo(Long candidatePhoneNo) {
		this.candidatePhoneNo = candidatePhoneNo;
	}
	public String getCandidateSkills() {
		return candidateSkills;
	}
	public void setCandidateSkills(String candidateSkills) {
		this.candidateSkills = candidateSkills;
	}
	public String getJoiningAvailability() {
		return joiningAvailability;
	}
	public void setJoiningAvailability(String joiningAvailability) {
		this.joiningAvailability = joiningAvailability;
	}
	
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public ResumeFileModel getResume() {
		return resume;
	}
	public void setResume(ResumeFileModel resume) {
		this.resume = resume;
	}
	@Override
	public String toString() {
		return "CandidateResponse [id=" + id + ", applyingPosition=" + applyingPosition + ", candidateFirstName="
				+ candidateFirstName + ", candidateLastName=" + candidateLastName + ", candidateEmail=" + candidateEmail
				+ ", candidatePhoneNo=" + candidatePhoneNo + ", candidateSkills=" + candidateSkills
				+ ", joiningAvailability=" + joiningAvailability + ", resume=" + resume + ", comments=" + comments
				+ "]";
	}
	
}
