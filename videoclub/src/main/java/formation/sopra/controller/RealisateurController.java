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

import formation.sopra.entity.Realisateur;
import formation.sopra.repository.RealisateurRepository;

@Controller
@RequestMapping("/realisateur")
public class RealisateurController {
	@Autowired
	RealisateurRepository myRealisateurRepository;

	@GetMapping("/add")
	public String addRealisateur(Model model) {
		return goEdit(new Realisateur(), model);
	}

	@GetMapping("/edit")
	public String updateRealisateur(@RequestParam(name = "noRealisateur") Long id, Model model) {
		Optional<Realisateur> opt = myRealisateurRepository.findById(id);
		Realisateur realisateur = null;
		if (opt.isPresent()) {
			realisateur = opt.get();
		} else {
			realisateur = new Realisateur();
		}
		return goEdit(realisateur, model);
	}

	public String goEdit(Realisateur realisateur, Model model) {
		model.addAttribute("realisateur", realisateur);
		return "realisateur/edit";
	}

	@GetMapping("/delete")
	public String deleteRealisateur(@RequestParam(name = "noRealisateur") Long id, Model model) {
		myRealisateurRepository.deleteById(id);

		return "redirect:/realisateur/list";
	}

	@GetMapping("/list")
	public String findAllRealisateur(Model model) {
		model.addAttribute("listeRealisateurs", myRealisateurRepository.findAll());
		return "realisateur/list";
	}
	
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("realisateur") Realisateur realisateur, BindingResult br, Model model) {
		if(br.hasErrors()) {
			return goEdit(realisateur, model);
		}
		myRealisateurRepository.save(realisateur);
		return "redirect:/realisateur/list";
	}

}
