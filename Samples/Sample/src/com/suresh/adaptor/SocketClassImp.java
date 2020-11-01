package com.suresh.adaptor;

public class SocketClassImp extends Socket implements SocketInterface {

	@Override
	public Volt get120Volts() {
		// TODO Auto-generated method stub
		return getVolt();
	}

	@Override
	public Volt get3Volts() {
		Volt v = getVolt();
		// TODO Auto-generated method stub
		return convertVolt(v,40);
	}

	@Override
	public Volt get12Volts() {
		// TODO Auto-generated method stub
		Volt v = getVolt();
		return convertVolt(v, 10);
	}
	
	private Volt convertVolt(Volt v, int i){
		return (new Volt(v.getVolts()/i));
	}
}
