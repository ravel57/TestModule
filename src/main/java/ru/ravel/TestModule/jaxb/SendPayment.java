package ru.ravel.TestModule.jaxb;

import javax.xml.bind.annotation.XmlElement;
import java.math.BigDecimal;

public class SendPayment {

    @XmlElement(name = "token")
    public long token;

    @XmlElement(name = "cardNumber")
    public String cardNumber;

    @XmlElement(name = "requestId")
    public long requestId;

    @XmlElement(name = "amount")
    public BigDecimal amount;

    @XmlElement(name = "currency")
    public String currency;

    @XmlElement(name = "page")
    public long page;

    @XmlElement(name = "field")
    public Field[] fields;

    @XmlElement(name = "account", namespace = "wsapi:Utils")
    public Account[] accounts;

}


