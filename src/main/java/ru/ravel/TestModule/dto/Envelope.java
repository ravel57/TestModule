package ru.ravel.TestModule.dto;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Envelope")
@XmlAccessorType(XmlAccessType.FIELD)
public class Envelope {

    @XmlElement(name = "Body")
    public Body body;

}
