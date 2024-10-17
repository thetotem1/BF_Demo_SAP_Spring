package be.storm.bf_demo_sap.bll.services.impls;

import be.storm.bf_demo_sap.bll.services.StockService;
import be.storm.bf_demo_sap.dal.repositories.StockRepository;
import be.storm.bf_demo_sap.dl.entities.Stock;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StockServiceImpl implements StockService {

    private final StockRepository stockRepository;

    @Override
    public List<Stock> getStocks() {
        return stockRepository.findAll();
    }

    @Override
    public Stock getStockByArticleId(UUID articleId) {
        return stockRepository.findByArticleId(articleId).orElseThrow();
    }
}
