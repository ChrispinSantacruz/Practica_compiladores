import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class CalculadoraMain {
    public static void main(String[] args) throws Exception {
        // Leer la entrada desde el archivo o desde la línea de comandos
        CharStream input = CharStreams.fromStream(System.in);
        
        // Crear un lexer y un buffer de tokens
        CalculadoraLexer lexer = new CalculadoraLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        
        // Crear el parser
        CalculadoraParser parser = new CalculadoraParser(tokens);
        
        // Iniciar el análisis con la regla de inicio (prog)
        ParseTree tree = parser.prog();
        
        // Imprimir el árbol de análisis sintáctico
        System.out.println(tree.toStringTree(parser));  // Visualiza el árbol de análisis
    }
}
