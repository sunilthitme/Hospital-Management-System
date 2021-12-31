package com.bl.hms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Application {
	private String patientId;

	public static void main(String[] args) {
		
		int option;
		UserInterface userInterface = new UserInterface();
		Application application = new Application();

		do {
			option = userInterface.ShowMainMenu();
			application.handleUserSelection(option);
		} while (option != Constant.EXIT);
	}

	void handleUserSelection(int option) {
		DoctorRepo doctorRepo = DoctorRepo.getInstance();
		PatientRepo patientRepo = PatientRepo.getInstance();
		AppointmentRepo appointmentRepo = AppointmentRepo.getInstance();
		Scanner sc = new Scanner(System.in);
		UserInterface userInterface = new UserInterface();
		switch (option) {
		case 1:
			addDoctor();
			break;
		case 2:
			System.out.println("Enter doctor id for update");
			String id1 = sc.nextLine();
			Doctor doctor = doctorRepo.getDoctor(id1);
			if (doctor != null) {
				userInterface.updateDoctor(doctor);
			} else
				System.out.println("not found");

			break;
		case 3:
			System.out.println("Enter Doctor Id ");
			String id = sc.nextLine();
			Doctor doctorRemove = doctorRepo.getDoctor(id);
			if(doctorRemove!=null) {
			doctorRepo.remove(doctorRemove);
			}else {
				System.out.println("Not found");
			}
			break;
		case 4:
			Set lstDoc = doctorRepo.getDoctorSet();
			userInterface.printAllDoctor(lstDoc);
			break;
		case 5:
			addPatient();
			break;
		case 6:
			System.out.println("Enter patient id for update");
			String patientId1 = sc.nextLine();
			Patient patient = patientRepo.getPatient(patientId1);
			if (patient != null) {
				userInterface.updatePatient(patient);
			} else
				System.out.println("Not found!!");
			break;
		case 7:
			System.out.println("Enter Patient Id ");
			String PatientId = sc.nextLine();
			Patient patientRemove = patientRepo.getPatient(patientId);
			if(patientRemove != null) {
			patientRepo.remove(patientRemove);
			System.out.println("Patient remove Successfully....");
			}else {
				System.out.println("Not found!!");
			}
			break;
		case 8:
			Set lstPatient = patientRepo.getPatientList();
			userInterface.printAllPatient(lstPatient);
			break;
		case 9:
			addAppointment();
			break;
		case 10:
			System.out.println("Enter Appointment Id ::");
			String aptId=sc.next();
			Appointment apt=appointmentRepo.getAppointment(aptId);
			if(apt!=null) {
			userInterface.updateAppointment(apt);
			System.out.println("Appointment update Successfully....");
			}else {
				System.out.println("Not found");
			}
			break;
		case 11:
			System.out.println("Enter Appointment Id ::");
			String aptId1=sc.next();
			Appointment aptRemove=appointmentRepo.getAppointment(aptId1);
			if(aptRemove!=null) {
			appointmentRepo.remove(aptRemove);
			System.out.println("Appointment remove Successfully....");
			}else{
				System.out.println("Not found!!");
			}
			break;
		case 12:
			Set lstAppointment = appointmentRepo.getAppointmentList();
			userInterface.printAllAppointment(lstAppointment);
			break;
		case Constant.EXIT:
			break;
		default:
			System.out.println("Wrong Option..!");
			break;
		}
	}

	void addDoctor() {
		UserInterface userInterface = new UserInterface();
		DoctorRepo doctorRepo = DoctorRepo.getInstance();
		doctorRepo.addDoctor(userInterface.getDoctorDetails());
	}

	void addPatient() {
		UserInterface userInterface = new UserInterface();
		PatientRepo patientRepo = PatientRepo.getInstance();
		patientRepo.addPatient(userInterface.getPatientDetails());

	}

	void addAppointment() {
		AppointmentRepo appointmentRepo = AppointmentRepo.getInstance();
		UserInterface userInterface = new UserInterface();
		appointmentRepo.addAppointment(userInterface.getAppointmentDetails());
	}
}