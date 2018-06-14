package com.funi.muyq.demo.study.xml;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import lombok.Data;
import org.apache.commons.beanutils.BeanMap;
import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.UUID;

/**
 * Created by muyq on 6/14/18.
 */
@Data
@XStreamAlias("person")
public class Person {
    private String uuid;
    private String name;
    private String password;

    public static void main(String[] args) throws Exception {
        XStream xStream = new XStream();
        xStream.autodetectAnnotations(true);
        Person person = new Person();
        person.setUuid(UUID.randomUUID().toString());
        person.setName(null);
        person.setPassword(UUID.randomUUID().toString().substring(13));
        //System.out.println(xStream.toXML(person));
        Map<String, String> map = BeanUtils.describe(person);
        map.remove("class");
        System.out.println(Utils.mapToXml(map));
    }
}
