package lv.javaguru.java3.eaccounts3.domain.builder;

import lv.javaguru.java3.eaccounts3.domain.Account;
import lv.javaguru.java3.eaccounts3.domain.Contract;

import java.util.Date;

public class AccountBuilder {

    private Long id;
    private Long contactId;
    private String fileName;
    private Date dateSending;
    private Date dateViewing;
    private Date dateReminderSending;

    private AccountBuilder() {
    }

    public static AccountBuilder createAccount() {
        return new AccountBuilder();
    }

    public Account build() {
        Account account = new Account();
        account.setId(id);
        account.setContractId(contactId);
        account.setFileName(fileName);
        account.setDateSending(dateSending);
        account.setDateViewing(dateViewing);
        account.setDateReminderSending(dateReminderSending);
        return account;
    }

    public AccountBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public AccountBuilder withContractId(Long contactId) {
        this.contactId = contactId;
        return this;
    }
    public AccountBuilder withFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }


    public AccountBuilder withDateSendind(Date dateSending) {
        this.dateSending = dateSending;
        return this;
    }

    public AccountBuilder withDateViewing(Date dateViewing) {
        this.dateViewing = dateViewing;
        return this;
    }

    public AccountBuilder withDateReminderSendind(Date dateReminderSendind) {
        this.dateReminderSending = dateReminderSendind;
        return this;
    }

}
