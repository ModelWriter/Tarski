grammar GenericTypeAnalysis;

classifierTemplateSignature:
    '<' ownedTypeParameters+= classifierTypeParameter (',' ownedTypeParameters+= classifierTypeParameter)* '>'
;

classifierTypeParameter:
	name= unrestrictedName ('extends' ownedEBounds+= classifierGenericBoundType ('&' ownedEBounds+= classifierGenericBoundType)*)?
;

classifierGenericBoundType:
    // classifierref, generictypeclassref, not primitive, not typeparameterref, not wildcardref.
        // genericTypeClassref's templateBinding should be:
        // classifierref, generictypeclassref, not primitive, typeparameterref, wildcardref.
            // genericTypeClassref's templateBinding should be:
            // classifierref, generictypeclassref, not primitive, typeparameterref, wildcardref.
            // wildcardref's extend should be:
            // classifierref, generictypeclassref, not primitive, typeparameterref, not wildcardref.
	ownedPathName= pathName ('<' ownedETypeArguments= templateBinding '>')?
;

operationTemplateSignature:
    '<' ownedTypeParameters+= operationTypeParameter (',' ownedTypeParameters+= operationTypeParameter)* '>'
;

operationTypeParameter:
	name= unrestrictedName ('extends' ownedEBounds+= operationGenericBoundType ('&' ownedEBounds+= operationGenericBoundType)*)?
;

operationGenericBoundType:
    // classifierref, generictypeclassref, not primitive, <!-- typeparameterref in scope --> , not wildcardref.
        // genericTypeClassref's templateBinding should be:
        // classifierref, generictypeclassref, not primitive, typeparameterref, wildcardref.
            // genericTypeClassref's templateBinding should be:
            // classifierref, generictypeclassref, not primitive, typeparameterref, wildcardref.
            // wildcardref's extend should be:
            // classifierref, generictypeclassref, not primitive, typeparameterref, not wildcardref.
	ownedPathName= pathName ('<' ownedETypeArguments= templateBinding '>')?
;



classSuperTypeRef:
    // should be:
    // classifierref, generictypeclassref, not primitive, not typeparameterref, not wildcardref.
        // genericTypeClassref's templateBinding should be:
        // classifierref, generictypeclassref, not primitive, typeparameterref, wildcardref.
;


attributeTypeRef:
    // should be:
    // enumRef, datatypeRef, not classref, generictypeclassref, primitive, typeparameterref, not wildcardref.
        // genericTypeClassref's templateBinding should be:
        // classifierref, generictypeclassref, not primitive, typeparameterref, wildcardref.
;

referenceTypeRef:
    // should be:
    // not enumRef, not datatypeRef, classref, generictypeclassref, not primitive, typeparameterref, not wildcardref.
        // genericTypeClassref's templateBinding should be:
        // classifierref, generictypeclassref, not primitive, typeparameterref, wildcardref.
;

operationReturnTypeRef:
    // should be:
    // classifierref, generictypeclassref, primitive, typeparameterref, not wildcardref.
        // genericTypeClassref's templateBinding should be:
        // classifierref, generictypeclassref, not primitive, typeparameterref, wildcardref.
;

operationParameterTypeRef:
    // should be:
    // classifierref, generictypeclassref, primitive, typeparameterref, not wildcardref.
        // genericTypeClassref's templateBinding should be:
        // classifierref, generictypeclassref, not primitive, typeparameterref, wildcardref.
;

operationExceptionTypeRef:
    // should be:
    // classifierref, generictypeclassref, not primitive, typeparameterref, not wildcardref.
        // genericTypeClassref's templateBinding should be:
        // classifierref, generictypeclassref, not primitive, typeparameterref, wildcardref.
;