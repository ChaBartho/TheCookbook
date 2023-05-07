package be.technifutur.TheCookbook.repository;

import be.technifutur.TheCookbook.model.entity.Aliment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlimentRepository extends JpaRepository<Aliment, Long> {
}
