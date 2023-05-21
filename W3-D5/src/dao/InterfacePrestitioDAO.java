package dao;

import java.util.List;

import model.Prestito;

public interface InterfacePrestitioDAO {
	
	public void aggiungi (Prestito p);

	public List<Prestito> prestitiDaTessera (String tessera);
	
	public List<Prestito> prestitiNonRestituiti (String tessera);
}
