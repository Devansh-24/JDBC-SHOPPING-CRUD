package Shopping.Dao;

import Shopping.entity.Address;
import Shopping.entity.Customer;
import Shopping.entity.Product;

public interface ShopingDao {

	public void create(Customer cust);
	public void Update(Customer cust,String CustMobileNo,String City,String State,int ProductQty,float ProductPrice,int CustId);
	public void delete(int custId);
	public void search(int ProductId);
	public void displayall();		
	
}
