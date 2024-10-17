package be.storm.bf_demo_sap.bll.services.impls;

import be.storm.bf_demo_sap.bll.services.ArticleService;
import be.storm.bf_demo_sap.dal.repositories.ArticleRepository;
import be.storm.bf_demo_sap.dl.entities.Article;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository articleRepository;

    @Override
    public Article getOne(UUID id) {
        return articleRepository.findById(id).orElseThrow();
    }
}
