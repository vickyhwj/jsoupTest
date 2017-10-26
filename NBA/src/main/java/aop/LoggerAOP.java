package aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import cache.QueryCahce;

//@Aspect
public class LoggerAOP {
	//@Before("(execution(* com.example.dao.PlayerDAO.getPlayersBySeason_Team(..)))")
	public void addLog(JoinPoint joinpoint){
		System.out.println("aaaaaaaaaaaaaaaaaaa");
		for(Object o:joinpoint.getArgs())
			System.out.println(o);;
		
	}
	
//	@Pointcut("(execution(* com.example.dao.PlayerDAO.getPlayersBySeason_Team(..))) or (execution(* com.example.dao.PlayerDAO.findPlayerByLikeId(..)))")
//	@Around("(execution(* com.example.dao.PlayerDAO.getPlayersBySeason_Team(..))) && (execution(* com.example.dao.PlayerDAO.findPlayerByLikeId(..)))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		long start=System.currentTimeMillis();
		Object[] o=joinPoint.getArgs();
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
	
	
//	@AfterReturning(returning="retValue",pointcut="execution(* com.example.dao.PlayerDAO.getPlayersBySeason_Team(..))")
	public void aroundMethod(JoinPoint joinPoint,Object retValue) throws Throwable {
	/*	Object[] o=joinPoint.getArgs();
		System.out.println(o);
       System.out.print(retValue);*/
      
    

		
	}
	 
}
