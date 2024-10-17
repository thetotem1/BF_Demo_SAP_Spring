package be.storm.bf_demo_sap.pl.models;

import be.storm.bf_demo_sap.dl.entities.Article;
import be.storm.bf_demo_sap.dl.entities.Stock;

import java.util.UUID;

public record ArticleDetailDTO(

        UUID id,
        String designation,
        String picture,
        double unitPriceExcludingTax,
        double unitPriceIncludingTax,
        int vat,
        double vatValue,
        String category,
        int quantity
) {

    public static ArticleDetailDTO fromStock(Stock stock) {
        Article a = stock.getArticle();
        return new ArticleDetailDTO(
                a.getId(),
                a.getDesignation(),
                a.getPicture(),
                a.getUnitPriceExcludingTax() /100D,
                a.getUnitPriceIncludingTax() / 100D,
                a.getVat().value,
                a.getAddedValue() / 100D,
                a.getCategory().getDesignation(),
                stock.getCurrentQuantity()
        );
    }
}
