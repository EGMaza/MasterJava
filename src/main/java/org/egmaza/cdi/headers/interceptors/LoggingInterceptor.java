package org.egmaza.cdi.headers.interceptors;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

import java.util.logging.Logger;

@Logging
@Interceptor
public class LoggingInterceptor {

    @Inject
    private Logger log;

    @AroundInvoke
    public Object logging(InvocationContext invocation) throws Exception {
        log.info(" ***** entrando antes de invocar al método " +
                invocation.getMethod().getName() + " de la clase " +
                invocation.getMethod().getDeclaringClass() + "*****");
        Object resultado = invocation.proceed();
        log.info("***** fin de la ejecución del método envuelto " +
                invocation.getMethod().getName() + " *****");
        return resultado;
    }
}
