package org.duku.mall.framework.starter.common.modules.system.entity.dto.payment.dto;

import lombok.Data;
import lombok.experimental.Accessors;
import org.duku.mall.framework.starter.convention.enums.ClientTypeEnum;
import org.duku.mall.framework.starter.common.modules.payment.entity.enums.PaymentMethodEnum;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
public class PaymentSupportForm {

    /**
     * 客户端类型列表
     *
     * @return 客户端类型
     */
    public List<ClientTypeEnum> getClients() {
        List<ClientTypeEnum> keys = new ArrayList<>();
        for (ClientTypeEnum clientTypeEnum : ClientTypeEnum.values()) {
            if (clientTypeEnum.equals(ClientTypeEnum.UNKNOWN)){
                continue;
            }
            keys.add(clientTypeEnum);
        }
        return keys;
    }

    /**
     * 支付方式列表
     *
     * @return 即支持的支付方式集合
     */
    public List<PaymentMethodEnum> getPayments() {

        List<PaymentMethodEnum> keys = new ArrayList<>();
        for (PaymentMethodEnum paymentMethodEnum : PaymentMethodEnum.values()) {
            if (paymentMethodEnum.equals(PaymentMethodEnum.BANK_TRANSFER)){
                continue;
            }
            keys.add(paymentMethodEnum);
        }
        return keys;
    }

}
