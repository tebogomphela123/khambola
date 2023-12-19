package tebogo.khula.khambola.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tebogo.khula.khambola.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{
}
