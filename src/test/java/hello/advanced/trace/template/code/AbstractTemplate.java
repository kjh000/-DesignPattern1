package hello.advanced.trace.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class AbstractTemplate {

    public void execute(){
        long startTime = System.currentTimeMillis();
        //biz logic start
        call(); //상속
        //logic end
        long endTime = System.currentTimeMillis();
        long resultTIme = endTime - startTime;
        log.info("완료시간={}",resultTIme);
    }

    protected abstract void call();
}
