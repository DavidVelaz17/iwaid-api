package com.iwa.iwaid.consultoriomedico.restcontrollers;

import com.iwa.iwaid.consultoriomedico.dto.MedicineDTO;
import com.iwa.iwaid.consultoriomedico.form.MedicineFiltersForm;
import com.iwa.iwaid.consultoriomedico.form.MedicineForm;
import com.iwa.iwaid.consultoriomedico.services.MedicineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping(path = "/iwaid/medicines/")
@RequiredArgsConstructor
public class MedicineController {

    private final MedicineService medicineService;

    @GetMapping
    public ResponseEntity<List<MedicineDTO>> getAllMedicinesByFilters(
    @RequestBody @ModelAttribute final MedicineFiltersForm form) {
        final List<MedicineDTO> medicines = medicineService.getAllByFilters(form);
        return ResponseEntity.ok().body(medicines);
    }

    @GetMapping("{medicineId}")
    public ResponseEntity<MedicineDTO> getMedicineById(
    @PathVariable("medicineId") final int medicineId)
        throws Exception {
        MedicineDTO medicineDTO = medicineService.getMedicineById(medicineId);
        return ResponseEntity.ok().body(medicineDTO);
    }

    @PostMapping
    public ResponseEntity<MedicineDTO> createMedicine(
    @RequestBody @Valid final MedicineForm form) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(medicineService.createMedicine(form));
    }

    @DeleteMapping("{medicineId}")
    public ResponseEntity<Void> deleteMedicine(
    @PathVariable("medicineId") final int medicineId)
        throws Exception {
        medicineService.deleteMedicine(medicineId);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("{medicineId}")
    public ResponseEntity<MedicineDTO> updateMedicine(
    @RequestBody @Valid final MedicineForm form,
    @PathVariable("medicineId") final int medicineId)
        throws Exception {
        final MedicineDTO medicineDTO = medicineService.updateMedicine(form, medicineId);
        return ResponseEntity.ok().body(medicineDTO);
    }
}
