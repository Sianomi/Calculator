package javascript_test;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import java.lang.Math;

public class Test {
  public static void main(String[] args) throws Exception{
    ScriptEngineManager mgr = new ScriptEngineManager();
    ScriptEngine engine = mgr.getEngineByName("JavaScript");
    String foo = "(55+31)*523*(513+32)";
    System.out.println(engine.eval(foo));
    }
}