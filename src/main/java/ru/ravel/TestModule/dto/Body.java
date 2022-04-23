package ru.ravel.TestModule.dto;

import javax.xml.bind.annotation.XmlElement;

public class Body {
    @XmlElement(name = "sendPayment")
    public SendPayment sendPayment;
}
