package com.liferay.travels.rest.client.function;

import javax.annotation.Generated;

/**
 * @author Javier de Arcos
 * @generated
 */
@FunctionalInterface
@Generated("")
public interface UnsafeSupplier<T, E extends Throwable> {

	public T get() throws E;

}