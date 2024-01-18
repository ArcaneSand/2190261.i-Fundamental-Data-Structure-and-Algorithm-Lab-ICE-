public class Account {
    private String accountId;
    private String accountName;
    private TransactionManager transactionManager;
    private double balance;

    public Account(String accountId, String accountName) {
    	// Put your code here
    	this.accountId = accountId;
    	this.accountName = accountName;
    	/*the account must register the singeleton of transactionManager 
    	since it a static we call get instance from the Class itself(TransactionManager)*/
    	transactionManager =  TransactionManager.getInstance();	
    }

    public void deposit(double amount) throws NegativeAmountException {
    	// Put your code here
    	testPositiveAmount(amount);//test amount is positive? see the method below
    	
    	balance+=amount;
    	
    	//save the log of transfer format with string format %s represent following string variable after the first string
    	String format = String.format("DEPOSIT - Amount: %s - Account ID: %s", amount,accountId);
    	transactionManager.logTransaction(format); 	
    }

    public void withdraw(double amount) throws NegativeAmountException, InsufficientAmountException {
    	// Put your code here
    	testPositiveAmount(amount);//test amount is positive? see the method below
    	
    	if(balance-amount < 0 ) {
    		throw new InsufficientAmountException("You too broke man");
    	}
    	
    	balance-=amount; 
    	
    	//save the log of transfer format with string format %s represent following string variable after the first string
    	String format = String.format("WITHDRAWAL - Amount: %s - Account ID: %s", amount,accountId);
    	transactionManager.logTransaction(format);
    }

    public void transfer(Account targetAccount, double amount) throws NegativeAmountException, InsufficientAmountException {
    	// Put your code here
    	testPositiveAmount(amount);//test amount is positive? see the method below
    	
    	if(balance-amount < 0 ) {
    		throw new InsufficientAmountException("You too broke man");
    	}
    	
    	balance -= amount;
    	
    	targetAccount.recieveTransfer(amount);//modify the balance of targetAccount. see method below
    	
    	//save the log of transfer format with string format %s represent following string variable after the first string
    	String format = String.format("TRANSFER - Amount: %s - From Account ID: %s - To Account ID: %s", amount,accountId,targetAccount.accountId);
    	transactionManager.logTransaction(format);
    }
    
    //since we can't simply use deposit because it will leave the another log of targetAccount deposit, 
    //we need to directly modify the balance of targetAccount.
    public void recieveTransfer(double amount) {
    	balance += amount;
    }

    public double getBalance() {
        return balance;
    }
    
    public String getAccountId() {
    	return accountId;
    }
    
    //test for amount negative
    private void testPositiveAmount(double amount) throws NegativeAmountException {
    	if(amount<0) throw new NegativeAmountException("Negative amont");
    }

}