package Shopping.Dao;

import java.sql.*;

import Shopping.entity.Address;
import Shopping.entity.Customer;
import Shopping.entity.Product;

public class ShoppingDaoImp implements ShopingDao {
	Connection con=DbConnection.getconnection();
	int i;
	ResultSet rs=null;
	
	@Override
	public void create(Customer cust) {

		try {
			PreparedStatement pstate=con.prepareStatement("insert into shoping values(?,?,?,?,?,?,?,?,?,?)");
			pstate.setInt(1,cust.getCustId() );
			pstate.setString(2, cust.getCustName());
			pstate.setString(3,cust.getCustMobileNo());
			pstate.setInt(4,cust.getProd().getProductId());
			pstate.setString(5,cust.getProd().getProductName());
			pstate.setInt(6,cust.getProd().getProductQty());
			pstate.setFloat(7,cust.getProd().getProductPrice());
			pstate.setString(8, cust.getAddr().getCity());
			pstate.setString(9, cust.getAddr().getState());
			pstate.setInt(10, cust.getAddr().getPinCode());

			i=pstate.executeUpdate();
			if(i>0)
			{
				System.out.println("RECORD INSERTED");
			}
			else
			{
				System.out.println("RECORD NOT INSERTED");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Override
	public void Update(Customer cust,String CustMobileNo,String City,String State,int ProductQty,float ProductPrice,int CustId ) {
		try {
			
		
			PreparedStatement pstate=con.prepareStatement("update shoping set cust_mobno=?,city =?, state=?,prod_price=?,prod_Qty=? WHERE  cust_id=?  ");
			pstate.setString(1,cust.getCustMobileNo());
			pstate.setString(2, cust.getAddr().getCity());
			pstate.setString(3, cust.getAddr().getState());
			pstate.setInt(4,cust.getProd().getProductQty());
			pstate.setFloat(5,cust.getProd().getProductPrice());
			pstate.setInt(6,cust.getCustId() );
			
			rs=pstate.executeQuery();
			if(rs.next())
			{
				System.out.println("RECORDE UPDATED");
			}
			else
			{
				System.out.println("RECORDE NOT UPDATED");
			}
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}
	@Override
	public void delete(int custId) {
		try {
			PreparedStatement pstate=con.prepareStatement("delete from shoping where cust_id=(?)");
			pstate.setInt(1, custId);
			
			i=pstate.executeUpdate();
			if(i>0)
			{
				System.out.println("RECORD DELETED");
			}
			else
			{
				System.out.println("RECORD NOT DELETED");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void search(int ProductId) {
		try {
			PreparedStatement pstate=con.prepareStatement("select * from shoping where PROD_ID=(?)");
			pstate.setInt(1, ProductId);
			
			rs=pstate.executeQuery();
			
			if(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getInt(6)+"\t"+rs.getFloat(7)+"\t"+rs.getString(8)+"\t"+rs.getString(9)+"\t"+rs.getInt(10));
			}
			else
			{
				System.out.println("RECORD NOT FOUND");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public void displayall() {
		
		// TODO Auto-generated method stub
		try {
			String str="Select * from shoping";
			Statement s=con.createStatement();
			rs=s.executeQuery(str);
			
			ResultSetMetaData rsmd=rs.getMetaData();
			for(i=1;i<rsmd.getColumnCount();i++)
			{
				System.out.print(rsmd.getColumnName(i)+"\t");
			}
			System.out.println("\n-------------------------------------------------------------");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getInt(6)+"\t"+rs.getFloat(7)+"\t"+rs.getString(8)+"\t"+rs.getString(9)+"\t"+rs.getInt(10));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
