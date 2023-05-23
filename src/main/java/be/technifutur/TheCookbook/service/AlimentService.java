package be.technifutur.TheCookbook.service;

import be.technifutur.TheCookbook.form.AlimentForm;
import be.technifutur.TheCookbook.model.dto.AlimentDTO;

import java.util.List;

public interface AlimentService {
    void createAliment(AlimentForm form);
    AlimentDTO getAliment(Long id);
    List<AlimentDTO> getAllAliments();
    void deleteAliment(Long id);
}
