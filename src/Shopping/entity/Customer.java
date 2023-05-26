package Shopping.entity;

public class Customer {


	private int custId;
	private String custName;
	private String custMobileNo;
	private Address addr;    // REFERENCE
	private Product prod;    // REFERENCE   TO CUSTOMER..

	public Customer(int custId, String custName, String custMobileNo, Address addr, Product prod) {
		super();
		this.custId = custId;
		this.custName = custName;
		this.custMobileNo = custMobileNo;
		this.addr = addr;
		this.prod = prod;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustMobileNo() {
		return custMobileNo;
	}

	public void setCustMobileNo(String custMobileNo) {
		this.custMobileNo = custMobileNo;
	}

	public Address getAddr() {
		return addr;
	}

	public void setAddr(Address addr) {
		this.addr = addr;
	}

	public Product getProd() {
		return prod;
	}

	public void setProd(Product prod) {
		this.prod = prod;
	}


}
