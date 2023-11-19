package pl.edu.pjwstk.nbpapi.service;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.edu.pjwstk.nbpapi.model.Rate;
import pl.edu.pjwstk.nbpapi.repository.NbpApiRepository;

import java.time.LocalDate;

@Service
public class NbpApiService {
    private final NbpApiRepository nbpApiRepository;
    private final RestTemplate restTemplate;
    private final String uri = "http://api.nbp.pl/api/cenyzlota/{startDate}/{endDate}?format=json";

    public NbpApiService(NbpApiRepository nbpApiRepository, RestTemplate restTemplate) {
        this.nbpApiRepository = nbpApiRepository;
        this.restTemplate = restTemplate;
    }

    public String getNbpRate(String startDate, String endDate) {
        LocalDate startDateConv = LocalDate.parse(startDate);
        System.out.println(startDateConv);
        LocalDate endDateConv = LocalDate.parse(endDate);
        System.out.println(endDateConv);
        String uri = "http://api.nbp.pl/api/cenyzlota/" + startDateConv + "/" + endDateConv;
        String nbpApiRate = restTemplate.getForObject(uri, String.class, startDate, endDate);
        System.out.println(nbpApiRate);
        return nbpApiRate;
    }
}
