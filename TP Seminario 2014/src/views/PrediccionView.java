package views;

import java.util.Collection;



public class PrediccionView {
	private String sintomaBase;
	private float total;
	private Collection<ItemPrediccionView> itemsPrediccion;
	
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
	public Collection<ItemPrediccionView> getItemsPrediccion() {
		return itemsPrediccion;
	}
	public void setItemsPrediccion(Collection<ItemPrediccionView> itemsPrediccion) {
		this.itemsPrediccion = itemsPrediccion;
	}
}
