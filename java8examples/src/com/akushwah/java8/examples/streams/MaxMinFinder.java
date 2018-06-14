package com.akushwah.java8.examples.streams;

public class MaxMinFinder {
	private String max;
	private String min;

	public String getMax() {
		return max;
	}

	public String getMin() {
		return min;
	}

	public void accumulate(String s) {
		if (s != null) {
			if (min == null) {
				min = s;
			} else if (min.compareTo(s) > 0) {
				min = s;
			}
		}

		if (s != null) {
			if (max == null) {
				max = s;
			} else if (max.compareTo(s) < 0) {
				max = s;
			}
		}
	}

	public void combine(MaxMinFinder mmf) {
		if (min == null) {
			min = mmf.min;
		} else if (min.compareTo(mmf.min) > 0) {
			min = mmf.min;
		}

		if (max == null) {
			max = mmf.max;
		} else if (max.compareTo(mmf.max) < 0) {
			max = mmf.max;
		}
	}
}
