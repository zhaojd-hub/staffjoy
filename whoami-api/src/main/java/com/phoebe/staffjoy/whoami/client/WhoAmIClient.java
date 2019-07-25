package com.phoebe.staffjoy.whoami.client;

import com.phoebe.staffjoy.whoami.WhoAmIConstant;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import xyz.staffjoy.common.auth.AuthConstant;
import com.phoebe.staffjoy.whoami.dto.FindWhoAmIResponse;
import com.phoebe.staffjoy.whoami.dto.GetIntercomSettingResponse;

@FeignClient(name = WhoAmIConstant.SERVICE_NAME, path = "/v1", url = "${staffjoy.whoami-service-endpoint}")
public interface WhoAmIClient {
    @GetMapping
    FindWhoAmIResponse findWhoAmI(@RequestHeader(AuthConstant.AUTHORIZATION_HEADER) String authz);

    @GetMapping(value = "/intercom")
    GetIntercomSettingResponse getIntercomSettings(@RequestHeader(AuthConstant.AUTHORIZATION_HEADER) String authz);
}
