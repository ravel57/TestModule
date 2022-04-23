package ru.ravel.TestModule.jaxb;

import javax.xml.bind.annotation.XmlElement;

public class Body {

    @XmlElement(name = "sendPayment", namespace = "wsapi:Payment")
    public SendPayment sendPayment;

}
