# Thought

- JPA is similar to EntityFramework
- JPQL is similar to LINQ

# Learned - Spring Core

- JPA
    - Jakarta Persistence API, standard API for ORM
    - popular implementations are Hibernate, EclipseLink & Apache OpenJPA
    - benefits: by having a standard API, we are not locked to any vendor’s implementation
- Hibernate:
    - framework for persisting/saving Java objects to the database
    - default impl of JPA in SB
    - benefits:
        - minimize JDBC code
        - provide ORM
- JDBC: Hibernate/JPA uses JDBC for all database communications
- Entity class:
    - java class that is mapped to a db table
    - must be annotated with `@Entity`
    - must have public or protected no-args ctor
- ID auto Generation Strategies
    - 4 default
    - able to create custom strategies
- JPA Entity Manager: main component for creating queries
- @Transactional: required for manipulating queries
- @Repository: enable component scanning
- JPQL:
    - similar function with LINQ
    - based on entity name and entity field
- Having @Table and @Column annotation is optional but recommended, for easier when we later need to refactor the code.
- We do have config on auto dropping or creating tables from Java Code

# Question

- Find more reasons for using `@Repository` annotation other than for component scanning.
- Do they have code first/db first approaches?