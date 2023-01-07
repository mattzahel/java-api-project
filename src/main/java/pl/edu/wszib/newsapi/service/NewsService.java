package pl.edu.wszib.newsapi.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.edu.wszib.newsapi.controller.dto.NewsDto;
import pl.edu.wszib.newsapi.entity.News;
import pl.edu.wszib.newsapi.repository.NewsJpaRepository;

@Service
@AllArgsConstructor
public class NewsService {
    private final NewsJpaRepository newsJpaRepository;

    public Page<News> getAllNews(Pageable pageable) {
        return newsJpaRepository.findAll(pageable);
    }

    public News findById(Long id) {
        return newsJpaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cannot find news with given id"));
    }

    public News createNews(NewsDto newsDto) {
        News news = new News(
            newsDto.getTitle(),
            newsDto.getContent(),
            newsDto.getAuthor(),
            newsDto.getDate()
        );

        return newsJpaRepository.save(news);
    }

    public News updateById(Long id, NewsDto newsDto) {
        News newsToUpdate = newsJpaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Cannot find news with given id"));
        newsToUpdate.setTitle(newsDto.getTitle());
        newsToUpdate.setContent(newsDto.getContent());
        newsToUpdate.setAuthor(newsDto.getAuthor());
        newsToUpdate.setDate(newsDto.getDate());

        return newsJpaRepository.save(newsToUpdate);
    }


    public void deleteById(Long id) {
        newsJpaRepository.deleteById(id);
    }
}
