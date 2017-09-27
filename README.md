camel-standalone-router
=======================

Built with Java 8+, Apache Camel (2.18.3) and Spring Boot (1.5.6.RELEASE)

Tested with JUnit (4.12)

### Docker Execution

Build Camel Standalone Router

`mvn clean install`

Start Docker

`docker-compose up`

View Application

`http://localhost:9005/info`

View ActiveMQ (_admin/admin_)

`http://localhost:8161/admin/`

View Hawtio

`http://localhost:8090/hawtio/welcome`


### Spring-Boot Execution

Build Camel Standalone Router

`mvn clean install`

Start Spring Boot - _assumes ActiveMQ is running_

`mvn spring-boot:run -Drun.arguments="-Xmx256m,-Xms128m"`

OR

`java -jar ./target/camel-standalone-router-1.0.1.jar`

View Application

`http://localhost:9005/info`

View ActiveMQ (_admin/admin_)

`http://localhost:8161/admin/`

### Testing via JMeter

Runs against ActiveMQ (5.14.0) using JMeter (2.13); requires activemq-all-5.14.0.jar in JMeter lib

Open JMeter file and execute the tests

`../camel-standalone-router/test/jmeter/Mock Camel Publisher`
