package org.geektimes.projects.user.web.mvc.header;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author hxhowl
 * @since 2021/3/10
 */
public class CacheControlHeaderWriter implements HeaderWriter {

    @Override
    public void write(Map<String, List<String>> headers, String... headerValues) {
        headers.put("cache-control", Arrays.asList(headerValues));
    }
}
