package eu.modelwriter.core.alloyinecore.ui.editor.completion.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface CompletionTokens {
  String _options = "options";
  String _symmetry_breaking = "symmetry_breaking";
  String _bit_width = "bit_width";
  String _skolem_depth = "skolem_depth";
  String _sharing = "sharing";
  List<String> _option = new ArrayList<>(Arrays.asList(CompletionTokens._symmetry_breaking,
      CompletionTokens._bit_width, CompletionTokens._skolem_depth, CompletionTokens._sharing));
  String _model = "model";
  String _import = "import";
  String _public = "public";
  String _protected = "protected";
  String _private = "private";
  List<String> _visibility = new ArrayList<>(Arrays.asList(CompletionTokens._public,
      CompletionTokens._protected, CompletionTokens._private));
  String _package = "package";
  String _semicolon = ";";
  String _colon = ":";
  String _openCurly = "{";
  String _closeCurly = "}";
  String _comma = ",";
  String _singleQuote = "''";
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
}
