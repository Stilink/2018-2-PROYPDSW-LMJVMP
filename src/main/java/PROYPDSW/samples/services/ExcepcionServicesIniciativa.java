package PROYPDSW.samples.services;

public class ExcepcionServicesIniciativa extends Exception{
	public ExcepcionServicesIniciativa (String msg, Exception e) {
		super(msg, e);
	}
	public ExcepcionServicesIniciativa (String msg) {
		super(msg);
	}
}