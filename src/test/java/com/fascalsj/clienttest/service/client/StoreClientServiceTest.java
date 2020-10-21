package com.fascalsj.clienttest.service.client;

import com.fascalsj.clienttest.dto.StoreDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class StoreClientServiceTest {
    @InjectMocks
    StoreClientService storeClientService;

    @Mock
    RestTemplate restTemplate;

    @Test
    void createOrderSuccess() throws JsonProcessingException {
        StoreDto storeDto = new StoreDto();
        storeDto.setId(1);
        storeDto.setComplete(true);
        storeDto.setPetId(1);
        storeDto.setQuantity(1);
        storeDto.setShipDate("2020-10-20T11:41:54.280Z");
        storeDto.setStatus("placed");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<StoreDto> requestEntity =
                new HttpEntity<>(storeDto, headers);

        Mockito.when(restTemplate
                .exchange("https://petstore.swagger.io/v2/store/order", HttpMethod.POST, requestEntity, StoreDto.class))
                .thenReturn(new ResponseEntity<>(storeDto, HttpStatus.OK));

        ResponseEntity<StoreDto> actual = storeClientService.createOrder(storeDto);

        Assertions.assertEquals(storeDto.getComplete(), actual.getBody().getComplete());
        Assertions.assertEquals(storeDto.getId(), actual.getBody().getId());
        Assertions.assertEquals(storeDto.getPetId(), actual.getBody().getPetId());
        Assertions.assertEquals(storeDto.getQuantity(), actual.getBody().getQuantity());
        Assertions.assertNotNull(actual.getBody().getShipDate());
        Assertions.assertEquals(storeDto.getStatus(), actual.getBody().getStatus());
    }

}