package formation.sopra.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import formation.sopra.entity.Adherent;
import formation.sopra.repository.AdherentRepository;

@Controller
@RequestMapping("/adherent")
public class AdherentController {
	@Autowired
	AdherentRepository myAdherentRepository;

	@GetMapping("/add")
	public String addAdherent(Model model) {
		return goEdit(new Adherent(), model);
	}

	@GetMapping("/edit")
	public String updateAdherent(@RequestParam(name = "noAdherent") Long id, Model model) {
		Optional<Adherent> opt = myAdherentRepository.findById(id);
		Adherent adherent = null;
		if (opt.isPresent()) {
			adherent = opt.get();
		} else {
			adherent = new Adherent();
		}
		return goEdit(adherent, model);
	}

	public String goEdit(Adherent adherent, Model model) {
		model.addAttribute("adherent", adherent);
		return "adherent/edit";
	}

	@GetMapping("/delete")
	public String deleteAdherent(@RequestParam(name = "noAdherent") Long id, Model model) {
		myAdherentRepository.deleteById(id);

		return "redirect:/adherent/list";
	}

	@GetMapping("/list")
	public String findAllAdherent(Model model) {
		model.addAttribute("listeAdherents", myAdherentRepository.findAll());
		return "adherent/list";
	}
	
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("adherent") Adherent adherent, BindingResult br, Model model) {
		if(br.hasErrors()) {
			return goEdit(adherent, model);
		}
		myAdherentRepository.save(adherent);
		return "redirect:/adherent/list";
	}

}
