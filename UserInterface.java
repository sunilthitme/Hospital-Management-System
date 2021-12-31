package com.bl.hms;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class UserInterface {
	DoctorRepo doctorRepo = new DoctorRepo();
	PatientRepo patientRepo = new PatientRepo();
	public int ShowMainMenu() {
		System.out.println("Hospital Management System");
		System.out.println("1.Add Doctor \n2.Update Doctor \n3.Delete Doctor" + "\n4.Print All Doctor \n5.Add Patient"
				+ "\n6.Update Patient \n7.Delete Patient \n8.Print All Patient");

		System.out.println("9.Add Appointment \n10.Update Appointment \n11.Delete Appointment\n"
				+ "12.Print All Appointment\n" + Constant.EXIT + ".Exit");

		Scanner scanner = new Scanner(System.in);

		System.out.println("Select Your Option :");
		int option = scanner.nextInt();

		return option;
	}

	public void printAllDoctor(Set <Doctor> doctorSet) {
	        for (Doctor doctor : doctorSet) {
	            System.out.println(doctor);
	        }
	}
	
	public void printAllPatient(Set <Patient> patientSet) {
		for(Patient patient : patientSet) {
			System.out.println(patient);
		}
	}

	public void printAllAppointment(Set <Appointment> appointmentSet) {
		for(Appointment apt : appointmentSet) {
			System.out.println(apt);
		}
	}

	public Doctor getDoctorDetails() {
		Scanner scanner = new Scanner(System.in);
		Doctor doctor = new Doctor();

		System.out.println("Enter Doctor Name :");
		doctor.docName = scanner.nextLine();

		System.out.println("Enter Doctor Specialization :");
		doctor.specialization = scanner.nextLine();

		System.out.println("Enter Doctor Email ID :");
		doctor.emailID = scanner.nextLine();

		System.out.println("Enter Doctor ID :");
		doctor.id = scanner.nextLine();

		System.out.println("Enter Doctor Mobile Name :");
		doctor.mobNo = scanner.nextLong();

		doctor.availability = new HashMap<>();
		;
		doctor.availability.put(Doctor.WeekDays.SUNDAY, "10 AM to 12 PM");
		doctor.availability.put(Doctor.WeekDays.MONDAY, "12 PM to 2 PM");
		doctor.availability.put(Doctor.WeekDays.TUESDAY, "2 PM to 4 PM");
		doctor.availability.put(Doctor.WeekDays.WEDNESDAY, "4 PM to 6 PM");
		doctor.availability.put(Doctor.WeekDays.THURSDAY, "6 PM to 8 PM");
		doctor.availability.put(Doctor.WeekDays.FRIDAY, "8 PM to 10 PM");
		doctor.availability.put(Doctor.WeekDays.SATURDAY, "10 PM to 12 AM");

		return doctor;
	}

	public Patient getPatientDetails() {
		Scanner scanner = new Scanner(System.in);
		Patient patient = new Patient();

		System.out.println("Enter Patient Name :");
		patient.name = scanner.nextLine();

		System.out.println("Enter Patient Email ID :");
		patient.emailID = scanner.nextLine();

		System.out.println("Enter Patient Disease :");
		patient.disease = scanner.nextLine();

		System.out.println("Enter the Patient Address :");
		patient.address = scanner.nextLine();

		System.out.println("Enter the Patient ID :");
		patient.patientId = scanner.nextLine();

		System.out.println("Enter Patient Age :");
		patient.age = scanner.nextLong();

		System.out.println("Enter Patient Mobile Name :");
		patient.mobNo = scanner.nextLong();

		setGender(patient);
		return patient;

	}

	public void setGender(Patient patient) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("1.Male \n2.Female \n3.Others :");
		int option = scanner.nextInt();

		switch (option) {
		case 1:
			patient.gender = Patient.Gender.MALE;
			break;

		case 2:
			patient.gender = Patient.Gender.FEMALE;
			break;
		case 3:
			patient.gender = Patient.Gender.OTHERS;
			break;
		default:
			System.out.println("Wrong Option..!");
			break;
		}
	}

	public Appointment getAppointmentDetails() {
		Scanner scanner = new Scanner(System.in);
		DoctorRepo doctorRepo = DoctorRepo.getInstance();
		PatientRepo patientRepo = PatientRepo.getInstance();
		Appointment appointment = new Appointment();

		System.out.println("Enter doctor id");
		appointment.doctorId = scanner.nextLine();

		if (doctorRepo.isDoctorAvailable(appointment.doctorId)) {
			System.out.println("Enter the PatientId :");
			appointment.patientId = scanner.nextLine();

			if (patientRepo.isPatientAvailable(appointment.patientId)) {
				System.out.println("Enter the RoomNumber :");
				appointment.roomNumber = scanner.nextLong();
				
				System.out.println("Enter the Appointment id :");
				appointment.appointmentId = scanner.next();
				
				System.out.println("Enter the Appointment Date like dd-MM-yyyy");
                Scanner scanner2 = new Scanner(System.in);
                appointment.appointmentDate = scanner2.nextLine();
                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                try {
                    Date date = formatter.parse(appointment.appointmentDate);
                } catch (ParseException e) {
                    e.printStackTrace(); 
                }
			} else {
				System.out.println("Patient id is not available");
			}
		} else {
			System.out.println("Doctor id not available ");
		}
		return appointment;
	}

	public void updateDoctor(Doctor doctor) {
		Scanner sc = new Scanner(System.in);
		int option=0;
		while (option!=5) {
		System.out.println("1.Update Name \n2.Update Specialization \n3.Update mailID \n4.Mob no. \n5.Exit");
		option = sc.nextInt();
		switch (option) {
		case 1:
			System.out.println("Enter new name to update");
			doctor.docName = sc.next();
			break;
		case 2:
			System.out.println("Enter new specialization to update");
			doctor.specialization = sc.next();
			break;
		case 3:
			System.out.println("Enter new email id to update");
			doctor.emailID = sc.next();
			break;
		case 4:
			System.out.println("Enter new email id to update");
			doctor.mobNo = sc.nextLong();
			break;
		case Constant.DOCTOREXIT:
			break;
		default:
			System.out.println("Wrong Option..!");
			break;	
			}
		}
	}

	public void updatePatient(Patient patient) {
		Scanner sc = new Scanner(System.in);
		int option=0;
		while(option != 8) {
		System.out.println("1.Update Name \n2.Update Address \n3.EmailID \n4.Disease \n5.MobNo \n6.Age \n7.Gender \n8.Exit");
		option = sc.nextInt();
		switch (option) {
		case 1:
			System.out.println("Enter new name to update");
			patient.name = sc.next();
			break;
		case 2:
			System.out.println("Enter new address to update");
			patient.address = sc.next();
			break;
		case 3:
			System.out.println("Enter new emailID to update");
			patient.emailID = sc.next();
			break;
		case 4:
			System.out.println("Enter Disease to update");
			patient.disease = sc.next();
			break;
		case 5:
			System.out.println("Enter mobile number to update");
			patient.mobNo = sc.nextLong();
			break;
		case 6:
			System.out.println("Enter Age to update");
			patient.age = sc.nextInt();
			break;
		case 7:
			setGender(patient);
			break;
		case Constant.PATIENTEXIT:
			break;
		default:
			System.out.println("Wrong Option..!");
			break;
			}
		}
	}

	public void updateAppointment(Appointment appointment) {
		Scanner scanner = new Scanner(System.in);
		int option = 0;
		while (option != 3) {
			System.out.println("1.Update Room Number \n2.Update Date \n3.Exit");
			option = scanner.nextInt();
			switch (option) {
			case 1:
				System.out.println("Enter room number:: ");
				appointment.roomNumber = scanner.nextLong();
				break;
			case 2:
				System.out.println("Enter the Appointment Date like dd-MM-yyyy");
				Scanner scanner2 = new Scanner(System.in);
				appointment.appointmentDate = scanner2.nextLine();
				SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
				try {
					Date date = formatter.parse(appointment.appointmentDate);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			case Constant.APTEXTI:
				break;
			default:
				System.out.println("Invalid option....");
			}
		}
	}
}
