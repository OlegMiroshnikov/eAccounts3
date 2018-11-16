package lv.javaguru.java3.eaccounts3.domain;

import lv.javaguru.java3.eaccounts3.audit.Auditable;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
//@EntityListeners(AuditingEntityListener.class)
@Table(name = "contract")
//public class Contract extends Auditable<String> {
public class Contract extends Auditable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "company_id", nullable = false)
    private Long companyId;

    @Column(name = "client_id", nullable = false)
    private Long clientId;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "date_sign", nullable = false, columnDefinition = "Date")
    private Date dateSign;

    @Column(name = "date_begin", nullable = false, columnDefinition = "Date")
    private Date dateBegin;

    @Column(name = "date_end", nullable = true, columnDefinition = "Date")
    private Date dateEnd;

    @Column(name = "day_to_send_account", nullable = false)
    private Integer dayToSendAccount;

    @Column(name = "count_days_to_send_reminder", nullable = false)
    private Integer countDaysToSendReminder;

    @Column(name = "status", nullable = false)
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDateSign() {
        return dateSign;
    }

    public void setDateSign(Date dateSign) {
        this.dateSign = dateSign;
    }

    public Date getDateBegin() {
        return dateBegin;
    }

    public void setDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Integer getDayToSendAccount() {
        return dayToSendAccount;
    }

    public void setDayToSendAccount(Integer dayToSendAccount) {
        this.dayToSendAccount = dayToSendAccount;
    }

    public Integer getCountDaysToSendReminder() {
        return countDaysToSendReminder;
    }

    public void setCountDaysToSendReminder(Integer countDaysToSendReminder) {
        this.countDaysToSendReminder = countDaysToSendReminder;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contract contract = (Contract) o;

        if (id != null ? !id.equals(contract.id) : contract.id != null) return false;
        if (companyId != null ? !companyId.equals(contract.companyId) : contract.companyId != null) return false;
        if (clientId != null ? !clientId.equals(contract.clientId) : contract.clientId != null) return false;
        if (number != null ? !number.equals(contract.number) : contract.number != null) return false;
        if (dateSign != null ? !dateSign.equals(contract.dateSign) : contract.dateSign != null) return false;
        if (dateBegin != null ? !dateBegin.equals(contract.dateBegin) : contract.dateBegin != null) return false;
        if (dateEnd != null ? !dateEnd.equals(contract.dateEnd) : contract.dateEnd != null) return false;
        if (dayToSendAccount != null ? !dayToSendAccount.equals(contract.dayToSendAccount) : contract.dayToSendAccount != null)
            return false;
        if (countDaysToSendReminder != null ? !countDaysToSendReminder.equals(contract.countDaysToSendReminder) : contract.countDaysToSendReminder != null)
            return false;
        return status != null ? status.equals(contract.status) : contract.status == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (companyId != null ? companyId.hashCode() : 0);
        result = 31 * result + (clientId != null ? clientId.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (dateSign != null ? dateSign.hashCode() : 0);
        result = 31 * result + (dateBegin != null ? dateBegin.hashCode() : 0);
        result = 31 * result + (dateEnd != null ? dateEnd.hashCode() : 0);
        result = 31 * result + (dayToSendAccount != null ? dayToSendAccount.hashCode() : 0);
        result = 31 * result + (countDaysToSendReminder != null ? countDaysToSendReminder.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "id=" + id +
                ", companyId=" + companyId +
                ", clientId=" + clientId +
                ", number='" + number + '\'' +
                ", dateSign=" + dateSign +
                ", dateBegin=" + dateBegin +
                ", dateEnd=" + dateEnd +
                ", dayToSendAccount=" + dayToSendAccount +
                ", countDaysToSendReminder=" + countDaysToSendReminder +
                ", status=" + status +
                '}';
    }
}
