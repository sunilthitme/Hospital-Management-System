package com.bl.hms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class DoctorRepo {
    public static DoctorRepo instance;
    private HashSet<Doctor> doctorSet = new HashSet<>();

    DoctorRepo() {
    }

    public static DoctorRepo getInstance() {
        if (instance == null) {
            instance = new DoctorRepo();
        }
        return instance;
    }

    void addDoctor(Doctor doctor) {
        doctorSet.add(doctor);
    }

    Set<Doctor> getDoctorSet() {
        return doctorSet;
    }

    public boolean isDoctorAvailable(String id) {
        for (Doctor doctor : doctorSet){
//        	System.out.println(doctor);
            if (doctor.id.equals(id)) {
                return true;
            }
        }
        return false;
    }

    public Doctor getDoctor(String id) {
        for (Doctor doctor : doctorSet) {
            if (doctor.id.equals(id)) {
                return doctor;
            }
        }
        return null;
    }


    public void remove(Doctor doctor) {
        doctorSet.remove(doctor);
    }
}

