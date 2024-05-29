package ru.manannikov.learnMVC.util;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.manannikov.learnMVC.coin.CoinEntity;

public class JsonToEntityMapper {
    private static final Logger LOG = LoggerFactory.getLogger(JsonToEntityMapper.class);

    public static List<CoinEntity> mapJsonToCoinEntity(String jsonResponse) {

        ObjectMapper mapper = new ObjectMapper();
        List<CoinEntity> coins = new ArrayList<>();

        try {
            // Обычный способ парсинга JSON с помощью Jackson
            JsonNode root = mapper.readTree(jsonResponse);
            JsonNode dataArray = root.path("data");
            for (JsonNode node : dataArray) {
                CoinEntity coin = new CoinEntity();

                coin.setCoinName(node.path("name").asText());
                coin.setCoinCode(node.path("symbol").asText());
                coin.setPrice(node.path("price_usd").asDouble());

                coin.setOneHourChange(node.path("percent_change_1h").asDouble());
                coin.setTwentyFourHourChange(node.path("percent_change_24h").asDouble());
                coin.setSevenDayChange(node.path("percent_change_7d").asDouble());

                coin.setMarketCap(node.path("market_cap_usd").asDouble());
                coin.setVolume(node.path("volume24").asDouble());

                coins.add(coin);
            }
        } catch(Exception e) {
            LOG.error("Не удалось разобрать JSON см.\n{}", e.toString());
        }

        return coins;
    }
}
