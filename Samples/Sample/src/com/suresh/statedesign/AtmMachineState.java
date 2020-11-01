package com.suresh.statedesign;

public interface AtmMachineState {
	public void insertDebitCard();

	public void ejectDebitCard();

	public void enterPinAndWithdrawMoney();
}
