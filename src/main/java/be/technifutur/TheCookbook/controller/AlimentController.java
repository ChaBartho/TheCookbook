package be.technifutur.TheCookbook.controller;

import be.technifutur.TheCookbook.form.AlimentForm;
import be.technifutur.TheCookbook.model.dto.AlimentDTO;
import be.technifutur.TheCookbook.service.AlimentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/aliment")
public class AlimentController {
    private final AlimentService alimentService;
    public AlimentController(AlimentService alimentService) {
        this.alimentService = alimentService;
    }
    @PostMapping("/add")
    public void create(@RequestBody @Valid AlimentForm form) {
        alimentService.createAliment(form);
    }
    @GetMapping("/{id:[0-9]+}")
    public AlimentDTO getOne(@RequestBody @PathVariable("id")  Long id) throws Exception {
        try {
            return alimentService.getAliment(id);
        } catch (Exception e){
            throw new Exception();
        }
    }
    @GetMapping("/all")
    public List<AlimentDTO> getAll(){
        return alimentService.getAllAliments();
    }
    @DeleteMapping("/delete/{id:[0-9]+}")
    public void delete(@PathVariable Long id){
        alimentService.deleteAliment(id);
    }

}
