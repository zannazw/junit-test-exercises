package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HospitalTest {

    private Hospital hospital;

    @BeforeEach
    void setUp() {
        this.hospital = new Hospital(2);
    }

    @Test
    void shouldReturnFalse_whenPatientIsAddedAndNoBedsAreAvailable() {
        //given
        hospital.add(new Patient("Luca"));
        hospital.add(new Patient("Tommy"));
        //when & then
        assertEquals(false, hospital.add(new Patient("Polly")));
    }

    @Test
    void shouldReturnFalse_whenAlreadyExistingPatientIsAdded() {
        //given
        Patient luca = new Patient("Luca");
        hospital.add(luca);
        //when & then
        assertEquals(false, hospital.add(luca));
    }

    @Test
    void shouldAddPatientAndReturnTrue_whenMethodIsCalled() {
        //given, when & then
        assertTrue(hospital.add(new Patient("Arthur")));
    }

    @Test
    void shouldReturnIncreasedPatientCount_whenPatientWasAdded() {
        int patientCountBefore = hospital.patientCount();
        hospital.add(new Patient("John"));
        assertNotEquals(patientCountBefore, hospital.patientCount());
    }

    @Test
    void contains() {
    }

    @Test
    void patientCount() {
    }

    @Test
    void healNextPatient() {
    }

    @Test
    void hasPatients() {
    }
}