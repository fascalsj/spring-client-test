package com.fascalsj.clienttest.service.client;

import com.fascalsj.clienttest.dto.StoreDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class StoreClientService {

    @Autowired
    RestTemplate restTemplate;

    public ResponseEntity<StoreDto> createOrder(StoreDto storeDto) throws JsonProcessingException {
        String url = "https://petstore.swagger.io/v2/store/order";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ObjectWriter ow = new ObjectMapper().writer();
        log.info("== REQUEST ==");
        log.info("Request URL    : " + url);
        log.info("Request Header : " + headers);
        log.info("Request Body   : " + ow.writeValueAsString(storeDto));

        HttpEntity<StoreDto> requestEntity =
                new HttpEntity<>(storeDto, headers);
        ResponseEntity<StoreDto> exchange = restTemplate.exchange("https://petstore.swagger.io/v2/store/order", HttpMethod.POST, requestEntity,
                StoreDto.class);

        log.info("== RESPONSE ==");
        log.info("Response Header : " + exchange.getHeaders());
        log.info("Response Body   : " + ow.writeValueAsString(exchange.getBody()));

        return exchange;
    }


}
