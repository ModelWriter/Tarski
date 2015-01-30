package org.eclipse.emf.doc2model.engine.actions;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.doc2model.doc2model.Value;

public class ValueResolver {
	private Map<Value, Object> values = new HashMap<Value, Object>();

	public Object getValue(Value v) {
		return values.get(v);
	}

	public void setValue(Value v, Object o) {
		values.put(v, o);
	}

	public void clear() {
		values.clear();
	}

}
