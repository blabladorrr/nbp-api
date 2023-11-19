package pl.edu.pjwstk.nbpapi.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer id;
    @Column
    @Enumerated(EnumType.STRING)
    private Gold gold;
    @Column
    private LocalDate startDate;
    @Column
    private LocalDate endDate;
    @Column
    private Double rate;
    @Column
    private LocalDate queryDate;
    @Column
    private LocalDateTime queryTime;

    public Rate(Integer id, Gold gold, LocalDate startDate, LocalDate endDate, Double rate, LocalDate queryDate, LocalDateTime queryTime) {
        this.id = id;
        this.gold = gold;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rate = rate;
        this.queryDate = queryDate;
        this.queryTime = queryTime;
    }

    public Rate() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Gold getGold() {
        return gold;
    }

    public void setGold(Gold gold) {
        this.gold = gold;
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

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public LocalDateTime getQueryDateTime() {
        return queryTime;
    }

    public void setQueryTime(LocalDateTime queryDateTime) {
        this.queryTime = queryDateTime;
    }
}
