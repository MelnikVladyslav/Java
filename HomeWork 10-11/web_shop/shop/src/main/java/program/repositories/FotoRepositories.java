package program.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import program.entities.CategoryEntity;

@Repository
public interface FotoRepository extends JpaRepository<FotoEntity, Integer> {
}