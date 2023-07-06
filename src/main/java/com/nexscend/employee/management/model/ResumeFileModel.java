package com.nexscend.employee.management.model;

import java.util.Arrays;

public class ResumeFileModel {

	private String resumeName;
	private String resumeType;
	private byte[] resumeData;

	public String getResumeType() {
		return resumeType;
	}

	public void setResumeType(String resumeType) {
		this.resumeType = resumeType;
	}

	public String getResumeName() {
		return resumeName;
	}

	public void setResumeName(String resumeName) {
		this.resumeName = resumeName;
	}

	public byte[] getResumeData() {
		return resumeData;
	}

	public void setResumeData(byte[] resumeData) {
		this.resumeData = resumeData;
	}

	@Override
	public String toString() {
		return "ResumeFileModel [resumeName=" + resumeName + ", resumeType=" + resumeType + ", resumeData="
				+ Arrays.toString(resumeData) + "]";
	}

}