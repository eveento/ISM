/*
 * LoggingWithAspectJ - Logging with AspectJ
 * Copyright (C) 2007 Christian Schenk
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA
 */
package aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;

import net.javabeat.spring.data.domain.Canoe;

@Aspect
@Component
public class MyAspect {
	/*
	 *static int [2]counter = [logCounterById()], [logCounterByStatus()], [logCounterBySize()]
	 */
	static int counter[]={0,0,0};

	/**
	 * Will log every execution of Student's methods
	 */
	@Around("execution(* net.javabeat.spring.data.web.CanoesController.*(..))")
	public Object doThing(final ProceedingJoinPoint thisJoinPoint) throws Throwable {
	/*	final String joinPointName = thisJoinPoint.getThis().getClass().getSimpleName() + "." + thisJoinPoint.getSignature().getName() + "()";
		System.out.println("Entering [" + joinPointName + "]");
		Object retVal = thisJoinPoint.proceed();
		System.out.println("Leaving  [" + joinPointName + "]");
		return retVal;*/
		StatisticItem si= new StatisticItem();
		
		long start=System.currentTimeMillis();
		String cName=thisJoinPoint.getSignature().getDeclaringTypeName();
		String mName=thisJoinPoint.getSignature().getName();
		Object retVal=thisJoinPoint.proceed();
		long stop=System.currentTimeMillis()-start;
		
		si.setClassName(cName);
		si.setMethodName(mName);
		
		StatisticRepository.addNewElement(si);
		
		System.out.println("************");
		
		System.out.println("Class name: "+cName);
		System.out.println("Method name: " +mName);
		System.out.println("Execution time: "+stop+"ms");
		
		//StatisticRepository.printf();
		System.out.println("************");
		return retVal;
	}
	
	@Before("execution(* net.javabeat.spring.data.web.CanoesController.getCanoeById(..))")
	public void logCounterById()
	{
		counter[0]++;
		System.out.println("@Before:"+counter[0]);
	}
	@Before("execution(* net.javabeat.spring.data.web.CanoesController.findByStats(..))")
	public void logCounterByStatus()
	{
		counter[1]++;
		System.out.println("@Before:"+counter[1]);
	}
	@Before("execution(* net.javabeat.spring.data.web.CanoesController.getCanoeBySize(..))")
	public void logCounterBySize()
	{
		counter[2]++;
		System.out.println("@Before:"+counter[2]);
	}
	
}