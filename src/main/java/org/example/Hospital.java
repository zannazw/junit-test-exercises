package org.example;

import java.util.LinkedList;

public class Hospital {
    private final int numberOfBeds;
    private final LinkedList<Patient> patients = new LinkedList<>();

    Hospital(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    boolean add(Patient patient) {
        if (noBedsAvailable()) {
            return false;
        }
        if (contains(patient)) {
            return false;
        }
        patients.addLast(patient);
        return true;
    }

    boolean contains(Patient patient) {
        return patients.contains(patient);
    }

    private boolean noBedsAvailable() {
        return patientCount() >= numberOfBeds;
    }

    int patientCount() {
        return patients.size();
    }

    Patient healNextPatient() {
        if (hasPatients()) {
            return patients.removeFirst();
        }
        throw new HospitalException("No patients available.");
    }

    boolean hasPatients() {
        return !patients.isEmpty();
    }
}
