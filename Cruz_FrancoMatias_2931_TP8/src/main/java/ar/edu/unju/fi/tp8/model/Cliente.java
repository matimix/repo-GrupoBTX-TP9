package ar.edu.unju.fi.tp8.model;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
@Component("clienteObj")
@Entity
@Table(name="CLIENTES")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="emp_tipoDocumento")
	private String tipoDocumento;
	
	@Min(value=1,message="el valor para dni no debe ser inferior a 8")
	@Column(name="emp_dni")
	private int dni;
	
	
	@Size(min=3, max=150,message="El nombre y apellido debe tener como minimo 3 caracter y maximo 150")
	@Column(name="emp_nombreApellido",length = 150)
	private String nombreApellido;
	
	
	@Email(message = "debe ingresar un e-mail valido")
	@Column(name="emp_email")
	private String email;
	
	@Min(value=9,message="la contraseña debe tener al menos 9 caracteres")
	@Column(name="emp_password")
	private String password;
	@NotNull(message = "Debe ingresar una fecha valida")
	@Column(name="emp_fechaNac")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	@Column(name="emp_edad")
	
	
	private int edad;
	@Max(value = 9999, message = "El codigo de area debe tener 3 o 4 digitos")
	@Column(name="emp_codAreaTelefono")
	private int codigoAreaTelefono;
	@Column(name="emp_nroTelefono")
	private int nroTelefono;
	@Column(name="emp_fechaUltimaCompra")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaUltimaCompra;
	
	
	
	
	
	
	
	
	
	
	@Valid
	@Autowired
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cue_id")
	private Cuenta cuenta;
	
	@Valid
	@Autowired
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "prod_codigo")
	private Producto producto;
	
	//este no va era de la practica
	
	
	@ManyToMany(mappedBy="clientes")
	private List <Beneficio> beneficios= new ArrayList<Beneficio>();
	
	
	
	
	
	public Cliente() {
		super();
	}
	
	
	
	
	
	
	
	
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public int getDni() {
		return dni;
	}
	public void setDni(int dni) {
		this.dni = dni;
	}
	public String getNombreApellido() {
		return nombreApellido;
	}
	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getCodigoAreaTelefono() {
		return codigoAreaTelefono;
	}
	public void setCodigoAreaTelefono(int codigoAreaTelefono) {
		this.codigoAreaTelefono = codigoAreaTelefono;
	}
	public int getNroTelefono() {
		return nroTelefono;
	}
	public void setNroTelefono(int nroTelefono) {
		this.nroTelefono = nroTelefono;
	}
	public LocalDate getFechaUltimaCompra() {
		return fechaUltimaCompra;
	}
	public void setFechaUltimaCompra(LocalDate fechaUltimaCompra) {
		this.fechaUltimaCompra = fechaUltimaCompra;
	}
	
	
	
	
	
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	

	public String getEdadd() {
		int edad=0;
		
		LocalDate hoy = LocalDate.now();
		Period periodo = Period.between(this.fechaNacimiento,hoy);
		edad = periodo.getYears();
		
		String pe=edad+" Años";
		return pe;
		
	}
	public String cambioMay() {
		String pe;
		pe=this.nombreApellido.toUpperCase();
		
		return pe;
	}
	
