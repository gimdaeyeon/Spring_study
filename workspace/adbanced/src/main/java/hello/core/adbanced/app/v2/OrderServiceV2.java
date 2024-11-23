package hello.core.adbanced.app.v2;

import hello.core.adbanced.trace.TraceId;
import hello.core.adbanced.trace.TraceStatus;
import hello.core.adbanced.trace.hellotrace.HelloTraceV1;
import hello.core.adbanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV2 {
    private final OrderRepositoryV2 orderRepository;
    private final HelloTraceV2 trace;

    public void orderItem(TraceId traceId, String itemId) {
        TraceStatus status = null;
        try {
            status = trace.beginSync(traceId,"OrderServiceV1.orderItem()");
            orderRepository.save(status.getTraceId(),itemId);
            trace.end(status);
        } catch (Exception e) {
            trace.exception(status, e);
            throw e;
        }

    }
}