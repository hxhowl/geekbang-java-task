package org.geektimes.projects.user.web.mvc.header;

import java.util.List;
import java.util.Map;

/**
 * @author hxhowl
 * @since 2021/3/10
 */
public interface HeaderWriter {

    void write(Map<String, List<String>> headers, String... headerValues);
}

