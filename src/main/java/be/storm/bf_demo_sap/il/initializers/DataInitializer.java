package be.storm.bf_demo_sap.il.initializers;

import be.storm.bf_demo_sap.dal.repositories.ArticleRepository;
import be.storm.bf_demo_sap.dal.repositories.CategoryRepository;
import be.storm.bf_demo_sap.dal.repositories.StockMovementRepository;
import be.storm.bf_demo_sap.dal.repositories.StockRepository;
import be.storm.bf_demo_sap.dl.entities.Article;
import be.storm.bf_demo_sap.dl.entities.Category;
import be.storm.bf_demo_sap.dl.entities.Stock;
import be.storm.bf_demo_sap.dl.entities.StockMovement;
import be.storm.bf_demo_sap.dl.enums.StockMovemenType;
import be.storm.bf_demo_sap.dl.enums.VAT;
import lombok.RequiredArgsConstructor;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {


    private final ArticleRepository articleRepository;
    private final CategoryRepository categoryRepository;
    private final StockRepository stockRepository;
    private final StockMovementRepository stockMovementRepository;


    @Override
    public void run(String... args) throws Exception {
        if (categoryRepository.count() == 0) {
            Category category1 = new Category(UUID.randomUUID(), "Jeux vidéo");
            Category category2 = new Category(UUID.randomUUID(), "Livres");
            Category category3 = new Category(UUID.randomUUID(), "Films");
            List<Category> categories = List.of(category1, category2, category3);
            categoryRepository.saveAll(categories);
        }


        if (articleRepository.count() == 0) {
            List<Category> categoryList = categoryRepository.findAll();
            Article article1 = new Article(UUID.randomUUID(), "Dragon ball sparkling zero", 5000L, "",
                    VAT.TWENTY_ONE, categoryList.stream().filter(c -> c.getDesignation().equals("Jeux vidéo")).findFirst().orElseThrow());
            Article article2 = new Article(UUID.randomUUID(), "sun Tzu, l'art de la guerre", 500L, "",
                    VAT.TWENTY_ONE, categoryList.stream().filter(c -> c.getDesignation().equals("Livres")).findFirst().orElseThrow());
            Article article3 = new Article(UUID.randomUUID(), "Le dernier samurai", 3000L, "",
                    VAT.TWENTY_ONE, categoryList.stream().filter(c -> c.getDesignation().equals("Films")).findFirst().orElseThrow());

            articleRepository.saveAll(List.of(article1, article2, article3));
        }

        if (stockMovementRepository.count() == 0) {
            List<Article> articles = articleRepository.findAll();

            StockMovement stockMovement1 = new StockMovement(UUID.randomUUID(), StockMovemenType.STOCK_IN, 10, LocalDateTime.now(),
                    articles.stream().filter(a -> a.getDesignation().equals("Dragon ball sparkling zero")).findFirst().orElseThrow());

            StockMovement stockMovement2 = new StockMovement(UUID.randomUUID(), StockMovemenType.STOCK_IN, 15, LocalDateTime.now(),
                    articles.stream().filter(a -> a.getDesignation().equals("sun Tzu, l'art de la guerre")).findFirst().orElseThrow());

            StockMovement stockMovement3 = new StockMovement(UUID.randomUUID(), StockMovemenType.STOCK_IN, 20, LocalDateTime.now(),
                    articles.stream().filter(a -> a.getDesignation().equals("Le dernier samurai")).findFirst().orElseThrow());

            Stock stock1 = new Stock(UUID.randomUUID(), stockMovement1.getQuantity(), articles.stream().filter(a -> a.getDesignation().equals("Dragon ball sparkling zero")).findFirst().orElseThrow());
            Stock stock2 = new Stock(UUID.randomUUID(), stockMovement2.getQuantity(), articles.stream().filter(a -> a.getDesignation().equals("sun Tzu, l'art de la guerre")).findFirst().orElseThrow());
            Stock stock3 = new Stock(UUID.randomUUID(), stockMovement3.getQuantity(), articles.stream().filter(a -> a.getDesignation().equals("Le dernier samurai")).findFirst().orElseThrow());

            stockRepository.saveAll(List.of(stock1, stock2, stock3));

            stockMovementRepository.saveAll(List.of(stockMovement1, stockMovement2, stockMovement3));
        }

    }
}

