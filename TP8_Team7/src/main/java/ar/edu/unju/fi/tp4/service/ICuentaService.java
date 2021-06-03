package ar.edu.unju.fi.tp4.service;
import java.util.List;
import ar.edu.unju.fi.tp4.model.Cuenta;

public interface ICuentaService {
	
	public void guardarCuenta(Cuenta cuenta);
	public List<Cuenta> getCuentas();
	public Cuenta getCuenta();

}
