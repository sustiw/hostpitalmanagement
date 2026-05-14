package com.st.yt.hospitalManagement.entity;

import com.st.yt.hospitalManagement.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@ToString
@Setter
@Getter
@Table(name = "patient",
        uniqueConstraints = {
                // @UniqueConstraint(name = "unique_pateint_email", columnNames = {"email"}),
                @UniqueConstraint(name = "unique_patient_name_birthDate", columnNames = {"name", "birth_date"})
        },
        indexes = {
                @Index(name = "idex_patient_birth_date", columnList = "birthDate")
        }

)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "name", length = 40)
    private String name;

    @Column(name = "birth_date")
    @ToString.Exclude
    private LocalDate birthDate;

    @Column(nullable = false, unique = true, name = "email")
    private String email;

    @Column(name = "gender")
    private String gender;

    @CreationTimestamp
    @Column(updatable = false, name = "create_at")
    private LocalDateTime createAt;

    @Column(name = "blood_group")
    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

}
