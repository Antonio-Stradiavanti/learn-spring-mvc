package ru.manannikov.learnMVC.scheduling;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import ru.manannikov.learnMVC.coin.CoinEntity;
import ru.manannikov.learnMVC.coin.CoinService;
import ru.manannikov.learnMVC.util.JsonToEntityMapper;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ScheduledTask {
    private final CoinService coinService;
    private final ScheduleTaskStatusService statusService;
    // Используется по умолчанию в web приложениях архитектуры MVC, позволяет отправлять HTTP запросы к другим API (синхронный клиент).
    // execute -> самый общий метод, а exchange более специфическая его версия, в его параметрах передается адрес конечной точки API, тип HTTP запроса и ссылка на класс, в который десериализован полученный в ответе JSON.
    private final RestTemplate restTemplate;

    private static final Logger LOG = LoggerFactory.getLogger(ScheduledTask.class);

    private final String URL = "https://api.coinlore.net/api/tickers/";

    // fixedDelay = n :: (время в милисекундах) метод будет вызываться через n милисекунд с момента завершения его последнего вызова.
    // fixedRate = n :: (время в милисекундах) метод будет вызываться каждые n милисекунд (рекомендуется использовать)
    // Вызывать метод будем каждые 5 минут.
    @Scheduled(fixedRate = 300000)
    public void fetchFromApi() {

        boolean isSuccess = false;

        try {
//            ResponseEntity< List<CoinEntity> > coins  =  restTemplate.exchange(URL, HttpMethod.GET, null, new ParameterizedTypeReference<List<CoinEntity>>() {} );
            // Сохраняем полученные из API монеты в таблицу coins.
//            coinService.saveOrUpdateCoins(coins.getBody());
            String jsonResponse = restTemplate.getForObject(URL, String.class);
            List<CoinEntity> coins = JsonToEntityMapper.mapJsonToCoinEntity(jsonResponse);
            coinService.saveOrUpdateCoins(coins);
            isSuccess = true;
            LOG.info("Удалось получить данные из API см.\n{}", jsonResponse);

        } catch (RestClientException e) {
            LOG.error("Не удалось получить данные из API см.\n{}", e.toString());

        }

        statusService.saveUpdateStatus(isSuccess);
    }
}
