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
import mx.uacam.fi.miguel.torneo.tournament.Model.Torneo;


@Controller
@RequestMapping("torneo")
public class CTorneo {
	@Autowired
	private ImplTorneo repositorio;
	
	@GetMapping("/")
	public String showTorneo(Model model) {
	    model.addAttribute("Torneos", repositorio.findAll());
	    return "TorneoIndex";
	}
	
	@PostMapping("/add")
	public String addTorned(@Validated Torneo torneo,BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "TorneoForm";
		}
		repositorio.save(torneo);
		return "redirect:/torneo/";
	}
	
	@GetMapping("/add")
	public String addTorneo( Model model) {
		model.addAttribute("Torneos",new Torneo());
		return "TorneoForm";
	}
	
	@GetMapping("/edit/{id}")
	public String editTorneo(@PathVariable("id") int id, Model model) {
		Torneo torneo = repositorio.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
			    
			    model.addAttribute("Torneos", torneo);
			    return "TorneoForm";
	}
	
	@PostMapping("/update/{id}")
	public String updateTorneo(@PathVariable("id") int id, @Validated Torneo torneo, 
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	    	torneo.setId(id);
	        return "TorneoForm";
	    }
	        
	    repositorio.save(torneo);
	    return "redirect:/torneo/";
	}
	    
	@GetMapping("torneo/delete/{id}")
	public String deleteUser(@PathVariable("id") int id, Model model) {
		repositorio.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		repositorio.delete(id);
	    return "redirect:/torneo/";
	}
	
	

}

