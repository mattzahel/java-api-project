package pl.edu.wszib.newsapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import pl.edu.wszib.newsapi.entity.News;

public interface NewsJpaRepository extends JpaRepository<News, Long> {
    Page<News> findAll(Pageable pageable);
}
