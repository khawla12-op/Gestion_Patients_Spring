package ma.enset.gestion_patients.repositories;

import lombok.Data;
import ma.enset.gestion_patients.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

//c'est spring data
public interface PatientRepository extends JpaRepository <Patient,Long>{
    //On declare les methodes qu'on veut implementer
    public List<Patient> findByMalade(boolean malade);
    //Pagination d'une methode implementee
    Page<Patient> findByMalade(boolean malade, Pageable pageable);
    List <Patient> findByMaladeAndScoreLessThan(boolean malade,int score);
    List <Patient> findByMaladeIsTrueAndScoreLessThan(int score);
    List <Patient> findByDateNaissanceBetweenAndMaladeIsTrueOrNomLike(Date d1 , Date d2,String nom);
    @Query("select p from Patient p where p.dateNaissance between :x and :y or  p.nom like:z" )
    List <Patient> chercherPatients(@Param("x") Date d1 , @Param("y")Date d2 ,@Param("z") String nom);
}
