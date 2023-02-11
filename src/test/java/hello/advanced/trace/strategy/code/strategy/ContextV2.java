package hello.advanced.trace.strategy.code.strategy;

import lombok.extern.slf4j.Slf4j;


/**
 * 전략을 파라미터로 전달 받는 방식
 */
@Slf4j
public class ContextV2 {


    public void execute(Strategy strategy){
        long startTime = System.currentTimeMillis();
        //biz logic start
        strategy.call(); // 위임
        //logic end
        long endTime = System.currentTimeMillis();
        long resultTIme = endTime - startTime;
        log.info("resultTime={}",resultTIme);
    }
}
