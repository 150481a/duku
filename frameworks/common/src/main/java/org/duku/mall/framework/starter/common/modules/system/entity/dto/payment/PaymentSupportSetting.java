package org.duku.mall.framework.starter.common.modules.system.entity.dto.payment;

import lombok.Data;
import lombok.experimental.Accessors;
import org.duku.mall.framework.starter.convention.enums.ClientTypeEnum;
import org.duku.mall.framework.starter.common.modules.payment.entity.enums.PaymentMethodEnum;
import org.duku.mall.framework.starter.common.modules.system.entity.dto.payment.dto.PaymentSupportForm;
import org.duku.mall.framework.starter.common.modules.system.entity.dto.payment.dto.PaymentSupportItem;

import java.util.ArrayList;
import java.util.List;

@Data
@Accessors(chain = true)
public class PaymentSupportSetting {

    private List<PaymentSupportItem> paymentSupportItems;


    public PaymentSupportSetting() {

    }

    public PaymentSupportSetting(PaymentSupportForm paymentSupportForm) {

        List<PaymentSupportItem> paymentSupportItems = new ArrayList<>();

        for (ClientTypeEnum client : paymentSupportForm.getClients()) {
            PaymentSupportItem paymentSupportItem = new PaymentSupportItem();

            List<String> supports = new ArrayList<>();
            for (PaymentMethodEnum payment : paymentSupportForm.getPayments()) {
                supports.add(payment.name());
            }
            paymentSupportItem.setClient(client.name());
            paymentSupportItem.setSupports(supports);
            paymentSupportItems.add(paymentSupportItem);

        }
        this.paymentSupportItems = paymentSupportItems;
    }
}
