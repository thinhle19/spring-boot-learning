# Section 1 2 3 - Quick Start + Spring Core + Hibernate

# Thought

# Learned

## Quick Start

- Spring Boot & Spring
    - Why Spring: Spring is a Java framework for creating web apps, web API, and microservices,… mostly via its annotations. It supports similar abilities to what .NET provides.
    - Why Spring Boot: Help to develop traditional Spring faster (configure dependencies, embedded server,…)
    - Differences: Spring Boot uses Spring behind-the-scenes
- Run 1st Spring Boot app from scratch
    - Spring Initializer: The website helps to generate the skeleton of a Spring Boot project, by selecting wanting abilities on the UI ⇒ saves lots of time
    - Run CLI / IDE: use the Maven command or `java -jar` command
- Standard directory structure (by Maven)
    - `src/main/java` Java source code
    - `src/main/resources`: library
        - `/application.properties`: storing application’s configs
            - Spring Boot properties: core (logging…), web (server, port,…), actuator, db.,… More than +1000 properties are provided out there
            - Custom application properties: user-defined properties for their usage.
    - `/src/main/webapp`: for files like JSP, JS, HTML, CSS, or assets
    - `/src/test` & `/src/test/resources`
    - `target`: build output
    - `pom.xml`: Project Object Model, storing configuration for the project, details will be at the Maven section
- Starter & Starter parent
    - Spring Boot starter:
        - like a combo that contains regular-used together dependencies ⇒ giving the name of starter in pom.xml will install all dependencies inside it ⇒ less configuration. E.g., starter-web, starter-actuator, starter-security… (30+ out there)
        - can view what is inside using the Dependencies view of IDE
    - Spring Boot starter parent:
        - a special project that provides **************default************** config for app ⇒  other dependencies will use information from that parent, for example, we defined the version for the starter parent, other dependencies won’t need to specify the version, they will take the version declared in the parent
- DevTools + with IntelliJ: a dependency helps our project auto restart on change. Specify this in the POM + some setting in IntelliJ to enable the auto-reload ability
- Actuator:
    - dependencies that provided lots of monitoring, health checks, and metric endpoints by default.
    - Use it with Spring Security to make these endpoints available with those with valid credentials only. Spring Security has a default user and password (via CLI when running) and we can override it also
- Maven: release the application build guts
    - Why Maven: dependencies management, we needn’t find jar dependencies and then configure them to the classpath. Just list all that we need and Maven will download + add to the path at build and runtime for us
    - How does it work?:
        - read config file ⇒ check local repo <yes> ⇒ use it
        - read config file ⇒ check local repo <no> ⇒ get from remote repo ⇒ store to local repo (like cache) ⇒ use it
    - Key concepts
        - pom file
            - project coordinates: name, version, output types,…
            - dependencies
        - wrapper file: works like Gradle wrapper ⇒ helps run Maven command without actually having Maven, or to ensure consistency version in the project that have many people
- Beans:
    - fundamental need to know when working with Spring
    - Java objects that are made when the app starts by the Spring framework (config, service, connection, anything,…) are controlled by the Spring IoC container

# Question

1. Back to the Dockerfile before, if it’s a Spring Boot app, can I just run `java -jar` rather than `gradle run` for starting the Spring boot app?
2. Not question but a note about Spring behind architecture & Bean. Will re-read them on the way

# Progress

- 22/9: finished the Section 1 - Quick start, I've played around but there are just concepts, no need to keep in the repo.