package como.politecnicomalaga.piezas;

import java.util.HashMap;
import java.util.Map;

public class Component extends SparePart{
	
	Map <Integer,SparePart> spareParts;
	
	public Component(int code, String text, double price) {
		super(code, text, price);
		this.spareParts = new HashMap<>();
	}

    public Map<Integer, SparePart> getSpareParts() {
        return spareParts;
    }

	@Override
	public String toString() {
		return "Component [code=" + code + ", text=" + text + ", price=" + price + ", spareParts=" + spareParts +"]";
	}

    
	
	
	
	
	
}
