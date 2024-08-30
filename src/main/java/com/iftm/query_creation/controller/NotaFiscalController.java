package com.iftm.query_creation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.iftm.query_creation.DTO.NotaFiscalDTO;
import com.iftm.query_creation.service.NotaFiscalService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/nota-fiscal")
public class NotaFiscalController {

    @Autowired
    private NotaFiscalService notaFiscalService;

    @GetMapping
    public List<NotaFiscalDTO> getAllNotaFiscais() {
        return notaFiscalService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotaFiscalDTO> getNotaFiscalById(@PathVariable Long id) {
        Optional<NotaFiscalDTO> notaFiscal = notaFiscalService.findById(id);
        return notaFiscal.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public NotaFiscalDTO createNotaFiscal(@RequestBody NotaFiscalDTO notaFiscalDTO) {
        return notaFiscalService.save(notaFiscalDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotaFiscalDTO> updateNotaFiscal(@PathVariable Long id, @RequestBody NotaFiscalDTO notaFiscalDTO) {
        if (!notaFiscalService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        notaFiscalDTO.setId(id);
        return ResponseEntity.ok(notaFiscalService.save(notaFiscalDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNotaFiscal(@PathVariable Long id) {
        if (!notaFiscalService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        notaFiscalService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

