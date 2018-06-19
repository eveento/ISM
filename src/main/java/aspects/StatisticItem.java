package aspects;

import java.io.Serializable;

public class StatisticItem {

	String className;
	String methodName;
	Integer counter;
	
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public Integer getCounter() {
		return counter;
	}
	public void setCounter(Integer counter) {
		this.counter = counter;
	}	
	public void incrementCounter() {
		counter++;
	}
	public void printf() {
		System.out.println("Class name: "+className);
		System.out.println("Method name: " +methodName);
		System.out.println("Counter of execution: "+counter);
	}
	
}
