package ar.edu.unju.fi.tp4.model;

import static java.time.temporal.ChronoUnit.DAYS;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Table(name="CLIENTES")
@Component("clienteObj")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cte_id")
	private Long id;
	
	@NotEmpty(message="El tipo no puede estar vacio")
	@Column(name="cte_tipo_doc")
	private String tipoDocumento;
	
	@Min(value = 1,message="El minimo valor es 1")
	@Column(name="cte_num_doc")
	private int numeroDocumento;
	
	@NotEmpty(message="Este campo no puede estar vacio")
	@Column(name="cte_nya")
	private String nombreApellido;
	
	@Email(message="Ingrese un email valido")
	@Column(name="cte_email")
	private String email;
	
	@NotEmpty(message="Este campo debe ser completado")
	@Column(name="cte_password")
	private String password;
	
	@NotNull(message="Este campo debe ser completado")
	@Column(name="cte_fecha_nac")
	@DateTimeFormat(pattern = "yyyy-MM--dd")
	private LocalDate fechaNacimiento;
	
	@Min(value = 12, message="Ingrese un valor mayor a 12")
	@Column(name="cte_edad")
	private int edad;
	
	@Min(value = 1, message="Ingrese un valor mayor a 1")
	@Column(name="cte_cod_area")
	private int codigoAreaTelefono;
	
	@Min(value = 1, message="Ingrese un valor mayor a 1")
	@Column(name="cte_num_telefono")
	private int numeroTelefono;
	
	@NotNull(message="Este campo debe ser completado")
	@Column(name="cte_fecha_ult_compra")
	@DateTimeFormat(pattern = "yyyy-MM--dd")
	private LocalDate fechaUltimaCompra;
	
	@Autowired
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cta_id" )
	private Cuenta cuenta;
	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Cuenta getCuenta() {
		return cuenta;
	}
	public void setCuenta(Cuenta cuenta) {
		this.cuenta = cuenta;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public int getNumeroTelefono() {
		return numeroTelefono;
	}
	public void setNumeroTelefono(int numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public int getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(int numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getNombreApellido() {
		
		return nombreApellido;
	}
	public String getMayuscula() {		
		String may;
		may = this.nombreApellido;
		may = may.toUpperCase();	
		return may;
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

	public int getCodigoAreaTelefono() {
		return codigoAreaTelefono;
	}
	public void setCodigoAreaTelefono(int codigoAreaTelefono) {
		this.codigoAreaTelefono = codigoAreaTelefono;
	}
	public LocalDate getFechaUltimaCompra() {
		return fechaUltimaCompra;
	}
	public void setFechaUltimaCompra(LocalDate fechaUltimaCompra) {
		this.fechaUltimaCompra = fechaUltimaCompra;
	}
	public Cliente() {
		super();
	}
	
	
	public Cliente(String tipoDocumento, int numeroDocumento, String nombreApellido, String email, String password,
			LocalDate fechaNacimiento, int codigoAreaTelefono, int numeroTelefono, LocalDate fechaUltimaCompra) {
		super();
		this.tipoDocumento = tipoDocumento;
		this.numeroDocumento = numeroDocumento;
		this.nombreApellido = nombreApellido;
		this.email = email;
		this.password = password;
		this.fechaNacimiento = fechaNacimiento;
		this.codigoAreaTelefono = codigoAreaTelefono;
		this.numeroTelefono = numeroTelefono;
		this.fechaUltimaCompra = fechaUltimaCompra;
	}
	// calcular la edad
	public int getEdad() {
		
		int edad =0;
		LocalDate hoy =LocalDate.now();
		Period periodo = Period.between(this.fechaNacimiento, hoy);
		edad = periodo.getYears();
		return edad;
	}
	// proximo cumpleaños
	public String getTimeCumple() {
		String texto =" ";
		LocalDate hoy =LocalDate.now();
		int varanio;
		if(hoy.getMonthValue() < this.fechaNacimiento.getMonthValue()) {
			varanio =hoy.getYear();
		}else {
			varanio = hoy.getYear() + 1; 
				
		}
		
		LocalDate fechaProxCumple = LocalDate.of(varanio ,this.fechaNacimiento.getMonth(), this.fechaNacimiento.getDayOfMonth());
		Period periodo = Period.between(hoy, fechaProxCumple);
		texto= "Año:"+ periodo.getYears() + "Mes:" + periodo.getMonths() + "Dia:" + periodo.getDays();
		
		//localTime
		LocalDateTime ahora= LocalDateTime.now();
		LocalDateTime fechaHoraProxCumple = LocalDateTime.of(varanio, this.fechaNacimiento.getMonth(), this.fechaNacimiento.getDayOfMonth(), 0,0,0);
		Duration duracion = Duration.between(ahora, fechaHoraProxCumple);
		texto = texto + "Hora:" + duracion.toHoursPart()+ "Min:" + duracion.toMinutesPart() + "Seg:" + duracion.toSecondsPart();
		
				return texto;
	}
	// tiempo desde Nacimiento
	public int getTimeNaciMiento() {
		LocalDate hoy =LocalDate.now();
		LocalDate Inicio=this.fechaNacimiento;
		LocalDate Fin=hoy;	
		long dias = DAYS.between(Inicio, Fin);	
		return (int) dias;
	
	}
	// tiempo desde Ultima Compra
	public String getTimeUltimaC() {
		LocalDate hoy = LocalDate.now();
		LocalDate Inicio=this.fechaUltimaCompra;
		LocalDate Fin=hoy;
		Period periodo = Period.between(Inicio, Fin);
		String fecha = " Año: " + periodo.getYears() + " Mes: " + periodo.getMonths() + " Dia: " + periodo.getDays();
		return fecha;
	}
	
		
	@Override
	public String toString() {
		return "Cliente [tipoDocumento=" + tipoDocumento + ", numeroDocumento=" + numeroDocumento + ", nombreApellido="
				+ nombreApellido + ", email=" + email + ", password=" + password + ", fechaNacimiento="
				+ fechaNacimiento + ", edad=" + edad + ", codigoAreaTelefono=" + codigoAreaTelefono
				+ ", numeroTelefono=" + numeroTelefono + ", fechaUltimaCompra=" + fechaUltimaCompra + "]";
	}
	
}
