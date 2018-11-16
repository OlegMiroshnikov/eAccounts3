package lv.javaguru.java3.eaccounts3.domain;

import lv.javaguru.java3.eaccounts3.audit.Auditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
//@EntityListeners(AuditingEntityListener.class)
@Table(name= "account")
//public class Account  extends Auditable<String> {
public class Account  extends Auditable {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="contract_id", nullable = false)
    private Long contractId;

    @Column(name="file_name", nullable = false)
    private String fileName;

    @Column(name = "date_sending", nullable = true, columnDefinition = "Date")
    private Date dateSending;

    @Column(name = "date_viewing", nullable = true, columnDefinition = "Date")
    private Date dateViewing;

    @Column(name = "date_reminder_sending", nullable = true, columnDefinition = "Date")
    private Date dateReminderSending;

    public Account(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getDateSending() {
        return dateSending;
    }

    public void setDateSending(Date dateSending) {
        this.dateSending = dateSending;
    }

    public Date getDateViewing() {
        return dateViewing;
    }

    public void setDateViewing(Date dateViewing) {
        this.dateViewing = dateViewing;
    }

    public Date getDateReminderSending() {
        return dateReminderSending;
    }

    public void setDateReminderSending(Date dateReminderSending) {
        this.dateReminderSending = dateReminderSending;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (id != null ? !id.equals(account.id) : account.id != null) return false;
        if (contractId != null ? !contractId.equals(account.contractId) : account.contractId != null) return false;
        if (fileName != null ? !fileName.equals(account.fileName) : account.fileName != null) return false;
        if (dateSending != null ? !dateSending.equals(account.dateSending) : account.dateSending != null) return false;
        if (dateViewing != null ? !dateViewing.equals(account.dateViewing) : account.dateViewing != null) return false;
        return dateReminderSending != null ? dateReminderSending.equals(account.dateReminderSending) : account.dateReminderSending == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (contractId != null ? contractId.hashCode() : 0);
        result = 31 * result + (fileName != null ? fileName.hashCode() : 0);
        result = 31 * result + (dateSending != null ? dateSending.hashCode() : 0);
        result = 31 * result + (dateViewing != null ? dateViewing.hashCode() : 0);
        result = 31 * result + (dateReminderSending != null ? dateReminderSending.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", contractId=" + contractId +
                ", fileName='" + fileName + '\'' +
                ", dateSending=" + dateSending +
                ", dateViewing=" + dateViewing +
                ", dateReminderSending=" + dateReminderSending +
                '}';
    }
}
