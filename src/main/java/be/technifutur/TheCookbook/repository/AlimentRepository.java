package be.technifutur.TheCookbook.repository;

import be.technifutur.TheCookbook.model.entity.Aliment;
import org.hibernate.sql.ast.tree.expression.AliasedExpression;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlimentRepository extends JpaRepository<Aliment, Long> {
//    List<Aliment> findByIngredientId(Long id);
}
