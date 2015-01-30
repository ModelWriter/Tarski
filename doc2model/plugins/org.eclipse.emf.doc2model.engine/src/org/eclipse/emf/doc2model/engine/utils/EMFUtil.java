package org.eclipse.emf.doc2model.engine.utils;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.util.EcoreUtil;

public class EMFUtil {
	public static EAttribute getEAttributeByName(EClass eclass,
			String attributeName) {
		for (EAttribute a : eclass.getEAllAttributes()) {
			if (attributeName.equals(a.getName())) {
				return a;
			}
		}
		return null;
	}

	public static EStructuralFeature getFeatureByName(EClass eclass,
			String attributeName) {
		for (EStructuralFeature a : eclass.getEAllStructuralFeatures()) {
			if (attributeName.equals(a.getName())) {
				return a;
			}
		}
		return null;
	}

	public static Object getCorrespondingValue4Type(EAttribute attr,
			String value) {
		String javaInstanceTypeName = EcoreUtil.toJavaInstanceTypeName(attr
				.getEGenericType());
		try {
			if ("boolean".equals(javaInstanceTypeName)
					|| "java.lang.Boolean".equals(javaInstanceTypeName)) {
				if ("false".equals(value.toLowerCase())
						|| "true".equals(value.toLowerCase())) {
					return Boolean.valueOf(value);
				} else {
					// Activator.log(new
					// Exception(String.format("The value %s can't be assigned in Boolean, false is setted by default",
					// value)));
					return false;
				}
			} else if ("integer".equals(javaInstanceTypeName)
					|| "java.lang.Integer".equals(javaInstanceTypeName)) {
				return Integer.valueOf(value);
			} else if ("double".equals(javaInstanceTypeName)
					|| "java.lang.Double".equals(javaInstanceTypeName)) {
				return Double.valueOf(value);
			} else if ("float".equals(javaInstanceTypeName)
					|| "java.lang.Float".equals(javaInstanceTypeName)) {
				return Float.valueOf(value);
			}
			if (attr.getEAttributeType() instanceof EEnum) {
				return getENumValue((EEnum) attr.getEAttributeType(), value);
			} else {
				return value;
			}
		} catch (NumberFormatException e) {
			// Activator.log(new
			// Exception(String.format("The value %s can't be assigned to this type : %s",
			// value, javaInstanceTypeName)));
			return null;
		}
	}

	protected static Object getENumValue(EEnum enumType, String value) {
		if (value == null) {
			return null;
		}
		String toLower = value.toLowerCase().trim();
		for (EEnumLiteral l : enumType.getELiterals()) {
			if (l.getName() != null
					&& l.getName().toLowerCase().trim().equals(toLower)) {
				return l.getInstance();
			}
		}
		return null;
	}
}
