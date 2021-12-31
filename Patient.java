package com.bl.hms;

import java.lang.reflect.MalformedParameterizedTypeException;
import java.util.Map;

public class Patient {
	enum Gender {
		MALE, FEMALE, OTHERS;
	}

	String name, address, emailID, disease, patientId;
	long mobNo, age;
	Gender gender;

	@Override
	public String toString() {
		return "Patient{" + "name='" + name + '\n' + ", address='" + address + '\n' + ", emailID='" + emailID + '\n'
				+ ", disease='" + disease + '\n' + ", patientId='" + patientId + '\n' + ", mobNo=" + mobNo + '\n'
				+ ", age=" + age + '\n' + ", gender=" + gender + '\n' + '}';
	}
}

