package tebogo.khula.khambola.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import tebogo.khula.khambola.entity.Image;

public interface StorageRepository extends JpaRepository<Image, Long>{
    Optional<Image> findByName(String fileName);
}
