package lv.javaguru.java3.eaccounts3.audit;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

@MappedSuperclass
public class Auditable {

    @CreatedBy
    @Column(name = "created_by", nullable = true, updatable = false)
    protected String createdBy;

    @CreatedDate
    @Column(name="created_date", nullable = true, updatable = false)
    protected LocalDateTime createdDate;

    @LastModifiedBy
    @Column(name = "last_modified_by", nullable = true)
    protected String lastModifiedBy;

    @LastModifiedDate
    @Column(name="last_modified_date", nullable = true)
    protected LocalDateTime lastModifiedDate;

    @Version
    @Column(name="version", nullable = false)
    protected Long version;

    @PrePersist
    protected void prePersist() {
        createdDate = LocalDateTime.now(ZoneOffset.UTC);
        createdBy = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
    }

    @PreUpdate
    protected void preUpdate() {
        lastModifiedDate = LocalDateTime.now(ZoneOffset.UTC);
        lastModifiedBy = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUsername();
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}


//@MappedSuperclass
//@EntityListeners(AuditingEntityListener.class)
//public abstract class Auditable<U> {
//
//    @CreatedBy
//    @Column(name = "created_by", nullable = true, updatable = false)
//    protected U createdBy;
//
//    @CreatedDate
//    @Column(name="created_date", nullable = true, updatable = false)
//    protected LocalDateTime createdDate;
//
//    @LastModifiedBy
//    @Column(name = "last_modified_by", nullable = true)
//    protected U lastModifiedBy;
//
//    @LastModifiedDate
//    @Column(name="last_modified_date", nullable = true)
//    protected LocalDateTime lastModifiedDate;
//
//    @Version
//    @Column(name="version", nullable = false)
//    protected Long version;
//
//    public U getCreatedBy() {
//        return createdBy;
//    }
//
//    public void setCreatedBy(U createdBy) {
//        this.createdBy = createdBy;
//    }
//
//    public LocalDateTime getCreatedDate() {
//        return createdDate;
//    }
//
//    public void setCreatedDate(LocalDateTime createdDate) {
//        this.createdDate = createdDate;
//    }
//
//    public U getLastModifiedBy() {
//        return lastModifiedBy;
//    }
//
//    public void setLastModifiedBy(U lastModifiedBy) {
//        this.lastModifiedBy = lastModifiedBy;
//    }
//
//    public LocalDateTime getLastModifiedDate() {
//        return lastModifiedDate;
//    }
//
//    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
//        this.lastModifiedDate = lastModifiedDate;
//    }
//
//    public Long getVersion() {
//        return version;
//    }
//
//    public void setVersion(Long version) {
//        this.version = version;
//    }
//}

