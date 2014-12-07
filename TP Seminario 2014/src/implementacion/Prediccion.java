package implementacion;

import java.util.ArrayList;
import java.util.Collection;

import views.ItemPrediccionView;
import views.PrediccionView;



public class Prediccion {
	
	private String sintomaBase;
	private float total;
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

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Collection<ItemPrediccion> getItemsPrediccion() {
		return itemsPrediccion;
	}

	public void setItemsPrediccion(Collection<ItemPrediccion> itemsPrediccion) {
		this.itemsPrediccion = itemsPrediccion;
	}

	public Proyeccion generarProyeccion(){
		Proyeccion proyeccion = new Proyeccion(sintomaBase);
		for (ItemPrediccion i : itemsPrediccion)
			proyeccion.agregarItemProyeccion(i.getSintomaAnalisis(),(i.getCantidad()/total)*100);
		return proyeccion;
	}
	
	public void aumentarCantidad(){
		this.total++;
	}
	
	public PrediccionView generarView() {
		PrediccionView view = new PrediccionView();
		Collection<ItemPrediccionView> itemsPrediccionView = new ArrayList<ItemPrediccionView>();
		for (ItemPrediccion item : itemsPrediccion) {
			itemsPrediccionView.add(item.generarView());
		}
		view.setItemsPrediccion(itemsPrediccionView);
		view.setSintomaBase(sintomaBase);
		view.setTotal(total);
		return view;
	}
}