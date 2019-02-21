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
import formation.sopra.repository.ArticleRepository;

@Controller
@RequestMapping("/article")
public class ArticleController {
	@Autowired
	ArticleRepository myArticleRepository;

	@GetMapping("/add")
	public String addArticle(Model model) {
		return goEdit(new Article(), model);
	}

	@GetMapping("/edit")
	public String updateArticle(@RequestParam(name = "noArticle") Long id, Model model) {
		Optional<Article> opt = myArticleRepository.findById(id);
		Article article = null;
		if (opt.isPresent()) {
			article = opt.get();
		} else {
			article = new Article();
		}
		return goEdit(article, model);
	}

	public String goEdit(Article article, Model model) {
		model.addAttribute("article", article);
		return "article/edit";
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
