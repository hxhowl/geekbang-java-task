package org.geektimes.configuration.demo;

import org.jolokia.client.J4pClient;
import org.jolokia.client.exception.J4pException;
import org.jolokia.client.request.J4pReadRequest;
import org.jolokia.client.request.J4pReadResponse;

import javax.management.MalformedObjectNameException;

/**
 * @author chenpeng.huang
 * @since 2021-03-17
 */
public class JolokiaDemo {

    public static void main(String[] args) throws MalformedObjectNameException, J4pException {
        J4pClient client = new J4pClient("http://localhost:8080/jolokia");
        J4pReadRequest request = new J4pReadRequest("jolokia:type=servlet,name=test","Name");
        J4pReadResponse response = client.execute(request);
        System.out.println("value: " + response.getValue());
    }
}
