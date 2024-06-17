package como.politecnicomalaga.piezas;

import java.util.HashMap;
import java.util.Map;

public class Component extends SparePart{
	
	private Map <Integer,SparePart> spareParts;
	
	public Component(int code, String text, double price) {
		super(code, text, price);
		this.spareParts = new HashMap<>();
	}

    private Map<Integer, SparePart> getSpareParts() {
        return spareParts;
    }
    
    //añadir sparepart al mapa
    public boolean agregarSparePart(SparePart nuevaSpare) {
    	spareParts.put(nuevaSpare.getCode(), nuevaSpare);
    	if(spareParts.containsValue(nuevaSpare)) {
    		return true;
    	}else {
    		return false;
    	}
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
    		return una;
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
		String resultado = "Component [code=" + code + ", text=" + text + ", price=" + price + ", spareParts=";
		
		
		String mapaString="";
		
		for(SparePart spareMeter : spareParts.values()) {
			mapaString += spareMeter.toString();
		}
		return resultado + mapaString+"]";
	}

    
	
	
	
	
	
}

