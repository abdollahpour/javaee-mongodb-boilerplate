/*
 * WPIC CONFIDENTIAL
 *
 * [2008] - [2014] WEB PRESENCE IN CHINA Incorporated
 * All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains
 * the property of Adobe Systems Incorporated and its suppliers,
 * if any.  The intellectual and technical concepts contained
 * herein are proprietary to Adobe Systems Incorporated
 * and its suppliers and may be covered by U.S. and Foreign Patents,
 * patents in process, and are protected by trade secret or copyright law.
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from WPIC Incorporated.
 */

package org.github.wildfly.mongo.boilerplate.model;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date formatting for JPA.
 */
public class DateTimeAdapter extends XmlAdapter<String, Date> {

    public static final String PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static final SimpleDateFormat FORMAT = new SimpleDateFormat(PATTERN);

    @Override
    public String marshal(Date v) throws Exception {
        return FORMAT.format(v);
    }

    @Override
    public Date unmarshal(String v) throws Exception {
        return FORMAT.parse(v);
    }

}
