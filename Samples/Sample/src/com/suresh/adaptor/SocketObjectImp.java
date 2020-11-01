package com.suresh.adaptor;

public class SocketObjectImp implements SocketInterface {
	Socket sock = new Socket();

	@Override
	public Volt get120Volts() {
		// TODO Auto-generated method stub
		return sock.getVolt();
	}

	@Override
	public Volt get3Volts() {
		// TODO Auto-generated method stub
		Volt v = sock.getVolt();
		return convertVolt(v, 40);
	}

	@Override
	public Volt get12Volts() {
		// TODO Auto-generated method stub
		Volt v = sock.getVolt();
		return convertVolt(v, 10);
	}

	private Volt convertVolt(Volt v, int i) {
		return new Volt(v.getVolts() / i);
	}

}
