package dao;

import java.util.List;

import model.GaraDiAtletica;

public interface IGaraAtleticaDAO {

	public void save(GaraDiAtletica g);
	public GaraDiAtletica getById(int id);
	public void delete(GaraDiAtletica g);
	public void update(GaraDiAtletica g);
	public List<GaraDiAtletica> getAll();

}
