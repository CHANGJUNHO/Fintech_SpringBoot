package com.example.demo.service;

import com.example.demo.dto.Observation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class FredService {

    final String baseUrl = "https://api.stlouisfed.org";

    @Value("${fred.apikey}")
    String fredApiKey;

    private Double safeParseDouble(String str){
        try {
            return Double.parseDouble(str);
        } catch (Throwable t) {
            return Double.MAX_VALUE;
        }
    }

    public Flux<Observation> getUsGovernmentBond10Y(){
        Flux<Observation> data = WebClient.create(baseUrl) // webclient config가 전역으로 설정
                .method(HttpMethod.GET) // 전역적으로 사용되는 통일된 변수값을 enum 값으로 지정해 놓고 간편하게 사용한다.
                .uri(it -> it.path("/fred/series/observations")
                    .queryParam("series_id", "DGS10")
                    .queryParam("units", "lin")
                    .queryParam("file_type", "json")
                    .queryParam("api_key", fredApiKey)
                    .queryParam("observation_start", "2020-12-01")
                    .queryParam("observation_end", "2020-12-31")
                    .build())
                .retrieve() // exchange는 더 많은 control을 적용하고 싶을 때 사용한다. 하지만 retrieve 사용을 권고
                .bodyToMono(Map.class) // back pressure를 이용하여 비동기 통신을 중단시킬 수 있는 부분. responseSpec(json)을 map으로 변환
                .flatMapMany(it->{ // observations의 구조에 따라서 list 객체 type 설정
                    List<Map<String,String>> list = (List<Map<String,String>>) it.get("observations");
                    return Flux.fromStream( //stream에서 flux로
                            list.stream().map(m-> new Observation(m.get("date"), safeParseDouble(m.get("value"))))
                    );
                });
        return data;
    }
}
