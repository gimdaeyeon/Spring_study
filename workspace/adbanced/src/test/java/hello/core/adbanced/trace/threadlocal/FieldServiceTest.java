package hello.core.adbanced.trace.threadlocal;

import hello.core.adbanced.trace.threadlocal.code.FieldService;
import io.micrometer.observation.Observation;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
public class FieldServiceTest {
    private FieldService fieldService = new FieldService();


    @Test
    void field() {
        log.info("main start");
        Runnable userA = () -> {
            fieldService.logic("userA");
        };

        Runnable userB = () -> {
            fieldService.logic("userB");
        };

        Thread threadA = new Thread(userA,"thread-A");
        Thread threadB = new Thread(userB,"thread-B");

        threadA.start();
//        sleep(2000); // 동시성 문제 발생X
        sleep(100); // 동시성 문제 발생O
        threadB.start();

        sleep(3000); // 메인 쓰레드 종료 대기
    }



    private void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
