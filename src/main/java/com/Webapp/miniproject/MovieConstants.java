package com.Webapp.miniproject;

public final class MovieConstants {

	private MovieConstants() throws InstantiationException {
		throw new InstantiationException("Instances of this type are forbidden.");
	}
	
	/** INACTIVE - 0. */
	public static final int INACTIVE = 0;

	/** ACTIVE - 1. */
	public static final int ACTIVE = 1;

	/** RETURN_STATUS_OK - 0. */
	public static final int RETURN_STATUS_OK = 0;

	/** RETURN_STATUS_ERROR - 1. */
	public static final int RETURN_STATUS_ERROR = 1;
}
