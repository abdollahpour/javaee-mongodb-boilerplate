
package org.github.wildfly.mongo.boilerplate.model;


import lombok.ToString;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.Date;

@XmlRootElement
@ToString
public class Sample {

    /**
     * We keep the fields name to do the refactoring more easily.
     */
    public static final String NAME = "name";

    public static final String COMPANY = "company";

    public static final String AGE = "age";

    @NotNull
    public String name;

    /**
     * Just support alphabetic words
     */
    @NotNull
    @Pattern(regexp = "[a-zA-Z]+")
    public String company;

    @Min(1)
    @Max(132) /* Does we have someone older than this! */
    public Integer age;

    @XmlJavaTypeAdapter(DateTimeAdapter.class)
    public Date date;

}
