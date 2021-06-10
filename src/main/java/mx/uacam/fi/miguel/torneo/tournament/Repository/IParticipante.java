package mx.uacam.fi.miguel.torneo.tournament.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.uacam.fi.miguel.torneo.tournament.Model.Participante;
@Repository
public interface IParticipante extends CrudRepository<Participante,Integer> {

}
