package com.markos.jpa.service.filter;

public class LongFilter extends RangeFilter<Long> {
	private static final long serialVersionUID = 1L;
	private String contains;

	public LongFilter() {
	}

	public String getContains() {
		return this.contains;
	}

	public LongFilter setContains(String contains) {
		this.contains = contains;
		return this;
	}
}
