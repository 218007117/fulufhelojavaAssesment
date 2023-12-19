package za.co.etalente.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import za.co.etalente.data.model.Investor;

public interface InvestorRepository extends JpaRepository<Investor, Integer> {
}
