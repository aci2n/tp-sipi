package implementacion;

import java.util.ArrayList;
import java.util.Collection;

public class Proyeccion {
	private String sintomaBase;
	private Collection<ItemProyeccion> itemsProyeccion;	
	
	public Proyeccion(String sintomaBase) {
		super();
		this.sintomaBase = sintomaBase;
		this.itemsProyeccion = new ArrayList<ItemProyeccion>();
	}
	
	public String getSintomaBase() {
		return sintomaBase;
	}
	public void setSintomaBase(String sintomaBase) {
		this.sintomaBase = sintomaBase;
	}

	public Collection<ItemProyeccion> getItemsProyeccion() {
		return itemsProyeccion;
	}

	public void setItemsProyeccion(Collection<ItemProyeccion> itemsProyeccion) {
		this.itemsProyeccion = itemsProyeccion;
	}

	public void agregarItemProyeccion(String sintomaAnalisis, float f) {
		this.itemsProyeccion.add(new ItemProyeccion(sintomaAnalisis,f));
	}	
}