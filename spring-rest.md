## Spring rest demo

- New Spring boot project with "Spring Web" dependency only


- For JSON Data format : No Need of any dependency or config  !!!

- For XML Data Format
	1.  Model class MUST implement "Serializable" interface
	2.  For Java-8, use new dependency in "build.gradle" or "pom.xml" file
		```groovy
		implementation com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.13.0
		```
	
	3. For Java-11 Onwards, add TWO dependencies
	
		```groovy
		implementation com.fasterxml.jackson.dataformat:jackson-dataformat-xml:2.13.0
		
		implementation javax.xml.bind:jaxb-api:2.3.0
		```

	4. Inside "Rest Controller" class use new "produces" type
		produces="application/xml"
		
---
Content Negotiations

Client 1  request response in XML or JSON	
Client 2  request response in JSON or XML
Client 3  request response in PDF		ERROR > Content Negotition error !

When client request data in XML or JSON, Server will check for "XML" response type
	if not found, then search for JSON.

Content Negotiation : Client & Server will decide "What" to return based on "Client's" request and server response parameters.

