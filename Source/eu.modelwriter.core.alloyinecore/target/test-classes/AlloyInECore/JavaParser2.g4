parser grammar JavaParser2;

options {
    tokenVocab = JavaLexer;
}

packageName
    : Identifier (DOT Identifier)*
    ;
    
typeName
    : Identifier
    | packageOrTypeName DOT Identifier
    ;
    
packageOrTypeName
    : Identifier (DOT Identifier)*
    ;
    
expressionName
    : Identifier
    | ambiguousName DOT Identifier
    ;
    
methodName
    : Identifier
    ;
    
ambiguousName
    : Identifier (DOT Identifier)*
    ;
    
simpleTypeName
    : Identifier
    ;
    
typeParameterModifier
    : annotation
    ;

literal
    : IntegerLiteral
    | FloatingPointLiteral
    | BooleanLiteral
    | CharacterLiteral
    | StringLiteral
    | NullLiteral
    ;

type
    : primitiveType
    | referenceType
    ;

primitiveType
    : (annotation)* numericType
    | (annotation)* BOOLEAN
    ;

numericType
    : integralType
    | floatingPointType
    ;

integralType
    : BYTE
    | SHORT
    | INT
    | LONG
    | CHAR
    ;

floatingPointType
    : FLOAT
    | DOUBLE
    ;

referenceType
    : classOrInterfaceType
    | typeVariable
    | arrayType
    ;

classOrInterfaceType
    : classType
    | interfaceType
    ;

classType
    : (annotation)* Identifier (typeArguments)?
    | classType DOT (annotation)* Identifier (typeArguments)?
    ;

interfaceType
    : classType
    ;

typeVariable
    : (annotation)* Identifier
    ;

arrayType
    : primitiveType dims
    | classOrInterfaceType dims
    | typeVariable dims
    ;

dims
    : (annotation)* L_BRACKET R_BRACKET ((annotation)* L_BRACKET R_BRACKET)*
    ;

typeParameter
    : (typeParameterModifier)* Identifier (typeBound)?
    ;

typeBound
    : EXTENDS typeVariable
    | EXTENDS classOrInterfaceType (additionalBound)*
    ;

additionalBound
    : B_AND interfaceType
    ;

typeArguments
    : LT typeArgumentList GT
    ;

typeArgumentList
    : typeArgument (COMMA typeArgument)*
    ;

typeArgument
    : referenceType
    | wildcard
    ;

wildcard
    : (annotation)* QUES (wildcardBounds)?
    ;

wildcardBounds
    : EXTENDS referenceType
    | SUPER referenceType
    ;

compilationUnit
    : (packageDeclaration)? (importDeclaration)* (typeDeclaration)*
    ;

packageDeclaration
    : (packageModifier)* PACKAGE Identifier (DOT Identifier)* SEMI
    ;

packageModifier
    : annotation
    ;

importDeclaration
    : singleTypeImportDeclaration
    | typeImportOnDemandDeclaration
    | singleStaticImportDeclaration
    | staticImportOnDemandDeclaration
    ;

singleTypeImportDeclaration
    : IMPORT typeName SEMI
    ;

typeImportOnDemandDeclaration
    : IMPORT packageOrTypeName DOT MULT SEMI
    ;

singleStaticImportDeclaration
    : IMPORT STATIC typeName DOT Identifier SEMI
    ;

staticImportOnDemandDeclaration
    : IMPORT STATIC typeName DOT MULT SEMI
    ;

typeDeclaration
    : classDeclaration
    | interfaceDeclaration
    | SEMI
    ;

classDeclaration
    : normalClassDeclaration
    | enumDeclaration
    ;

normalClassDeclaration
    : (classModifier)* CLASS Identifier (typeParameters)? (superclass)? (superinterfaces)? classBody
    ;

classModifier
    : annotation
    | PUBLIC
    | PROTECTED
    | PRIVATE
    | ABSTRACT
    | STATIC
    | FINAL
    | STRICTFP
    ;

typeParameters
    : LT typeParameterList GT
    ;

