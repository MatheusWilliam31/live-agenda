package com.loose.agendalives.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Document
public class LiveDocument {

    @Id
    private String id;
    private String liveName;
    private String channelName;
    private LocalDate liveDate;
    private String liveLink;
    private LocalDateTime registrationDate;

    public LiveDocument (){

    }

    public LiveDocument(String id, String liveName, String channelName, LocalDate liveDate, String liveLink, LocalDateTime registrationDate) {
        this.id = id;
        this.liveName = liveName;
        this.channelName = channelName;
        this.liveDate = liveDate;
        this.liveLink = liveLink;
        this.registrationDate = registrationDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLiveName() {
        return liveName;
    }

    public void setLiveName(String liveName) {
        this.liveName = liveName;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public LocalDate getLiveDate() {
        return liveDate;
    }

    public void setLiveDate(LocalDate liveDate) {
        this.liveDate = liveDate;
    }

    public String getLiveLink() {
        return liveLink;
    }

    public void setLiveLink(String liveLink) {
        this.liveLink = liveLink;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }
}