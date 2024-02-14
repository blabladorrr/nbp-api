package pl.edu.pjwstk.nbpapi.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.edu.pjwstk.nbpapi.model.Gold;
import pl.edu.pjwstk.nbpapi.model.GoldRateAPIObject;
import pl.edu.pjwstk.nbpapi.model.GoldRateResponse;
import pl.edu.pjwstk.nbpapi.model.Rate;
import pl.edu.pjwstk.nbpapi.repository.NbpApiRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
public class NbpApiService {
    private final NbpApiRepository nbpApiRepository;
    private final RestTemplate restTemplate;
    private final String uri = "http://api.nbp.pl/api/cenyzlota/{startDate}/{endDate}?format=json";

    public NbpApiService(NbpApiRepository nbpApiRepository, RestTemplate restTemplate) {
        this.nbpApiRepository = nbpApiRepository;
        this.restTemplate = restTemplate;
    }

    public GoldRateResponse getNbpRate(String startDate, String endDate) {
        LocalDate startDateConversed = LocalDate.parse(startDate);
        LocalDate endDateConversed = LocalDate.parse(endDate);
        String uri = "http://api.nbp.pl/api/cenyzlota/" + startDateConversed + "/" + endDateConversed;
        GoldRateAPIObject[] responseBody = restTemplate.getForObject(uri, GoldRateAPIObject[].class);
        double averageGoldRate = this.getAverageGoldRate(responseBody);
        GoldRateResponse goldRateResponse = this.saveAverageGoldValue(startDateConversed, endDateConversed, averageGoldRate);
        return goldRateResponse;
    }

    private Double getAverageGoldRate(GoldRateAPIObject[] responseBody) {
        Double goldValueSum = 0d;
        for (GoldRateAPIObject goldRate : responseBody) {
            goldValueSum += goldRate.getCena();
        }
        return goldValueSum / responseBody.length;
    }

    private GoldRateResponse saveAverageGoldValue(LocalDate startDate, LocalDate endDate, Double averageGoldRate) {
        Rate rate = new Rate();
        rate.setRate(averageGoldRate);
        rate.setStartDate(startDate);
        rate.setEndDate(endDate);
        rate.setQueryTime(LocalDateTime.now());
        rate.setGold(Gold.GOLD);

        nbpApiRepository.save(rate);

        GoldRateResponse goldRateResponse = new GoldRateResponse(averageGoldRate, startDate, endDate);
        return goldRateResponse;
    }
}
