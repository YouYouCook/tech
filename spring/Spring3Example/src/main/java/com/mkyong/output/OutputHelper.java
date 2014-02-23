package com.mkyong.output;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mkyong.core.HelloWorld;
import com.mkyong.output.IOutputGenerator;

public class OutputHelper
{
	IOutputGenerator outputGenerator;
 
	public void setOutputGenerator(IOutputGenerator outputGenerator){
		this.outputGenerator = outputGenerator;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"SpringBeans.xml");
		OutputHelper helper = (OutputHelper) context.getBean("OutputHelper");
		helper.outputGenerator.outPut();
	}
 
}