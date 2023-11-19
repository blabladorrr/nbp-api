package pl.edu.pjwstk.nbpapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.pjwstk.nbpapi.model.Rate;

public interface NbpApiRepository extends JpaRepository<Rate, Integer> {
    Rate save(Rate rate);
}
