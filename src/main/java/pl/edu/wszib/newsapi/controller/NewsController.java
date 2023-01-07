package pl.edu.wszib.newsapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.edu.wszib.newsapi.controller.dto.NewsDto;
import pl.edu.wszib.newsapi.entity.News;
import pl.edu.wszib.newsapi.service.NewsService;

import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping("/news")
public class NewsController {
    private final NewsService newsService;

   @GetMapping
    public Page<News> getAllNews(Pageable pageable) {
        return newsService.getAllNews(pageable);
    }

    @GetMapping("/{id}")
    public News getNewsById(@PathVariable Long id) {
        return newsService.findById(id);
    }

    @PostMapping
    public ResponseEntity<News> addNews(@Validated @RequestBody NewsDto newsRequest) {
        News savedNews = newsService.createNews(newsRequest);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/news/" + savedNews.getId()).build().toUri();

        return ResponseEntity.created(uri).body(savedNews);
    }

    @PutMapping("/{id}")
    public ResponseEntity<News> updateNews(@PathVariable Long id, @Validated @RequestBody NewsDto newsRequest) {
        News updatedNews = newsService.updateById(id, newsRequest);

        return ResponseEntity.ok(updatedNews);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNews(@PathVariable Long id) {
        newsService.deleteById(id);
    }
}