typeParameterList
    : typeParameter (COMMA typeParameter)*
    ;

superclass
    : EXTENDS classType
    ;

superinterfaces
    : IMPLEMENTS interfaceTypeList
    ;

interfaceTypeList
    : interfaceType (COMMA interfaceType)*
    ;

classBody
    : L_CURLY (classBodyDeclaration)* R_CURLY
    ;

classBodyDeclaration
    : classMemberDeclaration
    | instanceInitializer
    | staticInitializer
    | constructorDeclaration
    ;

classMemberDeclaration
    : fieldDeclaration
    | methodDeclaration
    | classDeclaration
    | interfaceDeclaration
    | SEMI
    ;

fieldDeclaration
    : (fieldModifier)* unannType variableDeclaratorList SEMI
    ;

fieldModifier
    : annotation
    | PUBLIC
    | PROTECTED
    | PRIVATE
    | STATIC
    | FINAL
    | TRANSIENT
    | VOLATILE
    ;

variableDeclaratorList
    : variableDeclarator (COMMA variableDeclarator)*
    ;

variableDeclarator
    : variableDeclaratorId (ASSIGN variableInitializer)?
    ;

variableDeclaratorId
    : Identifier (dims)?
    ;

variableInitializer
    : expression
    | arrayInitializer
    ;

unannType
    : unannPrimitiveType
    | unannReferenceType
    ;

unannPrimitiveType
    : numericType
    | BOOLEAN
    ;

unannReferenceType
    : unannClassOrInterfaceType
    | unannTypeVariable
    | unannArrayType
    ;

unannClassOrInterfaceType
    : unannClassType
    | unannInterfaceType
    ;

unannClassType
    : Identifier (typeArguments)?
    | unannClassType DOT (annotation)* Identifier (typeArguments)?
    ;

unannInterfaceType
    : unannClassType
    ;

unannTypeVariable
    : Identifier
    ;

unannArrayType
    : unannPrimitiveType dims
    | unannClassOrInterfaceType dims
    | unannTypeVariable dims
    ;

methodDeclaration
    : (methodModifier)* methodHeader methodBody
    ;

methodModifier
    : annotation
    | PUBLIC
    | PROTECTED
    | PRIVATE
    | ABSTRACT
    | STATIC
    | FINAL
    | SYNCHRONIZED
    | NATIVE
    | STRICTFP
    ;

methodHeader
    : result methodDeclarator (thro)?
    | typeParameters (annotation)* result methodDeclarator (thro)?
    ;

result
    : unannType
    | VOID
    ;

methodDeclarator
    : Identifier L_PARENS (formalParameterList)? R_PARENS (dims)?
    ;

formalParameterList
    : formalParameters COMMA lastFormalParameter
    | lastFormalParameter
    ;

formalParameters
    : formalParameter (COMMA formalParameter)*
    | receiverParameter (COMMA formalParameter)*
    ;

formalParameter
    : (variableModifier)* unannType variableDeclaratorId
    ;

variableModifier
    : annotation
    | FINAL
    ;

lastFormalParameter
    : (variableModifier)* unannType (annotation)* ELLIPSES variableDeclaratorId
    | formalParameter
    ;

receiverParameter
    : (annotation)* unannType (Identifier DOT)? THIS
    ;

thro
    : THROWS exceptionTypeList
    ;

exceptionTypeList
    : exceptionType (COMMA exceptionType)*
    ;

exceptionType
    : classType
    | typeVariable
    ;

methodBody
    : block
    | SEMI
    ;

instanceInitializer
    : block
    ;

staticInitializer
    : STATIC block
    ;

constructorDeclaration
    : (constructorModifier)* constructorDeclarator (thro)? constructorBody
    ;

constructorModifier
    : annotation
    | PUBLIC
    | PROTECTED
    | PRIVATE
    ;

constructorDeclarator
    : (typeParameters)? simpleTypeName L_PARENS (formalParameterList)? R_PARENS
    ;

