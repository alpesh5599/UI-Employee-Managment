package com.nexscend.employee.management.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.nexscend.employee.management.entity.ResumeFile;
import com.nexscend.employee.management.model.ResumeFileModel;
import com.nexscend.employee.management.repository.ResumeFileRepository;

public class ResumeFileServiceImpl implements ResumeFileService {

	Logger logger = LoggerFactory.getLogger(ResumeFileServiceImpl.class);

	@Autowired
	ResumeFileRepository repository;

	@Override
	public void saveCandidate(ResumeFileModel file) {
		ResumeFile entity = new ResumeFile();

		if (file == null) {
			logger.error("File not Found...");
		}

		entity.setResumeName(file.getResumeName());
		entity.setResumeData(file.getResumeData());
		entity.setResumeType(file.getResumeType());

		// Save in DB
		repository.save(entity);
		
	}

}
