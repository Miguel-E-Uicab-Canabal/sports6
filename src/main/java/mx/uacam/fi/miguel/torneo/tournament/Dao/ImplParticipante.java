package mx.uacam.fi.miguel.torneo.tournament.Dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uacam.fi.miguel.torneo.tournament.Model.Participante;
import mx.uacam.fi.miguel.torneo.tournament.Repository.IParticipante;
@Service
public class ImplParticipante implements DParticipante {
	
	@Autowired
	private IParticipante repo;
	
	@Override
	public Iterable<Participante> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Participante save(Participante participante) {
		// TODO Auto-generated method stub
		return repo.save(participante);
	}

	@Override
	public Optional<Participante> findById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public void delete(int id) {
		repo.deleteById(id);
		
	}

}
