package eu.modelwriter.core.alloyinecore.ui.editor.completion.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface ModelCompletionTokens {
  String _options = "options";
  String _symmetry_breaking = "symmetry_breaking";
  String _bit_width = "bit_width";
  String _skolem_depth = "skolem_depth";
  String _sharing = "sharing";
  List<String> _option = new ArrayList<>(Arrays.asList(ModelCompletionTokens._symmetry_breaking,
      ModelCompletionTokens._bit_width, ModelCompletionTokens._skolem_depth, ModelCompletionTokens._sharing));
  String _model = "model";
  String _import = "import";
  String _public = "public";
  String _protected = "protected";
  String _private = "private";
  List<String> _visibility = new ArrayList<>(Arrays.asList(ModelCompletionTokens._public,
      ModelCompletionTokens._protected, ModelCompletionTokens._private));
  String _package = "package";
  String _semicolon = ";";
  String _colon = ":";
  String _leftCurly = "{";
  String _rightCurly = "}";
  String _comma = ",";
  String _singleQuote = "''";
  String _doubleQuote = "\"\"";
  String _equals = "=";
  String _abstract = "abstract";
  String _interface = "interface";
  String _class = "class";
  String _datatype = "datatype";
  String _enum = "enum";
  String _primitive = "primitive";
  String _callable = "callable";
  String _invariant = "invariant";
  String _annotation = "annotation";
  String _leftArrow = "<";
  String _rightArrow = ">";
  String _extends = "extends";
  String _super = "super";
  String _static = "static";
  String _operation = "operation";
  String _ghost = "ghost";
  String _transient = "transient";
  String _volatile = "volatile";
  String _readonly = "readonly";
  String _attribute = "attribute";
  String _property = "property";
  String _serializable = "serializable";
  String _notSerializable = "!" + ModelCompletionTokens._serializable;
  String _literal = "literal";
  String _leftParenthesis = "(";
  String _rightParenthesis = ")";
  String _reference = "reference";
  String _derivation = "derivation";
  String _initial = "initial";
  String _precondition = "precondition";
  String _requires = "requires";
  String _postcondition = "postcondition";
  String _ensures = "ensures";
  String _body = "body";
  String _leftBracket = "[";
  String _rightBracket = "]";
  String _derived = "derived";
  String _id = "id";
  String _ordered = "ordered";
  String _notOrdered = "!" + ModelCompletionTokens._ordered;
  String _unique = "unique";
  String _notUnique = "!" + ModelCompletionTokens._unique;
  String _unsettable = "unsettable";
  String _notUnsettable = "!" + ModelCompletionTokens._unsettable;
  String _ellipsis = "..";
  String _asterisk = "*";
  String _plus = "+";
  String _question = "?";
  List<String> _stringBounds = new ArrayList<>(Arrays.asList(ModelCompletionTokens._asterisk,
      ModelCompletionTokens._plus, ModelCompletionTokens._question));
  String _nullFree = "|1";
  String _nullAble = "|?";
  List<String> _isnullable =
      new ArrayList<>(Arrays.asList(ModelCompletionTokens._nullFree, ModelCompletionTokens._nullAble));
  String _sharp = "#";
  String _composes = "composes";
  String _resolve = "resolve";
  String _notResolve = "!" + ModelCompletionTokens._resolve;
  String _key = "key";
  String _throws = "throws";
  String _boolean = "Boolean";
  String _integer = "Integer";
  String _string = "String";
  String _real = "Real";
  String _unlimitedNatural = "UnlimitedNatural";
  List<String> _primitives =
      new ArrayList<>(Arrays.asList(ModelCompletionTokens._boolean, ModelCompletionTokens._integer,
          ModelCompletionTokens._string, ModelCompletionTokens._real, ModelCompletionTokens._unlimitedNatural));
  String _ampersand = "&";
  String _dot = ".";
  String _doubleColon = "::";
  String _at = "@";
}
