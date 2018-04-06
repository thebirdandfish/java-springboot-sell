package top.linxz.sell.service;

import com.lly835.bestpay.model.PayResponse;
import top.linxz.sell.dto.OrderDTO;

public interface PayService {

    PayResponse create(OrderDTO orderDTO);

    PayResponse notify(String notifyData);

}
