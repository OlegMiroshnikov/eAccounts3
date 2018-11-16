package lv.javaguru.java3.eaccounts3.domain.builder;

import lv.javaguru.java3.eaccounts3.domain.Contract;

import java.util.Date;

public class ContractBuilder {

    private Long id;
    private Long companyId;
    private Long clientId;
    private String number;
    private Date dateSign;
    private Date dateBegin;
    private Date dateEnd;
    private Integer dayToSendAccount;
    private Integer countDaysToSendReminder;
    private Integer status;

    private ContractBuilder() {
    }

    public static ContractBuilder createContract() {
        return new ContractBuilder();
    }

    public Contract build() {
        Contract contract = new Contract();
        contract.setId(id);
        contract.setCompanyId(companyId);
        contract.setClientId(clientId);
        contract.setNumber(number);
        contract.setDateSign(dateSign);
        contract.setDateBegin(dateBegin);
        contract.setDateEnd(dateEnd);
        contract.setDayToSendAccount(dayToSendAccount);
        contract.setCountDaysToSendReminder(countDaysToSendReminder);
        contract.setStatus(status);
        return contract;
    }

    public ContractBuilder withId(Long id) {
        this.id = id;
        return this;
    }

    public ContractBuilder withCompanyId(Long companyId) {
        this.companyId = companyId;
        return this;
    }

    public ContractBuilder withClientId(Long clientId) {
        this.clientId = clientId;
        return this;
    }

    public ContractBuilder withNumber(String number) {
        this.number = number;
        return this;
    }

    public ContractBuilder withDateSign(Date dateSign) {
        this.dateSign = dateSign;
        return this;
    }

    public ContractBuilder withDateBegin(Date dateBegin) {
        this.dateBegin = dateBegin;
        return this;
    }

    public ContractBuilder withDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
        return this;
    }

    public ContractBuilder withDayToSendAccount(Integer dayToSendAccount) {
        this.dayToSendAccount = dayToSendAccount;
        return this;
    }

    public ContractBuilder withCountDaysToSendReminder(Integer countDaysToSendReminder) {
        this.countDaysToSendReminder = countDaysToSendReminder;
        return this;
    }

    public ContractBuilder withStatus(Integer status) {
        this.status = status;
        return this;
    }

}
