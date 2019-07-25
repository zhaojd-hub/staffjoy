package com.phoebe.staffjoy.account.client;

import com.phoebe.staffjoy.account.AccountConstant;
import com.phoebe.staffjoy.account.dto.*;
import com.phoebe.staffjoy.common.api.BaseResponse;
import com.phoebe.staffjoy.common.auth.AuthConstant;
import com.phoebe.staffjoy.common.validation.PhoneNumber;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@FeignClient(name = AccountConstant.SERVICE_NAME, path = "/v1/account", url = "${staffjoy.account-service-endpoint}")
// TODO Client side validation can be enabled as needed
// @Validated
public interface AccountClient {

    @PostMapping(path = "/create")
    GenericAccountResponse createAccount(@RequestHeader(AuthConstant.AUTHORIZATION_HEADER) String authz, @RequestBody @Valid CreateAccountRequest request);

    @PostMapping(path = "/track_event")
    BaseResponse trackEvent(@RequestBody @Valid TrackEventRequest request);

    @PostMapping(path = "/sync_user")
    BaseResponse syncUser(@RequestBody @Valid SyncUserRequest request);

    @GetMapping(path = "/list")
    ListAccountResponse listAccounts(@RequestHeader(AuthConstant.AUTHORIZATION_HEADER) String authz, @RequestParam int offset, @RequestParam @Min(0) int limit);

    // GetOrCreate is for internal use by other APIs to match a user based on their phonenumber or email.
    @PostMapping(path= "/get_or_create")
    GenericAccountResponse getOrCreateAccount(@RequestHeader(AuthConstant.AUTHORIZATION_HEADER) String authz, @RequestBody @Valid GetOrCreateRequest request);

    @GetMapping(path = "/get")
    GenericAccountResponse getAccount(@RequestHeader(AuthConstant.AUTHORIZATION_HEADER) String authz, @RequestParam @NotBlank String userId);

    @PutMapping(path = "/update")
    GenericAccountResponse updateAccount(@RequestHeader(AuthConstant.AUTHORIZATION_HEADER) String authz, @RequestBody @Valid AccountDto newAccount);

    @GetMapping(path = "/get_account_by_phonenumber")
    GenericAccountResponse getAccountByPhonenumber(@RequestHeader(AuthConstant.AUTHORIZATION_HEADER) String authz, @RequestParam @PhoneNumber String phoneNumber);

    @PutMapping(path = "/update_password")
    BaseResponse updatePassword(@RequestHeader(AuthConstant.AUTHORIZATION_HEADER) String authz, @RequestBody @Valid UpdatePasswordRequest request);

    @PostMapping(path = "/verify_password")
    GenericAccountResponse verifyPassword(@RequestHeader(AuthConstant.AUTHORIZATION_HEADER) String authz, @RequestBody @Valid VerifyPasswordRequest request);

    // RequestPasswordReset sends an email to a user with a password reset link
    @PostMapping(path = "/request_password_reset")
    BaseResponse requestPasswordReset(@RequestHeader(AuthConstant.AUTHORIZATION_HEADER) String authz, @RequestBody @Valid PasswordResetRequest request);

    @PostMapping(path = "/request_email_change")
    BaseResponse requestEmailChange(@RequestHeader(AuthConstant.AUTHORIZATION_HEADER) String authz, @RequestBody @Valid EmailChangeRequest request);

    // ChangeEmail sets an account to active and updates its email. It is
    // used after a user clicks a confirmation link in their email.
    @PostMapping(path = "/change_email")
    BaseResponse changeEmail(@RequestHeader(AuthConstant.AUTHORIZATION_HEADER) String authz, @RequestBody @Valid EmailConfirmation request);
}
