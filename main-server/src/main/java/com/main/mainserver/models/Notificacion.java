package com.main.mainserver.models;

public class Notificacion {

	private Long idMain;
	private String _id;
	private String resource;
	private long user_id;
	private String topic;
	private long application_id;
	private int attempts;
	private String sent;
	private String received;

	public Notificacion() {
	}

	public Notificacion(String _id, String resource, long user_id, String topic, long application_id, int attempts,
			String sent, String received) {
		this._id = _id;
		this.resource = resource;
		this.user_id = user_id;
		this.topic = topic;
		this.application_id = application_id;
		this.attempts = attempts;
		this.sent = sent;
		this.received = received;
	}
}
