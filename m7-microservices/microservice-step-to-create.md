Step1 :corexFin-Registry Service :

Dependency : <dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
		</dependency>
---
Properties :

spring.application.name=registry-service

server.port=8761


#This tells the application not to register itself with the Eureka server
eureka.client.register-with-eureka=false
#This tells the application not to fetch the list of services from the Eureka server.
eureka.client.fetch-registry=false

---
Access :List of all microservices which is defaultzone with this server
http://localhost:8761/
---
@SpringBootApplication
@EnableEurekaServer
public class RegistryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistryServiceApplication.class, args);
	}

}
---

Step 2 : api-gateway:main entry

---
dependency
---

        <dependency>
		<groupId>org.springframework.cloud</groupId>
		<artifactId>spring-cloud-starter-gateway</artifactId>
	  </dependency>

        <dependency>
		<groupId>org.springframework.cloud</groupId>
		<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
	  </dependency>

---
Properties
---
spring.application.name=gateway-service

server.port=9090
#Configuring department-service-registered
spring.cloud.gateway.routes[0].id=DEPARTMENT-SERVICE
spring.cloud.gateway.routes[0].uri=lb://DEPARTMENT-SERVICE
spring.cloud.gateway.routes[0].predicates[0]=Path=/department/**

#Configuring employee-service
spring.cloud.gateway.routes[1].id=EMPLOYEE-SERVICE
spring.cloud.gateway.routes[1].uri=lb://EMPLOYEE-SERVICE
spring.cloud.gateway.routes[1].predicates[0]=Path=/employee/**

##The line spring.cloud.gateway.discovery.locator.enabled=true allows the gateway to automatically route requests to services registered with Eureka, avoiding the need to manually define every route.
spring.cloud.gateway.discovery.locator.enabled=true
##This ensures that the service IDs are converted to lowercase, which can be useful for consistency when matching routes.
spring.cloud.gateway.discovery.locator.lower-case-service-id=true

eureka.client.service-url.defaultZone: http://localhost:8761/eureka/

---

Step3: Add your multiplu microservice 

	1: department-service

dependency :

		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-openfeign</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-loadbalancer</artifactId>
		</dependency>

--- 

Properties :

spring.application.name=DEPARTMENT-SERVICE

server.port=8081


eureka.client.service-url.defaultZone: http://localhost:8761/eureka/

---
	2: employee-service

---

dependency : 
	
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-loadbalancer</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-openfeign</artifactId>
		</dependency>
---

Properties : 

---

#Database configuration
spring.datasource.url=jdbc:postgresql://localhost:5432/restdb
spring.datasource.username=postgres
spring.datasource.password=Tca@admin
spring.datasource.driver-class-name=org.postgresql.Driver

# Hibernate properties
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.show.sql=true
spring.jpa.properties.hibernate.format_sql=true

#instead of ddl-auto
#spring.jpa.hibernate.ddl-auto=none
#spring.sql.init.mode=always


---

.
.
.
.
.
.
.
	n. services:
	
dependency : same as above
Properties : same as above


















