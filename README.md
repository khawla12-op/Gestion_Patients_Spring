Ce projet Spring illustre les fonctionnalités d'une application Spring typique. Notre application utilise la classe Hibernate, qui implémente l'interface JPA (Java Persistence API). Cette dernière est utilisée par Spring Data pour simplifier l'accès aux données dans notre application.

### 1. Créer un projet Spring Initializer
   - Utilisez Spring Initializer pour créer un nouveau projet Spring Boot.
   - Ajoutez les dépendances suivantes : JPA, H2, Spring Web et Lombok.
   - Expliquez comment créer un projet Spring Initializer en mentionnant les dépendances ajoutées et leur utilité dans le projet.

### 2. Créer l'entité JPA Patient
   - Créez une classe `Patient` avec les attributs spécifiés (`id`, `nom`, `dateNaissance`, `malade`, `score`).
   - Annotez la classe avec `@Entity` pour la mapper à une table dans la base de données.
   - Utilisez les annotations JPA (`@Id`, `@GeneratedValue`, etc.) pour spécifier la clé primaire et les autres contraintes.
   - Expliquez l'importance de cette entité dans le contexte de la persistance des données et comment les annotations JPA sont utilisées pour mapper l'entité à la base de données.

### 3. Configuration de l'unité de persistance
   - Dans le fichier `application.properties`, configurez les propriétés de connexion à la base de données H2.
   - Assurez-vous que les propriétés suivantes sont correctement définies :
     ```
     spring.datasource.url=jdbc:h2:mem:testdb
     spring.datasource.driverClassName=org.h2.Driver
     spring.datasource.username=sa
     spring.datasource.password=password
     spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
     ```
   - Expliquez ces configurations et comment elles permettent à l'application de se connecter à la base de données H2 en mémoire.

### 4. Créer l'interface JPA Repository
   - Créez une interface `PatientRepository` étendant `JpaRepository<Patient, Long>`.
   - Cette interface hérite de toutes les méthodes CRUD de `JpaRepository` permettant de manipuler les données `Patient`.
   - Expliquez l'importance de cette interface en tant que couche d'accès aux données et comment elle simplifie les opérations de persistance.

### 5. Tester les opérations de gestion de patients
   - Écrivez des tests unitaires pour chaque opération CRUD à l'aide de JUnit et Mockito.
   - Dans ces tests, utilisez `@Autowired` pour injecter `PatientRepository` et effectuez les opérations CRUD.
   - Expliquez comment ces tests garantissent le bon fonctionnement des opérations de gestion de patients.

### 6. Migration de H2 Database vers MySQL
   - Dans le fichier `application.properties`, modifiez les configurations pour utiliser MySQL au lieu de H2.
   - Mettez à jour les propriétés de connexion avec les informations appropriées pour MySQL.
   - Expliquez chaque étape de la migration, notamment comment les configurations changent pour passer de H2 à MySQL.

En suivant ces étapes et en fournissant des explications claires dans votre fichier README, les autres développeurs pourront comprendre facilement comment le projet est mis en place et comment effectuer la migration de H2 vers MySQL.
