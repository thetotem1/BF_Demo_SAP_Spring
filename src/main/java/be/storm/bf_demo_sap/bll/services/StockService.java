package be.storm.bf_demo_sap.bll.services;

import be.storm.bf_demo_sap.dl.entities.Stock;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

public interface StockService {

    List<Stock> getStocks();
    Stock getStockByArticleId(UUID articleId);
}
