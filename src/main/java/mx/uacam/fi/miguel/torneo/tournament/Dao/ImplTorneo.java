package mx.uacam.fi.miguel.torneo.tournament.Dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.uacam.fi.miguel.torneo.tournament.Model.Torneo;
import mx.uacam.fi.miguel.torneo.tournament.Repository.ITorneo;
@Service
public class ImplTorneo implements DTorneo {
	@Autowired
	private ITorneo repo;
	@Override
	public Iterable<Torneo> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Torneo save(Torneo torneo) {
		// TODO Auto-generated method stub
		return repo.save(torneo);
	}

	@Override
	public Optional<Torneo> findById(int id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

}
