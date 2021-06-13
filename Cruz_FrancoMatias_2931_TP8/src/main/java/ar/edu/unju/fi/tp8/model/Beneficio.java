package ar.edu.unju.fi.tp8.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="BENEFICIOS")

public class Beneficio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ben_id") 
	private long id;
	@Column(name="ben_descripcion") 
	private String descripcion;
	
	@ManyToMany
	@JoinTable(name="beneficios_clientes",
	   joinColumns=@JoinColumn(name = "ben_id"),
	    inverseJoinColumns= @JoinColumn(name="emp_id"))
	 private List<Cliente> clientes = new ArrayList<Cliente >();

	public Beneficio() {
		super();
	}

	public Beneficio(long id, String descripcion, List<Cliente> clientes) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.clientes = clientes;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	@Override
	public String toString() {
		return "Beneficio [id=" + id + ", descripcion=" + descripcion + ", clientes=" + clientes + "]";
	}











}
