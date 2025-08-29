package com.hospital.Mediverse.Website.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "test_reports")
public class TestReport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "test_booking_id", nullable = false)
    private TestBooking testBooking;
    
    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
    
    @Column(name = "report_date")
    private LocalDateTime reportDate;
    
    @Column(name = "results", columnDefinition = "TEXT")
    private String results;
    
    @Column(name = "diagnosis")
    private String diagnosis;
    
    @Column(name = "recommendations")
    private String recommendations;
    
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private ReportStatus status;
    
    @Column(name = "file_path")
    private String filePath;
    
    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TestBooking getTestBooking() {
        return testBooking;
    }

    public void setTestBooking(TestBooking testBooking) {
        this.testBooking = testBooking;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public LocalDateTime getReportDate() {
        return reportDate;
    }

    public void setReportDate(LocalDateTime reportDate) {
        this.reportDate = reportDate;
    }

    public String getResults() {
        return results;
    }

    public void setResults(String results) {
        this.results = results;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(String recommendations) {
        this.recommendations = recommendations;
    }

    public ReportStatus getStatus() {
        return status;
    }

    public void setStatus(ReportStatus status) {
        this.status = status;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}

enum ReportStatus {
    PENDING,
    COMPLETED,
    UNDER_REVIEW,
    REJECTED
}