constructorBody
    : L_CURLY (explicitConstructorInvocation)? (blockStatements)? R_CURLY
    ;

explicitConstructorInvocation
    : (typeArguments)? THIS L_PARENS (argumentList)? R_PARENS SEMI
    | (typeArguments)? SUPER L_PARENS (argumentList)? R_PARENS SEMI
    | expressionName DOT (typeArguments)? SUPER L_PARENS (argumentList)? R_PARENS SEMI
    | primary DOT (typeArguments)? SUPER L_PARENS (argumentList)? R_PARENS SEMI
    ;

enumDeclaration
    : (classModifier)* ENUM Identifier (superinterfaces)? enumBody
    ;

enumBody
    : L_CURLY (enumConstantList)? (COMMA)? (enumBodyDeclarations)? R_CURLY
    ;

enumConstantList
    : enumConstant (COMMA enumConstant)*
    ;

enumConstant
    : (enumConstantModifier)* Identifier (L_PARENS (argumentList)? R_PARENS)? (classBody)?
    ;

enumConstantModifier
    : annotation
    ;

enumBodyDeclarations
    : SEMI (classBodyDeclaration)*
    ;

interfaceDeclaration
    : normalInterfaceDeclaration
    | annotationTypeDeclaration
    ;

normalInterfaceDeclaration
    : (interfaceModifier)* INTERFACE Identifier (typeParameters)? (extendsInterfaces)? interfaceBody
    ;

interfaceModifier
    : annotation
    | PUBLIC
    | PROTECTED
    | PRIVATE
    | ABSTRACT
    | STATIC
    | STRICTFP
    ;

extendsInterfaces
    : EXTENDS interfaceTypeList
    ;

interfaceBody
    : L_CURLY (interfaceMemberDeclaration)* R_CURLY
    ;

interfaceMemberDeclaration
    : constantDeclaration
    | interfaceMethodDeclaration
    | classDeclaration
    | interfaceDeclaration
    | SEMI
    ;

constantDeclaration
    : (constantModifier)* unannType variableDeclaratorList SEMI
    ;

constantModifier
    : annotation
    | PUBLIC
    | STATIC
    | FINAL
    ;

interfaceMethodDeclaration
    : (interfaceMethodModifier)* methodHeader methodBody
    ;

interfaceMethodModifier
    : annotation
    | PUBLIC
    | ABSTRACT
    | DEFAULT
    | STATIC
    | STRICTFP
    ;

annotationTypeDeclaration
    : (interfaceModifier)* AT INTERFACE Identifier annotationTypeBody
    ;

annotationTypeBody
    : L_CURLY (annotationTypeMemberDeclaration)* R_CURLY
    ;

annotationTypeMemberDeclaration
    : annotationTypeElementDeclaration
    | constantDeclaration
    | classDeclaration
    | interfaceDeclaration
    | SEMI
    ;

annotationTypeElementDeclaration
    : (annotationTypeElementModifier)* unannType Identifier L_PARENS R_PARENS (dims)? (defaultValue)? SEMI
    ;

annotationTypeElementModifier
    : annotation
    | PUBLIC
    | ABSTRACT
    ;

defaultValue
    : DEFAULT elementValue
    ;

annotation
    : normalAnnotation
    | markerAnnotation
    | singleElementAnnotation
    ;

normalAnnotation
    : AT typeName L_PARENS (elementValuePairList)? R_PARENS
    ;

elementValuePairList
    : elementValuePair (COMMA elementValuePair)*
    ;

elementValuePair
    : Identifier ASSIGN elementValue
    ;

elementValue
    : conditionalExpression
    | elementValueArrayInitializer
    | annotation
    ;

elementValueArrayInitializer
    : L_CURLY (elementValueList)? (COMMA)? R_CURLY
    ;

elementValueList
    : elementValue (COMMA elementValue)*
    ;

markerAnnotation
    : AT typeName
    ;

singleElementAnnotation
    : AT typeName L_PARENS elementValue R_PARENS
    ;

