package como.politecnicomalaga.piezas;

public class SparePart {
	int code;
	String text;
	double price;
	
	public SparePart(int code, String text, double price) {
		this.code = code;
		this.text = text;
		this.price = price;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "SparePart [code=" + code + ", text=" + text + ", price=" + price +"]";
	}
	
	
	
	
	
	

}
