package pl.edu.wszib.newsapi.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.edu.wszib.newsapi.entity.News;
import pl.edu.wszib.newsapi.service.NewsService;

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
    public News addNews(@RequestBody News news) {
        return newsService.save(news);
    }

    @DeleteMapping("/{id}")
    public void deleteNews(@PathVariable Long id) {
        newsService.deleteById(id);
    }
}
