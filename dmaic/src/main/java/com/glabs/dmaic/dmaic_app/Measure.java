package com.glabs.dmaic.dmaic_app;

import javax.persistence.Embeddable;

@Embeddable
public class Measure {

		
	private Long current;

	private Long target;
	
	
	public Measure() {
		
	}

	public Long getCurrent() {
		return current;
	}


	public void setCurrent(Long current) {
		this.current = current;
	}


	public Long getTarget() {
		return target;
	}


	public void setTarget(Long target) {
		this.target = target;
	}
}
