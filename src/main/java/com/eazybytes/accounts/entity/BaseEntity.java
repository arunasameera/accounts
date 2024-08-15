package com.eazybytes.accounts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.*;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter @Setter @ToString
public class BaseEntity {

    @CreatedDate
    //@Column(updatable = false)
    private LocalDateTime createdAt;

    @CreatedBy
    //@Column(updatable = false)
    private String createdBy;

    @LastModifiedDate
    //@Column(insertable = false)
    private LocalDateTime updatedAt;

    @LastModifiedBy
    //@Column(insertable = false)
    private String updatedBy;


    @PrePersist
    protected void onCreate() {
        System.out.println("PrePersist: Setting createdAt and createdBy");
        setCreatedAt(LocalDateTime.now());
        System.out.println("getCreatedAt value is "+getCreatedAt());
        setCreatedBy("system");  // Replace with actual user if available
    }

    @PreUpdate
    protected void onUpdate() {
        System.out.println("PreUpdate: Setting createdAt and createdBy");
        setUpdatedAt(LocalDateTime.now());
        setUpdatedBy("system");  // Replace with actual user if available
    }

}
