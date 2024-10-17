package be.storm.bf_demo_sap.bll.services;

import be.storm.bf_demo_sap.dl.entities.Article;

import java.util.List;
import java.util.UUID;

public interface ArticleService {

    Article getOne(UUID id);
}
