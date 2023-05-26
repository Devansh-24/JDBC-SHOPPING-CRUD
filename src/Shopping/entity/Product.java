package Shopping.entity;

public class Product {

	private int ProductId;
	private String ProductName;
	private int ProductQty;
	private float ProductPrice;


	public Product(int productId, String productName, int productQty, float productPrice) {
		super();
		ProductId = productId;
		ProductName = productName;
		ProductQty = productQty;
		ProductPrice = productPrice;
	}


	public int getProductId() {
		return ProductId;
	}


	public void setProductId(int productId) {
		ProductId = productId;
	}


	public String getProductName() {
		return ProductName;
	}


	public void setProductName(String productName) {
		ProductName = productName;
	}


	public int getProductQty() {
		return ProductQty;
	}


	public void setProductQty(int productQty) {
		ProductQty = productQty;
	}


	public float getProductPrice() {
		return ProductPrice;
	}


	public void setProductPrice(float productPrice) {
		ProductPrice = productPrice;
	}




}
