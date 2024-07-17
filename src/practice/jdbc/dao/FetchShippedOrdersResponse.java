package practice.jdbc.dao;

/**
 * Response Model For the data returned by the Query Execution
 */
public class FetchShippedOrdersResponse {
	
	private int orderId;
	private String orderDate;
	private float orderTotal;
	
	// Constructors
	public FetchShippedOrdersResponse() {
		super();
	}

	public FetchShippedOrdersResponse(int orderId, String orderDate, float orderTotal) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderTotal = orderTotal;
	}
	
	// Getters and Setters
	public int getOrderId() {
		return orderId;
	}
	
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	
	public String getOrderDate() {
		return orderDate;
	}
	
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	public float getOrderTotal() {
		return orderTotal;
	}
	
	public void setOrderTotal(float orderTotal) {
		this.orderTotal = orderTotal;
	}

	@Override
	public String toString() {
		return "Response [orderId=" + orderId + ", orderDate=" + orderDate + ", orderTotal="
				+ orderTotal + "]";
	}
	
}
