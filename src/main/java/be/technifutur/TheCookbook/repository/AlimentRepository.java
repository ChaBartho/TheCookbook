package be.technifutur.TheCookbook.repository;

import be.technifutur.TheCookbook.model.entity.Aliment;
import org.hibernate.sql.ast.tree.expression.AliasedExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.Optional;

public interface AlimentRepository extends JpaRepository<Aliment, Long> {
//    @Query('select * from Aliment a where lower(a.name) like concat(lower(:name),'%") and a.deleted = false order by a.name asc")
//    Optional<Aliment> searchAliment (@Param("name") String name);
    @Query("SELECT a FROM Aliment a WHERE LOWER(a.name) LIKE CONCAT(LOWER(:name), '%') AND a.deleted = false ORDER BY a.name ASC")
    Optional<Aliment> searchAliment(@Param("name") String name);

//    @Query("select a from Aliment a where lower(a.name) = lower(:name) and a.deleted = false order by a.name asc")
//    Optional<Aliment> searchAliment (@Param("name") String name);
}
