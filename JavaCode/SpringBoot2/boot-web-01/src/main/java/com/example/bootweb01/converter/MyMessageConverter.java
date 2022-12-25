package com.example.bootweb01.converter;

import com.example.bootweb01.bean.Person;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @author 小白学java
 * @version 3.0
 */
public class MyMessageConverter implements HttpMessageConverter<Person> {


    @Override
    public boolean canRead(Class<?> clazz, MediaType mediaType) {
        return false;
    }

    @Override
    public boolean canWrite(Class<?> clazz, MediaType mediaType) {
        return clazz.isAssignableFrom(Person.class);
    }

    @Override
    public List<MediaType> getSupportedMediaTypes() {
        return null;
    }

    @Override
    public List<MediaType> getSupportedMediaTypes(Class<?> clazz) {
        return MediaType.parseMediaTypes("application/x-mine");
    }

    @Override
    public Person read(Class<? extends Person> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    public void write(Person person, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        //自定义数据写出
        String data = person.getName() + ";" + person.getAge();
        OutputStream body = outputMessage.getBody();
        body.write(data.getBytes());
    }


}