public String getTUltimaCompra() {
		
		String text="";
		LocalDate hoy = LocalDate.now();
		
		LocalDate TInicioCarrera = LocalDate.of(this.fechaUltimaCompra.getYear(),this.fechaUltimaCompra.getMonth(),this.fechaUltimaCompra.getDayOfMonth());
		Period periodo = Period.between(TInicioCarrera,hoy);
		text= " Año: " + periodo.getYears() + " Mes: " + periodo.getMonths() + " Dia: " + periodo.getDays();
		
	return text;
	}
	public long TiempoEnDias() {	
	  int anio;
	  int mes;
	  int dia;
	  
	  anio=this.fechaNacimiento.getYear();
	  mes=this.fechaNacimiento.getMonthValue();
	  dia=this.fechaNacimiento.getDayOfMonth();
	  
	  System.out.println(anio);
	  System.out.println(mes);
	  System.out.println(dia);
	  Calendar timee = Calendar.getInstance();
	  
	  timee.set(anio,mes,dia);
Calendar hoy = Calendar.getInstance();
		long milisegundos = hoy.getTimeInMillis() - timee.getTimeInMillis();
		long dias = milisegundos/1000/60/60/24;
		
	     return  dias;
		
	
	
	}
	
	
	public String Thastacumple() {
		String text="";
		LocalDate hoy = LocalDate.now();
		
		int varanio;
		if(hoy.getMonthValue() < this.fechaNacimiento.getMonthValue()){
			varanio= hoy.getYear();
		}else
	      {
			varanio=hoy.getYear()+1;
	      }
		
		
		LocalDate fechaProxCumple = LocalDate.of(varanio,this.fechaNacimiento.getMonth(),this.fechaNacimiento.getDayOfMonth());
		Period periodo = Period.between(hoy, fechaProxCumple);
		text= " Año: " + periodo.getYears() + " Mes: " + periodo.getMonths() + " Dia: " + periodo.getDays();
		
		LocalDateTime ahora = LocalDateTime.now();
		LocalDateTime fechaHoraProxCumple = LocalDateTime.of(varanio, this.fechaNacimiento.getMonth(),this.fechaNacimiento.getDayOfMonth(),0,0,0);
		
		Duration duracion = Duration.between(ahora, fechaHoraProxCumple);
		
		
		
	text= text + " Hora: " + duracion.toHoursPart()+ " Min: " + duracion.toMinutesPart() + " Seg: " + duracion.toSecondsPart();	
	
	return text;	
	}
	/**
	 * @return the cuenta
	 */
	public Cuenta getCuenta() {
		return cuenta;
	}
	/**
	 * @param cuenta the cuenta to set
	 */
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}



















	public Producto getProducto() {
		return producto;
	}



















	public void setProducto(Producto producto) {
		this.producto = producto;
	}



















	@Override
	public String toString() {
		return "Cliente [id=" + id + ", tipoDocumento=" + tipoDocumento + ", dni=" + dni + ", nombreApellido="
				+ nombreApellido + ", email=" + email + ", password=" + password + ", fechaNacimiento="
				+ fechaNacimiento + ", edad=" + edad + ", codigoAreaTelefono=" + codigoAreaTelefono + ", nroTelefono="
				+ nroTelefono + ", fechaUltimaCompra=" + fechaUltimaCompra + ", cuenta=" + cuenta + ", producto="
				+ producto + ", beneficios=" + beneficios + "]";
	}
















	public List<Beneficio> getBeneficios() {
		return beneficios;
	}








	public void setBeneficios(List<Beneficio> beneficios) {
		this.beneficios = beneficios;
	}








	public Cliente(long id, String tipoDocumento,
			@Min(value = 1, message = "el valor para dni no debe ser inferior a 8") int dni,
			@Size(min = 3, max = 150, message = "El nombre y apellido debe tener como minimo 3 caracter y maximo 150") String nombreApellido,
			@Email(message = "debe ingresar un e-mail valido") String email,
			@Min(value = 9, message = "la contraseña debe tener al menos 9 caracteres") String password,
			@NotNull(message = "Debe ingresar una fecha valida") LocalDate fechaNacimiento, int edad,
			@Max(value = 9999, message = "El codigo de area debe tener 3 o 4 digitos") int codigoAreaTelefono,
			int nroTelefono, LocalDate fechaUltimaCompra, @Valid Cuenta cuenta, @Valid Producto producto,
			List<Beneficio> beneficios) {
		super();
		this.id = id;
		this.tipoDocumento = tipoDocumento;
		this.dni = dni;
		this.nombreApellido = nombreApellido;
		this.email = email;
		this.password = password;
		this.fechaNacimiento = fechaNacimiento;
		this.edad = edad;
		this.codigoAreaTelefono = codigoAreaTelefono;
		this.nroTelefono = nroTelefono;
		this.fechaUltimaCompra = fechaUltimaCompra;
		this.cuenta = cuenta;
		this.producto = producto;
		this.beneficios = beneficios;
	}















	
	
	
	
	
	



	 



}
