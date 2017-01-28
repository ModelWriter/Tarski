package eu.modelwriter.core.svgutil.main;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.batik.anim.dom.SAXSVGDocumentFactory;
import org.apache.batik.transcoder.TranscoderException;
import org.apache.batik.transcoder.TranscoderInput;
import org.apache.batik.transcoder.TranscoderOutput;
import org.apache.batik.transcoder.svg2svg.SVGTranscoder;
import org.apache.batik.util.XMLResourceDescriptor;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

public class Main {
  private static String folderPath;
  private static String width;
  private static String height;
  private static String padding;
  private static String color;

  public static void main(String[] args) {
    setupArgs(args);
    try (Stream<Path> paths = Files.walk(Paths.get(folderPath))) {
      paths.forEach(path -> {
        File file = path.toFile();
        if (file.isFile() && file.getName().endsWith(".svg")) {
          try {
            System.out.println("Editing: " + file.getName());
            editSVG(file.getAbsolutePath(), width, height, padding, color);
            System.out.println("Done");
          } catch (IOException e) {
            System.out.println("Failed");
          }
        }
      });
    } catch (IOException e) {
      System.out.println("IO Exception, check folder path");
    }
  }

  private static void setupArgs(String[] args) {
    if (args.length > 0)
      folderPath = args[0];
    else
      folderPath = "../eu.modelwriter.core.alloyinecore.ui/icons/full/exp16";
    if (args.length >= 5) {
      width = args[1];
      height = args[2];
      padding = args[3];
      color = "#" + args[4];
    } else {
      width = "16";
      height = "16";
      padding = "0";
      color = "#000000";
    }
    System.out.println("SVG Editor:");
    System.out.println("With: " + width);
    System.out.println("Height: " + height);
    System.out.println("Padding: " + padding);
    System.out.println("Color: " + color);
    System.out.println("---------------------");
  }

  private static void editSVG(String filePath, String width, String height, String padding,
      String color) throws IOException {
    try {
      Document document = loadDocument(filePath);
      Element svgElement = (Element) document.getElementsByTagName("svg").item(0);
      svgElement.setAttribute("width", width);
      svgElement.setAttribute("height", height);
      String style = svgElement.getAttribute("style");
      // Set color
      String fillStyle = "fill:" + color;
      if (!style.contains("fill")) {
        style +=
            style.isEmpty() ? fillStyle : (style.endsWith(";") ? fillStyle : (";" + fillStyle));
      } else {
        style = style.replaceAll("fill:\\s*#(......|...)", fillStyle);
      }
      // Set padding
      String paddingStyle = "padding: " + padding + "px";
      if (!style.contains("padding")) {
        style += style.isEmpty() ? paddingStyle
            : (style.endsWith(";") ? paddingStyle : (";" + paddingStyle));
      } else {
        style = style.replaceAll("padding:\\s*\\d*px", paddingStyle);
      }
      svgElement.setAttribute("style", style);
      saveDocument(document, filePath);
    } catch (ParserConfigurationException | SAXException e) {
      e.printStackTrace();
    }
  }

  public static void editSVG(String filePath, int width, int height, int padding, String hexColor)
      throws IOException {
    editSVG(filePath, String.valueOf(width), String.valueOf(height), String.valueOf(padding),
        hexColor);
  }

  public static Document loadDocument(String path)
      throws IOException, ParserConfigurationException, SAXException {
    File file = new File(path);
    FileInputStream svgInputStream = new FileInputStream(file);
    String parser = XMLResourceDescriptor.getXMLParserClassName();
    SAXSVGDocumentFactory factory = new SAXSVGDocumentFactory(parser);
    Document doc = factory.createDocument(parser, svgInputStream);
    return doc;
  }

  public static void saveDocument(Document doc, String savePath) throws IOException {
    byte[] fileData = transcodeToSVG(doc);
    FileOutputStream fileSave = new FileOutputStream(savePath);
    fileSave.write(fileData);
    fileSave.flush();
    fileSave.close();
  }

  public static byte[] transcodeToSVG(Document doc) {
    try {
      // Determine output type:
      SVGTranscoder t = new SVGTranscoder();

      // Set transcoder input/output
      TranscoderInput input = new TranscoderInput(doc);
      ByteArrayOutputStream bytestream = new ByteArrayOutputStream();
      OutputStreamWriter ostream = new OutputStreamWriter(bytestream);
      TranscoderOutput output = new TranscoderOutput(ostream);

      // Perform transcoding
      t.transcode(input, output);
      ostream.flush();
      ostream.close();

      return bytestream.toByteArray();

    } catch (IOException | TranscoderException e) {
      e.printStackTrace();
    }
    return null;
  }
}
