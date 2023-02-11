package hello.advanced.trace.strategy.template;

import hello.advanced.trace.strategy.code.strategy.Strategy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TimeLogTemplate {

    public void execute(Callback callback){
        long startTime = System.currentTimeMillis();
        //biz logic start
        callback.call(); // 위임
        //logic end
        long endTime = System.currentTimeMillis();
        long resultTIme = endTime - startTime;
        log.info("resultTime={}",resultTIme);
    }
}
