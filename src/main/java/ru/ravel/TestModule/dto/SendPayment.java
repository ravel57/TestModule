package ru.ravel.TestModule.dto;

import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

public class SendPayment {
    public long token;
    public String cardNumber;
    public long requestId;
    public BigDecimal amount;
    public String currency;
    public long page;
    @XmlElement(name = "field")
    public Field[] fields;
    @XmlElement(name = "account")
    public Account[] accounts;
}