arrayInitializer
    : L_CURLY (variableInitializerList)? (COMMA)? R_CURLY
    ;

variableInitializerList
    : variableInitializer (COMMA variableInitializer)*
    ;

block
    : L_CURLY (blockStatements)? R_CURLY
    ;

blockStatements
    : blockStatement (blockStatement)*
    ;

blockStatement
    : localVariableDeclarationStatement
    | classDeclaration
    | statement
    ;

localVariableDeclarationStatement
    : localVariableDeclaration SEMI
    ;

localVariableDeclaration
    : (variableModifier)* unannType variableDeclaratorList
    ;

statement
    : statementWithoutTrailingSubstatement
    | labeledStatement
    | ifThenStatement
    | ifThenElseStatement
    | whileStatement
    | forStatement
    ;

statementNoShortIf
    : statementWithoutTrailingSubstatement
    | labeledStatementNoShortIf
    | ifThenElseStatementNoShortIf
    | whileStatementNoShortIf
    | forStatementNoShortIf
    ;

statementWithoutTrailingSubstatement
    : block
    | emptyStatement
    | expressionStatement
    | assertStatement
    | switchStatement
    | doStatement
    | breakStatement
    | continueStatement
    | returnStatement
    | synchronizedStatement
    | throwStatement
    | tryStatement
    ;

emptyStatement
    : SEMI
    ;

labeledStatement
    : Identifier COLON statement
    ;

labeledStatementNoShortIf
    : Identifier COLON statementNoShortIf
    ;

expressionStatement
    : statementExpression SEMI
    ;

statementExpression
    : assignment
    | preIncrementExpression
    | preDecrementExpression
    | postfixExpression INCREMENT
    | postfixExpression DECREMENT
    | methodInvocation
    | classInstanceCreationExpression
    ;

ifThenStatement
    : IF L_PARENS expression R_PARENS statement
    ;

ifThenElseStatement
    : IF L_PARENS expression R_PARENS statementNoShortIf ELSE statement
    ;

ifThenElseStatementNoShortIf
    : IF L_PARENS expression R_PARENS statementNoShortIf ELSE statementNoShortIf
    ;

assertStatement
    : ASSERT expression SEMI
    | ASSERT expression COLON expression SEMI
    ;

switchStatement
    : SWITCH L_PARENS expression R_PARENS switchBlock
    ;

switchBlock
    : L_CURLY (switchBlockStatementGroup)* (switchLabel)* R_CURLY
    ;

switchBlockStatementGroup
    : switchLabels blockStatements
    ;

switchLabels
    : switchLabel (switchLabel)*
    ;

switchLabel
    : CASE constantExpression COLON
    | CASE enumConstantName COLON
    | DEFAULT COLON
    ;

enumConstantName
    : Identifier
    ;

whileStatement
    : WHILE L_PARENS expression R_PARENS statement
    ;

whileStatementNoShortIf
    : WHILE L_PARENS expression R_PARENS statementNoShortIf
    ;

doStatement
    : DO statement WHILE L_PARENS expression R_PARENS SEMI
    ;

forStatement
    : basicForStatement
    | enhancedForStatement
    ;

forStatementNoShortIf
    : basicForStatementNoShortIf
    | enhancedForStatementNoShortIf
    ;

basicForStatement
    : FOR L_PARENS (forInit)? SEMI (expression)? SEMI (forUpdate)? R_PARENS statement
    ;

basicForStatementNoShortIf
    : FOR L_PARENS (forInit)? SEMI (expression)? SEMI (forUpdate)? R_PARENS statementNoShortIf
    ;

forInit
    : statementExpressionList
    | localVariableDeclaration
    ;

forUpdate
    : statementExpressionList
    ;

statementExpressionList
    : statementExpression (COMMA statementExpression)*
    ;

enhancedForStatement
    : FOR L_PARENS (variableModifier)* unannType variableDeclaratorId COLON expression R_PARENS statement
    ;

enhancedForStatementNoShortIf
    : FOR L_PARENS (variableModifier)* unannType variableDeclaratorId COLON expression R_PARENS statementNoShortIf
    ;

