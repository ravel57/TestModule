package ru.ravel.TestModule.jaxb;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "Envelope")
@XmlAccessorType(XmlAccessType.FIELD)
public class Envelope {

    @XmlElement(name = "Body")
    public Body body;

}
