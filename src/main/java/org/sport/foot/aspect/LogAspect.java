package org.sport.foot.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;



//todo сделать логирование названия метода в который вошли и вышли
@Aspect
public class LogAspect {

    @Before("execution()/greeting()")
    public void beforeGetFindById() {

    }

}
