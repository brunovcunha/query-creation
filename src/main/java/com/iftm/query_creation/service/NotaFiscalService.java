package com.iftm.query_creation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iftm.query_creation.DTO.NotaFiscalDTO;
import com.iftm.query_creation.domain.NotaFiscal;
import com.iftm.query_creation.repository.NotaFiscalRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NotaFiscalService {

    @Autowired
    private NotaFiscalRepository notaFiscalRepository;

    public List<NotaFiscalDTO> findAllByDescontoInexists() {
        return notaFiscalRepository.findAllByDescontoInexists().stream()
                .map(NotaFiscalDTO::new)
                .collect(Collectors.toList());
    }

    public List<NotaFiscalDTO> findAllByDescontoExists() {
        return notaFiscalRepository.findAllByDescontoExists().stream()
                .map(NotaFiscalDTO::new)
                .collect(Collectors.toList());
    }

    public List<NotaFiscalDTO> findAllByOrderByValorUnit() {
        return notaFiscalRepository.findAllByOrderByValorUnitDesc().stream()
                .map(NotaFiscalDTO::new)
                .collect(Collectors.toList());
    }

    public List<NotaFiscalDTO> findMaxProdInNf() {
        return notaFiscalRepository.findMaxProdInNf().stream()
                .map(NotaFiscalDTO::new)
                .collect(Collectors.toList());

    }

    public List<NotaFiscalDTO> findQuantGreaterThenTen()  {
        return notaFiscalRepository.findByQuantidadeGreaterThan(10).stream()
                .map(NotaFiscalDTO::new)
                .collect(Collectors.toList());
    }

    public List<NotaFiscalDTO> findNotasFiscaisComTotalMaiorQue500() {
        return notaFiscalRepository.findNotasFiscaisComTotalMaiorQue500().stream()
            .map(NotaFiscalDTO::new)
            .collect(Collectors.toList());
    }

    public List<NotaFiscalDTO> findAll() {
        return notaFiscalRepository.findAll().stream()
                .map(NotaFiscalDTO::new)
                .collect(Collectors.toList());
    }

    public Optional<NotaFiscalDTO> findById(Long id) {
        return notaFiscalRepository.findById(id)
                .map(NotaFiscalDTO::new);
    }

    public NotaFiscalDTO save(NotaFiscalDTO notaFiscalDTO) {
        NotaFiscal notaFiscal = new NotaFiscal();
        notaFiscal.setId(notaFiscalDTO.getId());
        notaFiscal.setIdNf(notaFiscalDTO.getIdNf());
        notaFiscal.setIdItem(notaFiscalDTO.getIdItem());
        notaFiscal.setCodProd(notaFiscalDTO.getCodProd());
        notaFiscal.setValorUnit(notaFiscalDTO.getValorUnit());
        notaFiscal.setQuantidade(notaFiscalDTO.getQuantidade());
        notaFiscal.setDesconto(notaFiscalDTO.getDesconto());
        NotaFiscal savedNotaFiscal = notaFiscalRepository.save(notaFiscal);
        return new NotaFiscalDTO(savedNotaFiscal);
    }

    public void deleteById(Long id) {
        notaFiscalRepository.deleteById(id);
    }
}

