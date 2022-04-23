package ru.ravel.TestModule.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class Field {
    @XmlAttribute
    public long id;
    @XmlAttribute
    public String value;
}