breakStatement
    : BREAK (Identifier)? SEMI
    ;

continueStatement
    : CONTINUE (Identifier)? SEMI
    ;

returnStatement
    : RETURN (expression)? SEMI
    ;

throwStatement
    : THROW expression SEMI
    ;

synchronizedStatement
    : SYNCHRONIZED L_PARENS expression R_PARENS block
    ;

tryStatement
    : TRY block catches
    | TRY block (catches)? finall
    | tryWithResourcesStatement
    ;

catches
    : catchClause (catchClause)*
    ;

catchClause
    : CATCH L_PARENS catchFormalParameter R_PARENS block
    ;

catchFormalParameter
    : (variableModifier)* catchType variableDeclaratorId
    ;

catchType
    : unannClassType (B_OR classType)*
    ;

finall
    : FINALLY block
    ;

tryWithResourcesStatement
    : TRY resourceSpecification block (catches)? (finall)?
    ;

resourceSpecification
    : L_PARENS resourceList (SEMI)? R_PARENS
    ;

resourceList
    : resource (SEMI resource)*
    ;

resource
    : (variableModifier)* unannType variableDeclaratorId ASSIGN expression
    ;

primary
    : primaryNoNewArray
    | arrayCreationExpression
    ;

primaryNoNewArray
    : literal
    | typeName (L_BRACKET R_BRACKET)* DOT CLASS
    | VOID DOT CLASS
    | THIS
    | typeName DOT THIS
    | L_PARENS expression R_PARENS
    | classInstanceCreationExpression
    | fieldAccess
    | arrayAccess
    | methodInvocation
    | methodReference
    ;

classInstanceCreationExpression
    : NEW (typeArguments)? (annotation)* Identifier (typeArgumentsOrDiamond)? L_PARENS (argumentList)? R_PARENS (classBody)?
    | expressionName DOT NEW (typeArguments)? (annotation)* Identifier (typeArgumentsOrDiamond)? L_PARENS (argumentList)? R_PARENS (classBody)?
    | primary DOT NEW (typeArguments)? (annotation)* Identifier (typeArgumentsOrDiamond)? L_PARENS (argumentList)? R_PARENS (classBody)?
    ;

typeArgumentsOrDiamond
    : typeArguments
    | DIAMOND
    ;

fieldAccess
    : primary DOT Identifier
    | SUPER DOT Identifier
    | typeName DOT SUPER DOT Identifier
    ;

arrayAccess
    : expressionName L_BRACKET expression R_BRACKET
    | primaryNoNewArray L_BRACKET expression R_BRACKET
    ;

methodInvocation
    : methodName L_PARENS (argumentList)? R_PARENS
    | typeName DOT (typeArguments)? Identifier L_PARENS (argumentList)? R_PARENS
    | expressionName DOT (typeArguments)? Identifier L_PARENS (argumentList)? R_PARENS
    | primary DOT (typeArguments)? Identifier L_PARENS (argumentList)? R_PARENS
    | SUPER DOT (typeArguments)? Identifier L_PARENS (argumentList)? R_PARENS
    | typeName DOT SUPER DOT (typeArguments)? Identifier L_PARENS (argumentList)? R_PARENS
    ;

argumentList
    : expression (COMMA expression)*
    ;

methodReference
    : expressionName METHOD_REF (typeArguments)? Identifier
    | referenceType METHOD_REF (typeArguments)? Identifier
    | primary METHOD_REF (typeArguments)? Identifier
    | SUPER METHOD_REF (typeArguments)? Identifier
    | typeName DOT SUPER METHOD_REF (typeArguments)? Identifier
    | classType METHOD_REF (typeArguments)? NEW
    | arrayType METHOD_REF NEW
    ;

arrayCreationExpression
    : NEW primitiveType dimExprs (dims)?
    | NEW classOrInterfaceType dimExprs (dims)?
    | NEW primitiveType dims arrayInitializer
    | NEW classOrInterfaceType dims arrayInitializer
    ;

