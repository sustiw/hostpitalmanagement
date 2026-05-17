package com.st.yt.hospitalManagement.dto;


import com.st.yt.hospitalManagement.type.BloodGroupType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BloodGroupCountResponseEntity {

    private BloodGroupType bloodGroup;
    private Long count;
}
