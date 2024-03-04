package ma.enset.gestion_patients;

import ma.enset.gestion_patients.entities.Patient;
import ma.enset.gestion_patients.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.awt.print.Pageable;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class GestionPatientsSpringApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(GestionPatientsSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for(int i=1; i<=100; i++){
            patientRepository.save(
                    new Patient(null, "khaoula", new Date(), false, (int)(Math.random()*1000)));
        }
        patientRepository.save(
                new Patient(null, "Hassan", new Date(), false, 30));
        patientRepository.save(
                new Patient(null, "khaoula", new Date(), false, 30));
        patientRepository.save(
                new Patient(null, "Mohammed", new Date(), false, 100));
        //Principe de pagination pour ne pas retourner toutes les pages
        //Afficher la liste des patients
        //Cet objet de type page retourne le nombre specifie de page
        Page<Patient> patients = patientRepository.findAll(PageRequest.of(0,5));
        System.out.println("Total pages:"+patients.getTotalPages());
        System.out.println("Total elements:"+patients.getTotalElements());
        System.out.println("Numero de la page :"+patients.getNumber());
        //retourner la liste des patients:
        //content est la liste des patients
        List <Patient> content = patients.getContent();
        Page<Patient> byMalade = patientRepository.findByMalade(true,PageRequest.of(0,5));
        //pour afficher les personne malade
        byMalade.forEach(p -> {System.out.println(p.getNom());
        });

        content.forEach(p -> {System.out.println(p.getId());
        System.out.println(p.getNom());
        System.out.println(p.getScore());
        System.out.println(p.getDateNaissance());
        System.out.println(p.isMalade());
        });
        System.out.println("*******************");
        //Trouver un patient by id
        Patient patient= patientRepository.findById(3L).orElse(null);
        if(patient!=null) {
            System.out.println(patient.getNom());
            System.out.println(patient.isMalade());
        }
        // Mettre a jour un patient
        patient.setScore(150);
        patientRepository.save(patient);
        //Supprimer un patient
        patientRepository.deleteById(2L);
    }
}

