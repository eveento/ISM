package aspects;

import java.util.ArrayList;
import java.util.List;

public final class StatisticRepository {
	
	static List<StatisticItem> list = new ArrayList<StatisticItem>();
	
	
	public static List<StatisticItem> getList(){
		return list;
	}
	
	public static boolean checkIfElementExist(String methodName) {
		if(methodName.isEmpty())
			return false;
		else {
			for(int i=0;i<list.size()-1;i++) {
				if(list.get(i).getMethodName().equals(methodName)) {
					return true;
				}
			}
			return false;	
		}
	}
	
	public static void findElement(String methodName)
	{	
		for(int i=0;i<list.size()-1;i++) {
			if(list.get(i).getMethodName().equals(methodName)) {
				list.get(i).incrementCounter();
			}
		}
	}
		
	public static void addNewElement(StatisticItem si) {
		
		if(!checkIfElementExist(si.getMethodName())) {
			si.setCounter(1);
			list.add(si);
		}else {
			findElement(si.getMethodName());
		}
	}

	public static void printf()
	{
		for(int i=0;i<list.size()-1;i++) {
			list.get(i).printf();
		}
	}
}
