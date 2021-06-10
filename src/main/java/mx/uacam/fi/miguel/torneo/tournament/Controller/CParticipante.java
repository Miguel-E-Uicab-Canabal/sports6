package mx.uacam.fi.miguel.torneo.tournament.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mx.uacam.fi.miguel.torneo.tournament.Dao.ImplTorneo;
import mx.uacam.fi.miguel.torneo.tournament.Dao.ImplParticipante;
import mx.uacam.fi.miguel.torneo.tournament.Model.Participante;



@Controller
@RequestMapping("participante")
public class CParticipante {
	@Autowired 
	private ImplParticipante repositorio;
	@Autowired
	private ImplTorneo repositorioT;
	//
	@GetMapping("/")
	public String showParticipante(Model model) {
	    model.addAttribute("Participantes", repositorio.findAll());
	    return "ParticipanteIndex";
	}
	
	@PostMapping("/add")
	public String addParticipante(@Validated Participante participante, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "ParticipanteForm";
		}
		repositorio.save(participante);
		return "redirect:/participante/";
	}
	
	@GetMapping("/add")
	public String formParticipante(Model model) {
		model.addAttribute("Participantes",new Participante());
		model.addAttribute("Torneos",repositorioT.findAll());
		return "ParticipanteForm";
	
}
	
	@GetMapping("/edit/{id}")
	public String editParticipante(@PathVariable("id") int id, Model model) {
		Participante participante = repositorio.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
			    
			    model.addAttribute("Participantes", participante);
			    model.addAttribute("Torneos",repositorioT.findAll());
			    return "ParticipanteForm";
	}
	
	@PostMapping("/update/{id}")
	public String updateParticipante(@PathVariable("id") int id, @Validated Participante participante, 
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	    	participante.setId(id);
	        return "ParticipanteForm";
	    }
	        
	    repositorio.save(participante);
	    return "redirect:/participante/";
	}
	    
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") int id, Model model) {
		repositorio.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		repositorio.delete(id);
	    return "redirect:/participante/";
	}
}
