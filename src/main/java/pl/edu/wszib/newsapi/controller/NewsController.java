package pl.edu.wszib.newsapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import pl.edu.wszib.newsapi.controller.dto.NewsDto;
import pl.edu.wszib.newsapi.entity.News;
import pl.edu.wszib.newsapi.service.NewsService;

import java.net.URI;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/news")
public class NewsController {
    private final NewsService newsService;

   @GetMapping
    public List<News> getNews() {
        return newsService.getAllNews();
    }

    @GetMapping("/{id}")
    public News getNewsById(@PathVariable Long id) {
        return newsService.findById(id);
    }

    @PostMapping
    public ResponseEntity<News> addNews(@Validated @RequestBody NewsDto newsRequest) {
       News news = new News(
           newsRequest.getTitle(),
           newsRequest.getContent(),
           newsRequest.getAuthor(),
           newsRequest.getDate()
        );

        News savedNews = newsService.save(news);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/news/" + savedNews.getId()).build().toUri();

        return ResponseEntity.created(uri).body(savedNews);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNews(@PathVariable Long id) {
        newsService.deleteById(id);
    }
}
