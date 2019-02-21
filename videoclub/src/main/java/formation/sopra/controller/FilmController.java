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

import formation.sopra.entity.Film;
import formation.sopra.repository.FilmRepository;

@Controller
@RequestMapping("/film")
public class FilmController {
	@Autowired
	FilmRepository myFilmRepository;

	@GetMapping("/add")
	public String addFilm(Model model) {
		return goEdit(new Film(), model);
	}

	@GetMapping("/edit")
	public String updateFilm(@RequestParam(name = "noFilm") Long id, Model model) {
		Optional<Film> opt = myFilmRepository.findById(id);
		Film film = null;
		if (opt.isPresent()) {
			film = opt.get();
		} else {
			film = new Film();
		}
		return goEdit(film, model);
	}

	public String goEdit(Film film, Model model) {
		model.addAttribute("film", film);
		return "film/edit";
	}

	@GetMapping("/delete")
	public String deleteFilm(@RequestParam(name = "noFilm") Long id, Model model) {
		myFilmRepository.deleteById(id);

		return "redirect:/film/list";
	}

	@GetMapping("/list")
	public String findAllFilm(Model model) {
		model.addAttribute("listeFilms", myFilmRepository.findAll());
		return "film/list";
	}
	
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("film") Film film, BindingResult br, Model model) {
		if(br.hasErrors()) {
			return goEdit(film, model);
		}
		myFilmRepository.save(film);
		return "redirect:/film/list";
	}

}
