package ru.ravel.TestModule.jaxb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Field {

    @XmlAttribute (name = "id")
    public long id;

    @XmlAttribute (name = "value")
    public String value;

}
