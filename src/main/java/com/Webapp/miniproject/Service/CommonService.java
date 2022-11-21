package com.Webapp.miniproject.Service;

public interface CommonService {

	public long nextSequenceNumber() throws Exception;

	String getMessage(String messageKey, String[] params, String lang) throws Exception;
}
