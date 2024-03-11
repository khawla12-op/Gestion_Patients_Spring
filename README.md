Ce projet Spring illustre les fonctionnalités d'une application Spring typique. Notre application utilise la classe Hibernate, qui implémente l'interface JPA (Java Persistence API). Cette dernière est utilisée par Spring Data pour simplifier l'accès aux données dans notre application.
<img width="990"   alt="Capture d’écran 2023-03-11 à 17 04 14" src="https://github.com/khawla12-op/Gestion_Patients_Spring/assets/108635784/9dd857a9-ea9c-4052-b144-4739e68beb0e" >

### 1. Créer un projet Spring Initializer
   - Utilisez Spring Initializer pour créer un nouveau projet Spring Boot.
   - Ajoutez les dépendances suivantes : JPA, H2, Spring Web et Lombok.


### 2. Créer l'entité JPA Patient
   - Créez une classe `Patient` avec les attributs spécifiés (`id`, `nom`, `dateNaissance`, `malade`, `score`).
   - Annotez la classe avec `@Entity` pour la mapper à une table dans la base de données.
   - Utilisez les annotations JPA (`@Id`, `@GeneratedValue`, etc.) pour spécifier la clé primaire et les autres contraintes.

### 3. Configuration de l'unité de persistance
   - Dans le fichier `application.properties`, configurez les propriétés de connexion à la base de données H2.
   - Assurez-vous que les propriétés suivantes sont correctement définies :

### 4. Créer l'interface JPA Repository
   - Créez une interface `PatientRepository` étendant `JpaRepository<Patient, Long>`.
   - Cette interface hérite de toutes les méthodes CRUD de `JpaRepository` permettant de manipuler les données `Patient`.

### 5. Tester les opérations de gestion de patients

### 6. Migration de H2 Database vers MySQL
   - Dans le fichier `application.properties`, modifiez les configurations pour utiliser MySQL au lieu de H2.
   - Mettez à jour les propriétés de connexion avec les informations appropriées pour MySQL.
 


