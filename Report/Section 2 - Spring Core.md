# Section 2 - Spring Core

# Thought

# Learned - Spring Core

- IoC:
    - the approach of outsourcing the construction & management of objects, Spring IoC Container will handle those for us ⇒ needn’t instantiate objects manually.
    - ‘inverse’ means we won’t manage the object but the framework will do that
    - Advantages: decoupling, easier to switch between different implementations, easier unit test (mocking)…
- Dependency injections:
    - a pattern used to implement IoC
    - client delegates to another object (`ApplicationContext` [represents Spring IoC container](https://www.baeldung.com/inversion-control-and-dependency-injection-in-spring#:~:text=We%20most%20often%20use%20it,calls%20to%20our%20custom%20code.)) the responsibility of providing its dependencies
- DI in Spring
    - Injection types
    - require the injecting class to have `@Component` annotation ⇒ mark that class become a Spring bean, which will be available for the Spring container
    - require the to-be-injected class to have `@Autowired` annotation ⇒ tell Spring to inject a dependency here
        - Constructor injection: used when having required dependencies
        - Setter injection: used when having optional dependencies?
        - Field injection (legacy): no longer recommended because of difficulty to unit test.
    - Component Scanning:
        - Def:
            - finding the dependency matched the class/interface that has annotation `@Component`
            - implemented in `org.springframework.boot.autoconfigure.SpringBootApplication`
        - Scope:
            - default to scan just within the package holding the main SB app, including sub-packages
            - for other packages than main: explicitly list in the `@SpringBootApplication`
    - Autowiring
        - 1 implementation: mentioned above
        - multiple implementations, use
            - `@Qualifier`:
                - in the to-be-injected class
                - more recommended because of its specificity
                - point to the bean id of the class we want to wire (camel case of class name)
                - has higher priority than `@Primary`
            - `@Primary`:
                - in the injecting class (doesn’t allow multiple)
                - less recommended
- Lazy Initialization: by default, Spring initializes all Beans on start. We can use lazy initialization to reduce the start-up time of the app via
    - `@Lazy` annotation
    - Config in `application.properties`
- Bean Scopes
    - Scopes:
        - Singleton (default)
        - Prototype
        - Request
        - Session
        - Global Session
    - Config using `@Scope` annotation
- Bean lifecycle:
    - container start ⇒ bean instantiated ⇒ deps injected ⇒ internal Spring processing (?) ⇒ **************************our custom init logic************************** ⇒ bean is ready for use ⇒ container is shutdown ⇒ ************our custom destroy logic************ ⇒ app stop
    - use cases: open db connection/close db connection
    - using `@PostConstruct` and `@PreDestroy` annotation
- Another way to enable DI in our code
    - Using when we can’t modify the to-be-injected classes (3rd-party jar,…)
    - Steps:
        - Create `@Configuration` class
        - Define `@Bean` method to configure the bean
        - Inject using `@Qualifier`

# Question

1. Setter injection: used when having optional dependencies? What is an optional deps, use case?
2. Read bean scopes later