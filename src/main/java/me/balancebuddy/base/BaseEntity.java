package me.balancebuddy.base;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {

    @CreatedDate
    @Column(name ="CREATE_DATE_TIME", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createDateTime;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_UPDATE_DATE_TIME")
    protected Date lastUpdateDateTime;

    @CreatedBy
    @Column(name = "CREATED_BY_USER", updatable = false)
    protected String createdByUser;

    @LastModifiedBy
    @Column(name = "UPDATED_BY_USER")
    protected String updateByUser;
}
