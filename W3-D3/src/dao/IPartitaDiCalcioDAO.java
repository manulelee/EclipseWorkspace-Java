package dao;

import java.util.List;

import model.PartitaDiCalcio;

public interface IPartitaDiCalcioDAO {
		
		public void save(PartitaDiCalcio p);
		public PartitaDiCalcio getById(int id);
		public void delete(PartitaDiCalcio p);
		public void update(PartitaDiCalcio p);
		public List<PartitaDiCalcio> getAll();

	}
