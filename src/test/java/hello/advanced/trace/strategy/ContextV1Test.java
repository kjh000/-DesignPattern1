package hello.advanced.trace.strategy;

import hello.advanced.trace.strategy.code.strategy.ContextV1;
import hello.advanced.trace.strategy.code.strategy.Strategy;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic1;
import hello.advanced.trace.strategy.code.strategy.StrategyLogic2;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class ContextV1Test {

    @Test
    void strategy
            (){
        logic1();
        logic2();
    }

    private void logic1(){
        long startTime = System.currentTimeMillis();
        //biz logic start
        log.info("biz logic1 start");
        //logic end
        long endTime = System.currentTimeMillis();
        long resultTIme = endTime - startTime;
        log.info("resultTime={}",resultTIme);
    }


    private void logic2(){
        long startTime = System.currentTimeMillis();
        //biz logic start
        log.info("biz logic2 start");
        //logic end
        long endTime = System.currentTimeMillis();
        long resultTIme = endTime - startTime;
        log.info("resultTime={}",resultTIme);
    }

    @Test
    void strategyV1(){
        StrategyLogic1 strategyLogic1 = new StrategyLogic1();
        ContextV1 contextV1 = new ContextV1(strategyLogic1);
        contextV1.execute();

        StrategyLogic2 strategyLogic2 = new StrategyLogic2();
        ContextV1 contextV2 = new ContextV1(strategyLogic2);
        contextV2.execute();
    }

    @Test
    void strategyV2(){
        Strategy strategyLogic1 = new Strategy() {
            @Override
            public void call() {
                log.info("비지니스 로직 1 실행");
            }
        };
        ContextV1 context1 = new ContextV1(strategyLogic1);
        context1.execute();
        log.info("strategyLogic1={}",strategyLogic1.getClass());


        Strategy strategyLogic2 = new Strategy() {
            @Override
            public void call() {
                log.info("비지니스 로직 2 실행");
            }
        };
        ContextV1 context2 = new ContextV1(strategyLogic2);
        context2.execute();
        log.info("strategyLogic1={}",strategyLogic2.getClass());

    }

    @Test
    void strategyV3(){

        ContextV1 context1 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("비지니스 로직 1 실행");
            }
        });
        context1.execute();

        ContextV1 context2 = new ContextV1(new Strategy() {
            @Override
            public void call() {
                log.info("비지니스 로직 2 실행");
            }
        });
        context2.execute();

    }

    @Test
    void strategyV4(){

        /**
         * 람다로 변경하려면 인터페이스에 메서드가 1개만 있어야됨
         */
        ContextV1 context1 = new ContextV1(() -> log.info("비지니스 로직 1 실행"));
        context1.execute();

        ContextV1 context2 = new ContextV1(() -> log.info("비지니스 로직 2 실행"));
        context2.execute();

    }



}
