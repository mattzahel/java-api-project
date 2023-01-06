package pl.edu.wszib.newsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.wszib.newsapi.entity.News;

public interface NewsJpaRepository extends JpaRepository<News, Long> {
}
