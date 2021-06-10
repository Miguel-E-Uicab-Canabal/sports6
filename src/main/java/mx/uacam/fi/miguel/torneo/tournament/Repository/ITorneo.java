package mx.uacam.fi.miguel.torneo.tournament.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.uacam.fi.miguel.torneo.tournament.Model.Torneo;

@Repository
public interface ITorneo extends CrudRepository<Torneo,Integer>{

}
