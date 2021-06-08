package ar.edu.unju.fi.tp8.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * clase principal con sus atributos y constructores
 * @author Familia
 *
 */

@Component

@Entity
@Table(name="COMPRAS")
public class Compra {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(name="com_cantidad")
	private int cantidad;
	@Column(name="com_total")
	private double total;
	
	@OneToMany(mappedBy="compra")
	private List<Producto> productos = new ArrayList<Producto>();
	
	
	@Autowired
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="prod_codigo")
	
	private Producto producto;
	
	public Compra() {
		
	}


	


	public long getId() {
		return id;
	}





	public void setId(long id) {
		this.id = id;
	}





	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public double getTotal() {
		return total;
	}


	public void setTotal(double total) {
		this.total = total;
	}
	
	
	


	


	public List<Producto> getProductos() {
		return productos;
	}
	
	





	




	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	
	





	public Producto getProducto() {
		return producto;
	}





	public void setProducto(Producto producto) {
		this.producto = producto;
	}





	@Override
	public String toString() {
		return "Compra [id=" + id + ", cantidad=" + cantidad + ", total=" + total + ", productos=" + productos
				+ ", producto=" + producto + "]";
	}





	





	
	
	
	
	
	

}
