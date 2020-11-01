package com.suresh.interpreter;

import java.util.Date;

public class MonthExpression extends AbstractExpression {

	@Override
	public void evaluate(Context context) {
		// TODO Auto-generated method stub
		String expression = context.getExpression();
	    Date date = context.getDate();
	    Integer month = new Integer(date.getMonth()+1);
	    String tempExpression = expression.replaceAll("MM", month.toString());
	    context.setExpression(tempExpression);
	}

}
