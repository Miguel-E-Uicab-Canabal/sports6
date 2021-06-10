package mx.uacam.fi.miguel.torneo.tournament.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("inicio")
public class CIndex {
	@GetMapping("/")
	public String inicio() {
		return"Principal";
	}
}
