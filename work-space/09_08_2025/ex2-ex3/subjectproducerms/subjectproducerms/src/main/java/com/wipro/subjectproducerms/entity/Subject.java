package com.wipro.subjectproducerms.entity;

public class Subject {
	String subjectCode;
	String subject;
	public Subject(String subjectCode, String subject) {
		super();
		this.subjectCode = subjectCode;
		this.subject = subject;
	}
	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	public String getSubjectName() {
		return subject;
	}
	public void setSubjectName(String subject) {
		this.subject = subject;
	}
	@Override
	public String toString() {
		return "Subject [subjectCode=" + subjectCode + ", subject=" + subject + "]";
	}
	
}
