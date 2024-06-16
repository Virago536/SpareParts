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
    
    //añadir sparepart al mapa
    public boolean agregarSpareParts(SparePart nuevaSpare) {
    	spareParts.put(nuevaSpare.getCode(), nuevaSpare);
    	return false;
    }
    
    public void agregarSparesMain(Map<Integer, SparePart> sparePartes) {
    	for (SparePart spareAgreg : spareParts.values()) {
            sparePartes.put(spareAgreg.getCode(), spareAgreg);
        }
    }
    
    
    //buscar sparepart
    public SparePart buscarSparePart(int code) {
    	if(spareParts.containsKey(code)) {
    		SparePart una = spareParts.get(code);
    	}
    	return null;
    }
    
    //remove sparepart
    public boolean borrarSpare(int code) {
    	if(spareParts.containsKey(code)) {
    		spareParts.remove(code);
    		return true;
    	}
    	return false;
    	
    }
    
    
	@Override
	public String toString() {
		return "Component [code=" + code + ", text=" + text + ", price=" + price + ", spareParts=" + spareParts +"]";
	}
	
}
