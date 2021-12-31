package com.bl.hms;

import java.util.HashMap;
import java.util.Map;

public class Doctor {

    enum WeekDays{
        SUNDAY, MONDAY,TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
    }

    String docName, specialization, emailID, id;
    long mobNo;
    Map<WeekDays,String> availability;

    @Override
    public String toString() {
        return "Doctor{" +
                "docName='" + docName + '\n' +
                ", specialization='" + specialization + '\n' +
                ", emailID='" + emailID + '\n' +
                ", id='" + id + '\n' +
                ", mobNo=" + mobNo + '\n' +
                ", availability=" + availability + '\n' +
                '}';
    }
}