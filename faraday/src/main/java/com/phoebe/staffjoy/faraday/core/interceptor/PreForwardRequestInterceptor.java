package com.phoebe.staffjoy.faraday.core.interceptor;

import com.phoebe.staffjoy.faraday.config.MappingProperties;
import com.phoebe.staffjoy.faraday.core.http.RequestData;
import xyz.staffjoy.faraday.config.MappingProperties;
import xyz.staffjoy.faraday.core.http.RequestData;

public interface PreForwardRequestInterceptor {
    void intercept(RequestData data, MappingProperties mapping);
}
