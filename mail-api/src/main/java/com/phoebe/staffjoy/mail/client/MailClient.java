package com.phoebe.staffjoy.mail.client;

import com.phoebe.staffjoy.common.api.BaseResponse;
import com.phoebe.staffjoy.mail.dto.EmailRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.phoebe.staffjoy.mail.MailConstant;

import javax.validation.Valid;

@FeignClient(name = MailConstant.SERVICE_NAME, path = "/v1", url = "${staffjoy.email-service-endpoint}")
public interface MailClient {
    @PostMapping(path = "/send")
    BaseResponse send(@RequestBody @Valid EmailRequest request);
}
