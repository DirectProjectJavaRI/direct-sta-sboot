# direct-sta-sboot

Security and Trust Agent Standalone Spring Boot Micro-service Application based on Direct Java RI8

## Build Component
This project is using maven pom.xml file for the build lifecyle.

`mvn clean install`

## Running Component
To run thins project locally with default configuration:

`java -jar direct-sta-sboot-<version>.jar`

For a custom configuration please use externalized `application.properties` along with the JAR file.

## Microservice health check

## Microservice containerization
Microservice application should be built and ready to deploy using `mvn clean isntall` command or full package built form `direct-ri-build-microsrvcs` project.

To create docker image or `sta` run command below:

`docker build -t sta:latest .`

When running created image containerized microservice will start on default port `8083` with default `admin` user and `direct` password.

## Dependencies
Running:
- `config-service` microservice with specified connection to it in the `Dockerfile`
- `msg-monitor` microservice with specified connection to it in the `Dockerfile`
- `xd` endpoint with specified connection to it in the `Dockerfile`
- `rabbitmq` message broker with specified connection to it in the `Dockerfile`

Default domain:
- domain should be added to the database through the `config-servce` or `config-ui`