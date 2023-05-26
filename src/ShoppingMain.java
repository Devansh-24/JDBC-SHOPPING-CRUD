import java.sql.Statement;
import java.util.Scanner;

import Shopping.Dao.ShopingDao;
import Shopping.Dao.ShoppingDaoImp;
import Shopping.entity.Address;
import Shopping.entity.Customer;
import Shopping.entity.Product;

public class ShoppingMain {



	public static void main(String[] args) {

		ShopingDao sd=new ShoppingDaoImp();

		Scanner sc=new Scanner(System.in);
		int ch;
		int custId,ProductId = 0,ProductQty,pinCode = 0;
		String custName = null,custMobileNo,ProductName = null,city,state;
		float ProductPrice;
		
		
		do
		{
			System.out.println("\n1-CREATE\n2-UPDATE\n3-DELETE\n4-SEARCH\n5-DISPLAY");
			System.out.println("ENTER YOUR CHOICE:-\n");
			ch=sc.nextInt();
			switch(ch)
			{
			case 1:
				System.out.println("ENTER CUSTOMER ID ");
				custId=sc.nextInt();
				System.out.println("ENTER CUSTOMER NAME ");
				custName=sc.next();
				System.out.println("ENTER CUSTOMER MOBILE NUMBER");
				custMobileNo=sc.next();

				System.out.println("ENTER THE PRODUCT ID :");
				ProductId =sc.nextInt();
				System.out.println("ENTER THE PRODUCT NAME:");
				ProductName=sc.next();
				System.out.println("ENTER THE PRODUCT QUANTITY:");
				ProductQty=sc.nextInt();
				System.out.println("ENTER THE PRODUCT PRICE:");
				ProductPrice=sc.nextFloat();

				System.out.println("ENTER THE CUSTOMER CITY ");
				city=sc.next();
				System.out.println("ENTER THE CUSTOMER STATE ");
				state=sc.next();
				System.out.println("ENTER THE CUSTMOER PINCODE");
				pinCode=sc.nextInt();

				Product pro=new Product(ProductId, ProductName, ProductQty, ProductPrice);
				Address addr =new Address(city, state, pinCode);
				Customer cust=new Customer(custId, custName, custMobileNo, addr, pro);
				sd.create(cust);
				break;
			case 2:
				System.out.println("ENTER CUSTOMER MOBILE NUMBER");
				custMobileNo=sc.next();
				System.out.println("ENTER THE CUSTOMER CITY ");
				city=sc.next();
				System.out.println("ENTER THE CUSTOMER STATE ");
				state=sc.next();
				System.out.println("ENTER THE PRODUCT QUANTITY:");
				ProductQty=sc.nextInt();
				System.out.println("ENTER THE PRODUCT PRICE:");
				ProductPrice=sc.nextFloat();
				System.out.println("ENTER CUSTOMER ID ");
				custId=sc.nextInt();
				
				pro=new Product(ProductId, ProductName, ProductQty, ProductPrice);
				addr=new Address(city, state, pinCode);
				cust=new Customer(custId, custName, custMobileNo, addr, pro);
				sd.Update(cust, custMobileNo, city, state, ProductQty, ProductPrice, custId);
				break;
			case 3:
				System.out.println("ENTER CUSTOMER ID ");
				custId=sc.nextInt();
				sd.delete(custId);
				break;
			case 4:
				System.out.println("ENTER PRODUCT ID ");
				 ProductId=sc.nextInt();	
				 sd.search(ProductId);
				 break;
			case 5:
				  
              sd.displayall();
				break;
			}
			System.out.println("DO YOU WANT TO CONTINUE..PRESS.YES");
		}while(sc.next().equalsIgnoreCase("yes"));


	}

}
