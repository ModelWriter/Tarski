package eu.modelwriter.core.alloyinecore.ui.editor.completion.expression;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface ExpressionCompletionTokens {
  String _transpose = "~";
  String _closure = "^";
  String _reflexive = "*";
  String _union = "+";
  String _intersection = "&";
  String _difference = "-";
  String _join = ".";
  String _leftBracket = "[";
  String _rightBracket = "]";
  String _product = "->";
  String _override = "++";
  String _comprehension = "|";
  List<String> _if = new ArrayList<>(Arrays.asList("if", "=>"));
  String _then = "then";
  String _else = "else";
  String _iden = "iden";
  String _none = "none";
  String _univ = "univ";
  String _ints = "ints";
  String _leftParenthesis = "(";
  String _rightParenthesis = ")";
  String _sum = "sum";
  String _count = "#";
  List<String> _plus = new ArrayList<>(Arrays.asList("plus", "+"));
  List<String> _minus = new ArrayList<>(Arrays.asList("minus", "-"));
  List<String> _multiply = new ArrayList<>(Arrays.asList("mul", "*"));
  List<String> _divide = new ArrayList<>(Arrays.asList("div", "/"));
  List<String> _modulo = new ArrayList<>(Arrays.asList("modulo", "%"));
  String _negative = "-";
  String _comma = ",";
  String _disj = "disj";
  String _colon = ":";
  String _one = "one";
  String _lone = "lone";
  String _some = "some";
  String _set = "set";
  List<String> _mult = new ArrayList<>(
      Arrays.asList(ExpressionCompletionTokens._set, ExpressionCompletionTokens._one,
          ExpressionCompletionTokens._lone, ExpressionCompletionTokens._some));
  String _equals = "=";
}
