package com.iftm.query_creation.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.iftm.query_creation.DTO.NotaFiscalDTO;
import com.iftm.query_creation.service.NotaFiscalService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/nota-fiscal", produces = "application/json")
@Tag(name = "nota-fiscal")
public class NotaFiscalController {

    @Autowired
    private NotaFiscalService notaFiscalService;
    
    @GetMapping()
    public List<NotaFiscalDTO> getAllNotaFiscais() {
        return notaFiscalService.findAll();
    }

    @GetMapping("/sem-desconto")
    public List<NotaFiscalDTO> findAllByDescontoInexists() {
        return notaFiscalService.findAllByDescontoInexists();
    }

    @GetMapping("/com-desconto")
    public List<NotaFiscalDTO> findAllByDescontoExists() {
        return notaFiscalService.findAllByDescontoExists();
    }

    @GetMapping("/valor-unitario")
    public List<NotaFiscalDTO> findAllOrderByValorUnit() {
        return notaFiscalService.findAllByOrderByValorUnit();
    }
    
    @GetMapping("/produto-mais-vendido")
    public List<NotaFiscalDTO> findMaxProdInNf() {
        return notaFiscalService.findMaxProdInNf();
    }

    @GetMapping("/produto-maior-que-10")
    public List<NotaFiscalDTO> findQuantGreaterThenTen() {
        return notaFiscalService.findQuantGreaterThenTen();
    }

    @GetMapping("/notas-valor-maior-que-500")
    public List<NotaFiscalDTO> findNotasFiscaisComTotalMaiorQue500() {
        return notaFiscalService.findNotasFiscaisComTotalMaiorQue500();
    }

    @Operation(description = "Retorna nota por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "retorna a nota"),
            @ApiResponse(responseCode = "400", description = "não existe a nota com o id informado")
    })
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

