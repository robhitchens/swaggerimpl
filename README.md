#Swagger Implementation example (and spring-boot dev-tools):
- [annotation resource](https://github.com/swagger-api/swagger-core/wiki/Annotations-1.5.X)
- added dev-tools to make spring-boot application development faster, [link](https://dev.to/suin/spring-boot-developer-tools-how-to-enable-automatic-restart-in-intellij-idea-1c6i) to some additional intellij setup. 
### Steps to setup spring-boot dev-tools:
1. add dependency
    ```xml
    <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-devtools</artifactId>
       <optional>true</optional>
    </dependency>
    ```
2. In intellij toggle build project automatically
3. Toggle on intellij registry option compiler.automake.allow.when.app.running.
4. Add maven configuration for mvn spring-boot:run as shown here [link](https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-running-your-application.html)
5. Step 4 may not be needed, can simply click run on main function and any modified classes (or any included files) will be recompiled and loaded into the running instance. You can add an Application Configuration in intellij and point to the main class to run the app.