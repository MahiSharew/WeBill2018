/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kic.admin;

import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Web application lifecycle listener.
 *
 * @author mahlet
 */
public class SessionAttributeListener implements HttpSessionAttributeListener {

    @Override
    public void attributeAdded(HttpSessionBindingEvent event) {
        System.out.println("New attribute added:{\"name\":\"" + event.getName() + "\" ," + "\"type\":\"" + event.getValue().getClass().getName() + "\"}");
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent event) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("removed attribute added:{\"name\":\"" + event.getName() + "\" ," + "\"type\":\"" + event.getValue().getClass().getName() + "\"}");

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent event) {
        System.out.println("Replaced  attribute added:{\"name\":\"" + event.getName() + "\" ," + "\"type\":\"" + event.getValue().getClass().getName() + "\"}");

//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
