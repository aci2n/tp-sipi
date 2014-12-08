package implementacion;

import java.util.ArrayList;
import java.util.Collection;



public class Prediccion {
	
	private String sintomaBase;
	private int total;
	private Collection<ItemPrediccion> itemsPrediccion;
	
	public Prediccion (String sintomaBase) {
		this.sintomaBase=sintomaBase;
		this.total=0;
		this.itemsPrediccion = new ArrayList<ItemPrediccion>();
	}

	public void agregarItemPrediccion(String sintomaAnalisis) {
		boolean yaExiste = false;
		if (!this.sintomaBase.equals(sintomaAnalisis)){
			for (ItemPrediccion i : itemsPrediccion)
				if (i.getSintomaAnalisis().equals(sintomaAnalisis)){
					i.setCantidad(i.getCantidad()+1);
					yaExiste = true;
					break;
				}
			if (!yaExiste){
				ItemPrediccion item = new ItemPrediccion(sintomaAnalisis);
				itemsPrediccion.add(item);
			}
		}
	}	
	
	public String getSintomaBase() {
		return sintomaBase;
	}

	public void setSintomaBase(String sintomaBase) {
		this.sintomaBase = sintomaBase;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public Collection<ItemPrediccion> getItemsPrediccion() {
		return itemsPrediccion;
	}

	public void setItemsPrediccion(Collection<ItemPrediccion> itemsPrediccion) {
		this.itemsPrediccion = itemsPrediccion;
	}
	
	public void aumentarCantidad(){
		this.total++;
	}
}