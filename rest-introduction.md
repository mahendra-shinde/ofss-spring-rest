# REST Services
1. Uses Client/Server Architecture, "REST Service" acts as a "Server" and Another application would 
	act as a client.
	
2. End User will interact with REST Service via client application.

3. REST Service and Client might belong to different organization.

4. REST Service and Client application may be developed with different development stack

	example:	REST Service built in Java, but client-1 is golang app and client-2 android !

---

## Spring boot for RESTFul services

* spring-boot-starter-web for REST services
Instead of "@Controller", use @RestController

* There will no "Template pages"

* Has support for TWO content-types for REST Response:
	JSON, XML

* Request Mapping
	- @GetMapping 	(Http-Get)   Fetch / Find data

	- @PostMapping	(Http-POST)			 Create New record
	
	- @PutMapping	(Http-PUT)	 Update a record
	
	- @DeleteMapping	(Http-DELETE) Delete a record
	
## REST Services

- REpresentation State Transfer 
 Commonly used with HTTP protocol.

- REST Endpoint

	Method Type	| URL |	Request Body
	------------|-----|---------
	HTTP GET	|	http://mahendra.com/api/books/	|	{ }	
	HTTP POST	|	http://mahendra.com/api/books/	|	{ "id" : 101, "title" : "Let Us C" }
	HTTP PUT	|	http://mahendra.com/api/books/101	|{ "id" : 101, "title" : "Let Us C" }	
	HTTP PATCH	|	http://mahendra.com/api/books/101	|{ "title" : "Let Us C" }
	HTTP DELETE	|	http://mahendra.com/api/books/101	|{ }
	HTTP HEADER	|	http://mahendra.com/api/books/		|Request Headers

	




	
