package com.iwa.iwaid.consultoriomedico.dto;

import com.iwa.iwaid.consultoriomedico.entity.MedicalHistory;
import lombok.Builder;
import lombok.Getter;
import org.jsondoc.core.annotation.ApiObjectField;

@Getter
@Builder
public class MedicalHistoryDTO {

    @ApiObjectField(name = "id", description = "Medical history ID")
    private int id;

    @ApiObjectField(name = "patientId", description = "Patient's ID")
    private int patientId;

    @ApiObjectField(name = "patient", description = "Patient's data")
    private PatientDTO patient;

    @ApiObjectField(name = "height", description = "Patient's height")
    private int height;

    @ApiObjectField(name = "weight", description = "Patient's weight")
    private float weight;

    @ApiObjectField(name = "familyMedicalHistory", description = "Patient's family medical history")
    private boolean familyMedicalHistory;

    @ApiObjectField(name = "specificFamilyMedicalHistory", description = "Patient's specific family medical history")
    private String specificFamilyMedicalHistory;

    @ApiObjectField(name = "pathologicalHistory", description = "Patient's pathological history")
    private boolean pathologicalHistory;

    @ApiObjectField(name = "specificPathologicalHistory", description = "Patient's specific pathological history")
    private String specificPathologicalHistory;

    @ApiObjectField(name = "nonPathologicalHistory", description = "Patient's non pathological history")
    private boolean nonPathologicalHistory;

    @ApiObjectField(name = "specificNonPathologicalHistory", description = "Patient's specific non pathological history")
    private String specificNonPathologicalHistory;

    public static MedicalHistoryDTO build(final MedicalHistory medicalHistory) {
        return MedicalHistoryDTO.builder()
                .id(medicalHistory.getId())
                .patientId(medicalHistory.getPatientsId())
                .height(medicalHistory.getHeight())
                .weight(medicalHistory.getWeight())
                .familyMedicalHistory(medicalHistory.isFamilyMedicalHistory())
                .specificFamilyMedicalHistory(medicalHistory.getSpecificFamilyMedicalHistory())
                .pathologicalHistory(medicalHistory.isPathologicalHistory())
                .specificPathologicalHistory(medicalHistory.getSpecificPathologicalHistory())
                .nonPathologicalHistory(medicalHistory.isNonPathologicalHistory())
                .specificNonPathologicalHistory(medicalHistory.getSpecificNonPathologicalHistory())
                .build();
    }

    public static MedicalHistoryDTO build(final MedicalHistory medicalHistory, final PatientDTO patient) {
        return MedicalHistoryDTO.builder()
                .id(medicalHistory.getId())
                .patientId(medicalHistory.getPatientsId())
                .patient(patient)
                .height(medicalHistory.getHeight())
                .weight(medicalHistory.getWeight())
                .familyMedicalHistory(medicalHistory.isFamilyMedicalHistory())
                .specificFamilyMedicalHistory(medicalHistory.getSpecificFamilyMedicalHistory())
                .pathologicalHistory(medicalHistory.isPathologicalHistory())
                .specificPathologicalHistory(medicalHistory.getSpecificPathologicalHistory())
                .nonPathologicalHistory(medicalHistory.isNonPathologicalHistory())
                .specificNonPathologicalHistory(medicalHistory.getSpecificNonPathologicalHistory())
                .build();
    }
}
