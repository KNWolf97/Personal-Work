// GROUP SUBMISSION: Kyle Wolf & Dominique Nicholas
public class Parser
{
    public static final int OP         = 10;
    public static final int RELOP      = 11;
    public static final int ASSIGN     = 12;
    public static final int BEGIN      = 13;
    public static final int END        = 14;
    public static final int LPAREN     = 15;
    public static final int RPAREN     = 16;
    public static final int SEMI       = 17;
    public static final int COMMA      = 18;
    public static final int NUM        = 19;
    public static final int ID         = 20;
    public static final int MAIN       = 21;
    public static final int PRINT      = 22;
    public static final int IF         = 23;
    public static final int ELSE       = 24;
    Compiler         compiler;
    Lexer            lexer;     // lexer.yylex() returns token-name
    public ParserVal yylval;    // yylval contains token-attribute

    public Parser(java.io.Reader r, Compiler compiler) throws java.io.IOException
    {
        this.compiler = compiler;
        this.lexer    = new Lexer(r, this);
    }

    public int yyparse() throws java.io.IOException
    {
        while ( true )
        {
            // default to semicolon here
            int token = lexer.yylex();  // get next token-name
            Object attr = yylval.obj;   // get      token-attribute
            String tokenname = "";

            if(token == 0)
            {
                // EOF is reached
                System.out.println("successful in tokenizing the input.");
                return 0;
            }
            if(token == -1)
            {
                // error
                System.out.println("tokenizing error at line " + lexer.lineno + ".");
                return -1;
            }

            if(token == 10){
                tokenname = "OP";
            }
            if(token == 11){
                tokenname = "RELOP";
            }
            if(token == 12){
                tokenname = "ASSIGN";
            }
            if(token == 13){
                tokenname = "BEGIN";
            }
            if(token == 14){
                tokenname = "END";
            }
            if(token == 15){
                tokenname = "LPAREN";
            }
            if(token == 16){
                tokenname = "RPAREN";
            }
            if(token == 17){
                tokenname = "SEMI";
            }
            if(token == 18){
                tokenname = "COMMA";
            }
            if(token == 19){
                tokenname = "NUM";
            }
            if(token == 20){
                tokenname = "ID";
            }
            if(token == 21){
                tokenname = "MAIN";
            }
            if(token == 22){
                tokenname = "PRINT";
            }
            if(token == 23){
                tokenname = "IF";
            }
            if(token == 24){
                tokenname = "ELSE";
            }

            System.out.println("<token-name:" + tokenname + ", token-attr:\"" + attr + "\", lineno:" + lexer.lineno + ">");
        }
    }
}
