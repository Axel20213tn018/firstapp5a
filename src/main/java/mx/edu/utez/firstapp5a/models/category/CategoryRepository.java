package mx.edu.utez.firstapp5a.models.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query(value = "update categories set status = :status where id = :id", nativeQuery = true)
    boolean updateByStatusId(@Param("status") Boolean status, @Param("id") Long id);

    boolean existsByName(String name);
}
