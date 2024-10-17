package be.storm.bf_demo_sap.pl.controllers;

import be.storm.bf_demo_sap.bll.services.ArticleService;
import be.storm.bf_demo_sap.bll.services.StockService;
import be.storm.bf_demo_sap.dl.entities.Article;
import be.storm.bf_demo_sap.dl.entities.Stock;
import be.storm.bf_demo_sap.pl.models.ArticleDTO;
import be.storm.bf_demo_sap.pl.models.ArticleDetailDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/article")
public class ArticleController {

    private final StockService stockService;
    private final ArticleService articleService;


    @GetMapping
    public String getArticles(Model model) {

        List<ArticleDTO> articles = stockService.getStocks().stream()
                .map(ArticleDTO::fromStock)// ici j'utilise fromstock sur tout les elements ArticleDTo
                .toList();
        model.addAttribute("articles", articles);
        return "/article/index";
    }

    @GetMapping("{id}")
    public String getArticle(@PathVariable UUID id, Model model) {

        try{
            ArticleDetailDTO dto = ArticleDetailDTO.fromStock(stockService.getStockByArticleId(id));
            model.addAttribute("article", dto);
            return "article/article";
        }catch (NoSuchElementException e) {
            return "error404";
        }
    }
}
