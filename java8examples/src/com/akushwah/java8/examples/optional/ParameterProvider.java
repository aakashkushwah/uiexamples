package com.akushwah.java8.examples.optional;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@FunctionalInterface
public interface ParameterProvider {

	<T> Optional<T> get(Class<T> type, String key);
	

	static ParameterProvider of(Function<String, Object> f) {
		return new ParameterProvider() {
			@Override
			public <T> Optional<T> get(Class<T> type, String key) {
				return Optional.ofNullable(f.apply(key)).filter(type::isInstance).map(type::cast);
			}
		};
	}

	static ParameterProvider of(Map<String, ?> map) {
		return new ParameterProvider() {
			@Override
			public <T> Optional<T> get(Class<T> type, String key) {
				return Optional.ofNullable(map).map(m -> m.get(key)).filter(type::isInstance).map(type::cast);
			}
		};
	}

}
