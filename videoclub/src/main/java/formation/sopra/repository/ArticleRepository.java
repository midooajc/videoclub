package formation.sopra.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import formation.sopra.entity.Article;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
	
}
