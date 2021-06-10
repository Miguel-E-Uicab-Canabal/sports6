package mx.uacam.fi.miguel.torneo.tournament.Dao;

import java.util.Optional;

import mx.uacam.fi.miguel.torneo.tournament.Model.Torneo;

public interface DTorneo {
	public Iterable<Torneo> findAll();
	public Torneo save (Torneo torneo);
	public Optional<Torneo> findById(int id);
	public void delete(int id);
}
