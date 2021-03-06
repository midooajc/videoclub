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

import formation.sopra.entity.Article;
import formation.sopra.entity.BluRay;
import formation.sopra.entity.Dvd;
import formation.sopra.repository.ArticleRepository;

@Controller
@RequestMapping("/article")
public class ArticleController {
	@Autowired
	ArticleRepository myArticleRepository;

	@GetMapping("/addDVD")
	public String addDVD(Model model) {
		return goEdit(new Dvd(), model);
	}
	@GetMapping("/addBD")
	public String addBD(Model model) {
		return goEdit(new BluRay(), model);
	}

	@GetMapping("/edit")
	public String updateArticle(@RequestParam(name = "noArticle") Long id, Model model) {
		Optional<Article> opt = myArticleRepository.findById(id);
		Article article = opt.get();

		return goEdit(article, model);
	}

	public String goEdit(Article article, Model model) {
		String reponse="article/list";
		if(article.getClass().getName()=="formation.sopra.entity.Dvd"){
			model.addAttribute("dvd", article);
			reponse="article/editdvd";
		}else if(article.getClass().getName()=="formation.sopra.entity.BluRay") {
			model.addAttribute("bd", article);
			reponse="article/editbd";
		}
		
		return reponse;
	}

	@GetMapping("/delete")
	public String deleteArticle(@RequestParam(name = "noArticle") Long id, Model model) {
		myArticleRepository.deleteById(id);

		return "redirect:/article/list";
	}

	@GetMapping("/list")
	public String findAllArticle(Model model) {
		model.addAttribute("listeArticles", myArticleRepository.findAll());
		return "article/list";
	}
	
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("article") Article article, BindingResult br, Model model) {
		if(br.hasErrors()) {
			return goEdit(article, model);
		}
		myArticleRepository.save(article);
		return "redirect:/article/list";
	}

}
