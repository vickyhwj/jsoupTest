package aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;

import cache.QueryCahce;

public class Aopa implements MethodInterceptor{

	@Override
	public Object invoke(MethodInvocation arg0) throws Throwable {
		// TODO Auto-generated method stub
		
		
		return around(arg0);
	}
	public Object around(MethodInvocation joinPoint) throws Throwable{
		long start=System.currentTimeMillis();
		Object[] o=joinPoint.getArguments();
		String query=(String) o[0];
		for(int i=1;i<o.length;++i)
			query+=" "+o[i];
		Object result=QueryCahce.getSeason_teamMap().get(query);
		if(result==null){
			synchronized(LoggerAOP.class){
				result=QueryCahce.getSeason_teamMap().get(query);
				if(result==null){
					result =joinPoint.proceed();
					QueryCahce.getSeason_teamMap().put(query,result);
				}
			}
		}
		System.out.println("总time:"+(System.currentTimeMillis()-start));
		return result;
		
	}
}
