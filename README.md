# Descripción del proyecto
Sistema de automatización de prueba (SAP) el cual verifica un CRUD de los servicios expuestos en la pagina https://reqres.in/

# Pre-requisitos ⚙️
Tener instalado:
- [Java 11](https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html) para una correcta ejecución del proyecto

# Ejecutar escenario de prueba 🚀

Para ejecutar el CRUD de escenarios de prueba ejecuté el siguiente comando:

`./gradlew clean test --tests *Runner`


# Visualizar reportes 📋
Para acceder a los reportes puede realizarlo dirigiéndose al apartado de SERENITY REPORTS el cual podrá visualizar en consola al terminar la ejecución. Serenity proporciona dos tipos de reporte, uno completo y uno resumido

- **Reporte completo**: target/site/serenity/index.html
- **Reporte resumido:** target/site/serenity/serenity-summary.html




# Construido con 🛠️

* [Git](https://git-scm.com/downloads) para realizar el control de las versiones
* [IntelliJ](https://www.jetbrains.com/es-es/idea/download/#section=windows) como IDE de desarrollo
* [Java 11](https://www.oracle.com/co/java/technologies/javase/javase-jdk8-downloads.html) version de Java para ejecutar el SAP
* [Serenity BDD](https://serenity-bdd.github.io/docs/guide/user_guide_intro) framework utilizado para la construcción del SAP
* [Screenplay](https://serenity-bdd.github.io/docs/screenplay/screenplay_fundamentals) patron de diseño utilizado en la construcción de la SAP
* [Cucumber](https://cucumber.io/)  herramienta encargada de transformar escenarios a lenguaje máquina
* [Gherkin](https://cucumber.io/docs/gherkin/) lenguaje con el cual están escritos los escenarios de prueba
* [Gradle](https://gradle.org/install/) como gestor de dependencias