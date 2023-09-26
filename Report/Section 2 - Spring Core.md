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
- Bean Scopes, [Ref](https://docs.spring.io/spring-framework/docs/3.0.0.M3/reference/html/ch04s04.html)
    - Config method:
        - XML (legacy)
        - Spring annotation
    - Scopes:
        - Singleton (default): one instance only of the class will be created
        
        ```java
        class SomeClass {
        	private Class aClass;
        	private Class anotherClass;
        }
        // if the class is defined as singleton, aClass and anotherClass point to the same object.
        ```
        
        - Prototype:
            - A new instance will be created every time it is requested from the container.
            - Not having  `destroy` method in the lifecycle
            - By default, it is Lazy Init.
        - Web-aware scopes (only available in a web-aware app)
            - Request: create an instance for each HTTP request
            - Session: create an instance for each HTTP session
            - Global Session
        - Application: create an instance for each lifecycle of a `ServletContext` (check later)
        - WebSocket (later)
    - When to use: singleton for static (e.g., db-connection, dao,…), prototype for stateful (not knowing example yet)
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