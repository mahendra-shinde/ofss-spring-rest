## Inversion of Control

```java
/// Regular Approach
// Traget Component "LoanService"
// Depedencies : CustomerDAO and LoanDAO
public class LoanService {
	private CustomerDAO custDao= new CustomerDAO();
	private LoanDAO loanDao = new LoanDAO();
}


//Inversion of Control
public class LoanService {
	private CustomerDAO custDao = null;
	private LoanDAO loanDao= null;
	
	// Someone else has to create instance of CustomerDAO and LoanDAO
	public LoanService(CustomerDAO custDao, LoanDAO loanDao){
		this.custDao = custDao;
		this.loanDao = loanDao;
	}
}

@Component public class CustomerDAO { ... }
@Component public class LoanDAO { ... }
//Inversion of Control : Dependency Injection
public class LoanService {
	@Autowired
	private CustomerDAO custDao ;
	
	@Autowired
	private LoanDAO loanDao ;
	
	// Receive the object references from spring
	public LoanService(CustomerDAO custDao, LoanDAO loanDao){
		this.custDao = custDao;
		this.loanDao = loanDao;
	}
}
```

1. Secure // No Vulnerabilities
2. High Performing // Reducing memory/cpu
3. *Maintainance* 

