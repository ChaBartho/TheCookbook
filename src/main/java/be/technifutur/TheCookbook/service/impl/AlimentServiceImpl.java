package be.technifutur.TheCookbook.service.impl;

import be.technifutur.TheCookbook.form.AlimentForm;
import be.technifutur.TheCookbook.mapper.AlimentMapper;
import be.technifutur.TheCookbook.model.dto.AlimentDTO;
import be.technifutur.TheCookbook.model.entity.Aliment;
import be.technifutur.TheCookbook.repository.AlimentRepository;
import be.technifutur.TheCookbook.service.AlimentService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AlimentServiceImpl implements AlimentService {
   private AlimentRepository alimentRepository;
   private AlimentMapper alimentMapper;

    public AlimentServiceImpl(AlimentRepository alimentRepository, AlimentMapper alimentMapper) {
        this.alimentRepository = alimentRepository;
        this.alimentMapper = alimentMapper;
    }

    @Override
    public void createAliment(AlimentForm form) {
        Aliment entity = form.toEntity();
        alimentRepository.save(entity);
    }

    @Override
    public AlimentDTO getAliment(Long id) {
        return alimentRepository.findById(id)
                .map(alimentMapper::toDto)
                .orElseThrow();
    }

    @Override
    public List<AlimentDTO> getAllAliments() {
        return alimentRepository.findAll()
                .stream()
                .map(alimentMapper::toDto)
                .toList();
    }

    @Override
    public void deleteAliment(Long id) {
        alimentRepository.delete(alimentRepository.findById(id).orElseThrow());
    }
}
