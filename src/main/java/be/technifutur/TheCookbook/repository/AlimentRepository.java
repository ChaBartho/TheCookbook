package be.technifutur.TheCookbook.repository;

import be.technifutur.TheCookbook.model.entity.Aliment;
import be.technifutur.TheCookbook.model.entity.Recipe;
import org.hibernate.sql.ast.tree.expression.AliasedExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AlimentRepository extends JpaRepository<Aliment, Long> {
//    @Query('select * from Aliment a where lower(a.name) like concat(lower(:name),'%") and a.deleted = false order by a.name asc")
    Optional<Aliment> searchAliment (@Param("name") String name);
}
