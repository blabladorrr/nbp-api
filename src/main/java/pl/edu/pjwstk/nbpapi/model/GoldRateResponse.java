package pl.edu.pjwstk.nbpapi.model;

import java.time.LocalDate;

public class GoldRateResponse {
    private Double averageGoldRate;
    private LocalDate startDate;
    private LocalDate endDate;

    public GoldRateResponse(Double averageGoldRate, LocalDate startDate, LocalDate endDate) {
        this.averageGoldRate = averageGoldRate;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Double getAverageGoldRate() {
        return averageGoldRate;
    }

    public void setAverageGoldRate(Double averageGoldRate) {
        this.averageGoldRate = averageGoldRate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
