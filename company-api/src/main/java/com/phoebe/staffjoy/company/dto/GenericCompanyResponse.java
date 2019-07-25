package com.phoebe.staffjoy.company.dto;

import com.phoebe.staffjoy.common.api.BaseResponse;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class GenericCompanyResponse extends BaseResponse {
    private CompanyDto company;
}
