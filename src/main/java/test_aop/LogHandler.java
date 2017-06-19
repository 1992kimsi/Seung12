package test_aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogHandler implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation method) throws Throwable {
		System.out.println("¸Þ··~ ¾ÕÀØ·Õ");
		Object result = method.proceed();
		System.out.println("¸Þ··~µÚÁö·æ");
		return result;
	}
	
}
