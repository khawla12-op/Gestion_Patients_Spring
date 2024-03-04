package ma.enset.gestion_patients.repositories;

import ma.enset.gestion_patients.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

//c'est spring data
public interface PatientRepository extends JpaRepository <Patient,Long>{
    //On declare les methodes qu'on veut implementer
    public List<Patient> findByMalade(boolean malade);
    //Pagination d'une methode implementee
    Page<Patient> findByMalade(boolean malade, Pageable pageable);

}