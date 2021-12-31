package com.bl.hms;

import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class PatientRepo {
	public static PatientRepo instance;
	Set<Patient> patientSet = new HashSet();
	
	 PatientRepo() {
	    }

	public static PatientRepo getInstance() {
		if (instance == null) {
			instance = new PatientRepo();
		}
		return instance;
	}

	void addPatient(Patient patient) {
		patientSet.add(patient);
	}

	Set<Patient> getPatientList() {
		return patientSet;
	}

	public Patient getPatient(String id) {
		/*
		 * for (int i = 0; i < patientList.size(); i++) { if
		 * (patientList.get(i).patientId.equals(id)) { return patientList.get(i); }
		 * 
		 * } return null;
		 */
		
		for (Patient patient : patientSet) {
			if (patient.patientId.equals(id)) {
				return patient;
			}
		}
		return null;
	}

	public boolean isPatientAvailable(String patientId) {
		/*
		 * for (int i = 0; i < patientSet.size(); i++) { if
		 * (patientSet.get(i).patientId.equals(patientId)) { return true; } } return
		 * false;
		 */
		for (Patient patient : patientSet) {
			if (patient.patientId.equals(patientId)) {
				return true;
			}
		}
		return false;
	}

	public void remove(Patient patient) {
		patientSet.remove(patient);
	}
}
