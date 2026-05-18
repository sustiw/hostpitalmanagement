package com.st.yt.hospitalManagement.repository;

import com.st.yt.hospitalManagement.dto.BloodGroupCountResponseEntity;
import com.st.yt.hospitalManagement.entity.Patient;
import com.st.yt.hospitalManagement.type.BloodGroupType;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    String bloodGroupQuery = """
            select p from Patient  p where p.bloodGroup=?1
            """;
    String birthDateQuery = """
            SELECT p from Patient p where p.birthDate > :birthDate
            """;

    String countByBloodGroup = """
            select  p.bloodGroup , count(*)
            from Patient p
            where p.bloodGroup is not null
            group by p.bloodGroup
            """;

    String countByBloodGroupupdated = """
            SELECT new com.st.yt.hospitalManagement.dto.BloodGroupCountResponseEntity(p.bloodGroup, count(p.id)) 
            FROM Patient p GROUP BY p.bloodGroup
            """;

    String fidAllPatient = """
            select * from patient
            """;

    String updatePatientName = """
            update Patient p set p.name= :name where p.id= :id
            """;

    Patient findByName(String name);

    List<Patient> findByBirthDateOrEmail(LocalDate birthDate, String email);

    List<Patient> findByNameContaining(String name);

    @Query(bloodGroupQuery)
    List<Patient> findByBloodGroup(@Param("bloodGroup") BloodGroupType bloodGroup);

    @Query(birthDateQuery)
    List<Patient> findByBornAfterDate(@Param("birthDate") LocalDate birthDate);

//    @Query(countByBloodGroup)
//    List<Object[]> countEachBloodGroupType();


    @Query(countByBloodGroupupdated)
    List<BloodGroupCountResponseEntity> countEachBloodGroupType();

    @Query(value = fidAllPatient, nativeQuery = true)
    List<Patient> findAllPatient();

    @Transactional
    @Modifying
    @Query(updatePatientName)
    int updatePatentNameWithId(@Param("name") String name, @Param("id") Long id);


    //using pagination
    @Query(value = fidAllPatient, nativeQuery = true)
    Page<Patient> findAllPatient(Pageable pageable);

}
