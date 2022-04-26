## Spring Framework

JavaEE was Huge, most of the time, JAVAEE server had features/components not needed for application.

Spring framework gives you "alternative" to Java EE
1. Modular Framework
	Choice of using the modules need in application.

2. No Standard Java EE Server needed.
	Spring boot has feature: "Embedded Server"

3. Large developer community.

---

## Spring Boot
 1. Generates the project structure with all components needed. 
 2. Convention over configuration. (Smart Default)
 Example:
 	A "Web" project will have
 		1. Embedded Tomcat
 		2. Server port = 8080

## Creating Spring Boot project	
1. Launch Spring toolsuite
2. Create new "Spring Starter Project"

	```yml
	projectname: demo-1
	Language: Java
	Packaging: Jar
	Build : Gradle / Maven
	Java Version : 8 / 11
	
	dependencies: web, thymeleaf
	```
	

### Typical Folder structure

```yml
src/main/java:		
	Java code
src/main/resources:	
	Properties/ Files that dont compile !!

src/test/java:		
	Unit Test cases
src/test/resources:	
	Properties for TEST	

src/main/resources/static:
	Static Web components CSS, HTML, JS, JPG, PNG 

src/main/resources/templates:
	Thymeleaf pages (html)
```

 
