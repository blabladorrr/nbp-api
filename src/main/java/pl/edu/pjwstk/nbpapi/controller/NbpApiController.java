package pl.edu.pjwstk.nbpapi.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pjwstk.nbpapi.model.GoldRateResponse;
import pl.edu.pjwstk.nbpapi.service.NbpApiService;

@RestController
@RequestMapping("/api")
public class NbpApiController {
    private final NbpApiService nbpApiService;

    public NbpApiController(NbpApiService nbpApiService) {
        this.nbpApiService = nbpApiService;
    }

    @GetMapping
    public ResponseEntity<GoldRateResponse> getRate(@RequestParam String startDate, @RequestParam String endDate) {
        return ResponseEntity.ok(nbpApiService.getNbpRate(startDate, endDate));
    }
}
