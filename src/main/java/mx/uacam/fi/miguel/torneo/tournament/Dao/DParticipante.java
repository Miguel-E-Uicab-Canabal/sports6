package mx.uacam.fi.miguel.torneo.tournament.Dao;

import java.util.Optional;

import mx.uacam.fi.miguel.torneo.tournament.Model.Participante;

public interface DParticipante {
	public Iterable<Participante> findAll();
	public Participante save (Participante participante);
	public Optional<Participante> findById(int id);
	public void delete(int id);
}
