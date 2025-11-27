package org.example.boardback.service.payment.gateway;

import lombok.RequiredArgsConstructor;
import org.example.boardback.common.enums.payment.PaymentMethod;
import org.springframework.stereotype.Component;

/**
 * === 결제 수단에 맞는 Gateway 선택 ===
 * : 결제 수단에 따라 적절한 PaymentGateWay 구현체를 반환하는 Resolver
 *
 * - PaymentService는 "어떤 PG를 사용할지" 알 필요 없이
 *      단순히 method만 남기면 Resolver가 알맞는 GateWay를 반환함
 * */
@Component
@RequiredArgsConstructor
public class PaymentGatewayResolver {

    private final MockPaymentGateWay mockPaymentGateWay;
    private final TossPayGateWay tossPayGateWay;
    private final KakaoPayGateWay kakaoPayGateWay;

    // 결제 수단에 따라 대응되는 Gateway 구현체 반환
    public PaymentGateway resolve(PaymentMethod method) {
        return switch (method) {
            case MOCK -> mockPaymentGateWay;
            case TOOS_PAY -> tossPayGateWay;
            case KAKAO_PAY -> kakaoPayGateWay;
        };
    }
}