dimExprs
    : dimExpr (dimExpr)*
    ;

dimExpr
    : (annotation)* L_BRACKET expression R_BRACKET
    ;

constantExpression
    : expression
    ;

expression
    : lambdaExpression
    | assignmentExpression
    ;

lambdaExpression
    : lambdaParameters ARROW lambdaBody
    ;

lambdaParameters
    : Identifier
    | L_PARENS (formalParameterList)? R_PARENS
    | L_PARENS inferredFormalParameterList R_PARENS
    ;

inferredFormalParameterList
    : Identifier (COMMA Identifier)*
    ;

lambdaBody
    : expression
    | block
    ;

assignmentExpression
    : conditionalExpression
    | assignment
    ;

assignment
    : leftHandSide assignmentOperator expression
    ;

leftHandSide
    : expressionName
    | fieldAccess
    | arrayAccess
    ;

assignmentOperator
    : ASSIGN
    | MULT_ASSIGN
    | DIV_ASSIGN
    | MOD_ASSIGN
    | PLUS_ASSIGN
    | MINUS_ASSIGN
    | L_SHIFT_ASSIGN
    | R_SHIFT_ASSIGN
    | UR_SHIFT_ASSIGN
    | AND_ASSIGN
    | XOR_ASSIGN
    | OR_ASSIGN
    ;

conditionalExpression
    : conditionalOrExpression
    | conditionalOrExpression QUES expression COLON conditionalExpression
    ;

conditionalOrExpression
    : conditionalAndExpression
    | conditionalOrExpression L_OR conditionalAndExpression
    ;

conditionalAndExpression
    : inclusiveOrExpression
    | conditionalAndExpression L_AND inclusiveOrExpression
    ;

inclusiveOrExpression
    : exclusiveOrExpression
    | inclusiveOrExpression B_OR exclusiveOrExpression
    ;

exclusiveOrExpression
    : andExpression
    | exclusiveOrExpression XOR andExpression
    ;

andExpression
    : equalityExpression
    | andExpression B_AND equalityExpression
    ;

equalityExpression
    : relationalExpression
    | equalityExpression EQ relationalExpression
    | equalityExpression NEQ relationalExpression
    ;

relationalExpression
    : shiftExpression
    | relationalExpression LT shiftExpression
    | relationalExpression GT shiftExpression
    | relationalExpression LE shiftExpression
    | relationalExpression GE shiftExpression
    | relationalExpression INSTANCEOF referenceType
    ;

shiftExpression
    : additiveExpression
    | shiftExpression L_SHIFT additiveExpression
    | shiftExpression GT GT additiveExpression
    | shiftExpression GT GT GT additiveExpression
    ;

additiveExpression
    : multiplicativeExpression
    | additiveExpression PLUS multiplicativeExpression
    | additiveExpression MINUS multiplicativeExpression
    ;

multiplicativeExpression
    : unaryExpression
    | multiplicativeExpression MULT unaryExpression
    | multiplicativeExpression DIV unaryExpression
    | multiplicativeExpression MOD unaryExpression
    ;

unaryExpression
    : preIncrementExpression
    | preDecrementExpression
    | PLUS unaryExpression
    | MINUS unaryExpression
    | unaryExpressionNotPlusMinus
    ;

preIncrementExpression
    : INCREMENT unaryExpression
    ;

preDecrementExpression
    : DECREMENT unaryExpression
    ;

unaryExpressionNotPlusMinus
    : postfixExpression
    | TILD unaryExpression
    | BANG unaryExpression
    | castExpression
    ;

postfixExpression
    : primary
    | expressionName
    | postfixExpression INCREMENT
    | postfixExpression DECREMENT
    ;

castExpression
    : L_PARENS primitiveType R_PARENS unaryExpression
    | L_PARENS referenceType (additionalBound)* R_PARENS unaryExpressionNotPlusMinus
    | L_PARENS referenceType (additionalBound)* R_PARENS lambdaExpression
    ;