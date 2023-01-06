package pl.edu.wszib.newsapi.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.edu.wszib.newsapi.entity.News;
import pl.edu.wszib.newsapi.repository.NewsJpaRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class NewsService {
    private final NewsJpaRepository newsJpaRepository;

    public List<News> getAllNews() {
        return newsJpaRepository.findAll();
    }

    public News findById(Long id) {
        return newsJpaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cannot find news with given id"));
    }

    public News save(News news) {
        return newsJpaRepository.save(news);
    }

    public void deleteById(Long id) {
        newsJpaRepository.deleteById(id);
    }
}
