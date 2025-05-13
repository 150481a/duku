package org.duku.mall.framework.starter.common.modules.order.order.entity.vo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.duku.mall.framework.starter.common.modules.order.order.entity.dos.OrderComplaintCommunication;
@Data
@NoArgsConstructor
public class OrderComplaintCommunicationVO extends OrderComplaintCommunication {
    private static final long serialVersionUID = -8460949951683122695L;

    public OrderComplaintCommunicationVO(String complainId, String content, String owner, String ownerName, String ownerId) {
        super(complainId, content, owner, ownerName, ownerId);
    }

}
