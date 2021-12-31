package com.bl.hms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AppointmentRepo {
	private static AppointmentRepo instance;
	Set<Appointment> appointmentSet = new HashSet();

	void addAppointment(Appointment apt) {
		appointmentSet.add(apt);
	}

	public static AppointmentRepo getInstance() {
		if (instance == null) {
			instance = new AppointmentRepo();
		}
		return instance;
	}
	
	public Appointment getAppointment(String aptId) {
		/*
		 * for(int i = 0;i < appointmentSet.size();i++) {
		 * if(appointmentSet.get(i).appointmentId.equals(aptId)) { return
		 * appointmentSet.get(i); } } return null;
		 */
		for(Appointment apt : appointmentSet ) {
			 if (apt.appointmentId.equals(aptId)) {
				 return  apt;
			 }
		}
		return null;
	}
	
	public boolean isAppointmentAvaialable(String aptId) {
		/*
		 * for(int i=0; i<appointmentSet.size(); i++) {
		 * if(appointmentSet.get(i).appointmentId.equals(aptId)) { return true; } }
		 * return false;
		 */
		for(Appointment apt : appointmentSet ) {
			 if (apt.appointmentId.equals(aptId)) {
				 return  true;
			 }
		}
		return false;
	}
	
	Set<Appointment> getAppointmentList() {
		return appointmentSet;
	}
	
	public void remove(Appointment apt) {
		appointmentSet.remove(apt);
	}
}