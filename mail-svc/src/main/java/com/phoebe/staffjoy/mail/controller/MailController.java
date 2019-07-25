package com.phoebe.staffjoy.mail.controller;

import com.github.structlog4j.ILogger;
import com.github.structlog4j.SLoggerFactory;
import com.phoebe.staffjoy.common.api.BaseResponse;
import com.phoebe.staffjoy.mail.dto.EmailRequest;
import com.phoebe.staffjoy.mail.service.MailSendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1")
@Validated
public class MailController {

    private static ILogger logger = SLoggerFactory.getLogger(MailController.class);

    @Autowired
    private MailSendService mailSendService;

    @PostMapping(path = "/send")
    public BaseResponse send(@RequestBody @Valid EmailRequest request) {
        mailSendService.sendMailAsync(request);
        return BaseResponse.builder().message("email has been sent async.").build();
    }


}
