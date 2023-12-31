package com.iwa.iwaid.consultoriomedico.dto;

import com.iwa.iwaid.consultoriomedico.entity.Doctor;
import com.iwa.iwaid.consultoriomedico.entity.Specialty;
import lombok.Builder;
import lombok.Getter;
import org.jsondoc.core.annotation.ApiObjectField;

@Getter
@Builder
public class DoctorDTO {
    @ApiObjectField(name = "id", description = "Doctor's id")
    private int id;

    @ApiObjectField(name = "name", description = "Doctor's name")
    private String name;

    @ApiObjectField(name = "specialty", description = "Doctor's specialty")
    private Specialty specialty;

    @ApiObjectField(name = "address", description = "Doctor's address")
    private String address;

    @ApiObjectField(name = "phoneNumber", description = "Doctor's phone number")
    private String phoneNumber;

    @ApiObjectField(name = "email", description = "Doctor's email")
    private String email;

    @ApiObjectField(name = "password", description = "Doctor's password")
    private String password;

    public static DoctorDTO build(final Doctor doctor) {
        return DoctorDTO.builder()
                .id(doctor.getId())
                .name(doctor.getName())
                .specialty(doctor.getSpecialty())
                .address(doctor.getAddress())
                .phoneNumber(doctor.getPhoneNumber())
                .email(doctor.getEmail())
                .password(doctor.getPassword())
                .build();
    }
}
