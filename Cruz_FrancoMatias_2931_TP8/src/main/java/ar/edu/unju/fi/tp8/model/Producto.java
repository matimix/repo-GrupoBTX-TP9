package ar.edu.unju.fi.tp8.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;



@Component
@Entity
@Table(name="PRODUCTOS")
public class Producto {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long codigo;
	
	@NotEmpty(message="el campoppppppppp")
	@NotNull(message="no puede ser nulo")
	@Column(name="prod_nombre")
	private String nombre;
	@Column(name="prod_precio")
	private double precio;
	@Column(name="prod_marca")
	private String marca;
	@Column(name="prod_stock")
	private int stock;
	
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name="com_id")
   private Compra compra;

public Producto() {
		super();
	}











public Producto(long codigo,String nombre, double precio,
		String marca, int stock, Compra compra) {
	super();
	this.codigo = codigo;
	this.nombre = nombre;
	this.precio = precio;
	this.marca = marca;
	this.stock = stock;
	this.compra = compra;
}











public long getCodigo() {
	return codigo;
}



public void setCodigo(long codigo) {
	this.codigo = codigo;
}



/**
 * @return the nombre
 */
public String getNombre() {
	return nombre;
}



/**
 * @param nombre the nombre to set
 */
public void setNombre(String nombre) {
	this.nombre = nombre;
}



/**
 * @return the precio
 */
public double getPrecio() {
	return precio;
}



/**
 * @param precio the precio to set
 */
public void setPrecio(double precio) {
	this.precio = precio;
}



/**
 * @return the marca
 */
public String getMarca() {
	return marca;
}



/**
 * @param marca the marca to set
 */
public void setMarca(String marca) {
	this.marca = marca;
}



/**
 * @return the stock
 */
public int getStock() {
	return stock;
}



/**
 * @param stock the stock to set
 */
public void setStock(int stock) {
	this.stock = stock;
}








public Compra getCompra() {
	return compra;
}



public void setCompra(Compra compra) {
	this.compra = compra;
}











@Override
public String toString() {
	return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", precio=" + precio + ", marca=" + marca + ", stock="
			+ stock + ", compra=" + compra + "]";
}




	




	
	
	




}
