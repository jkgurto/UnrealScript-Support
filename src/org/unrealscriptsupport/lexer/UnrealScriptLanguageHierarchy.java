/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unrealscriptsupport.lexer;

/**
 *
 * @author geertjan
 */

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.netbeans.spi.lexer.LanguageHierarchy;
import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;

/**
*
* @author eppleton
*/
public class UnrealScriptLanguageHierarchy extends LanguageHierarchy<UnrealScriptTokenId> {

   private static List<UnrealScriptTokenId> tokens;
   private static Map<Integer, UnrealScriptTokenId> idToToken;

   private static void init() {
       tokens = Arrays.<UnrealScriptTokenId>asList(new UnrealScriptTokenId[]{
                   new UnrealScriptTokenId("EOF", "whitespace", 0),
                   new UnrealScriptTokenId("WHITESPACE", "whitespace", 1),
                   new UnrealScriptTokenId("SINGLE_LINE_COMMENT", "comment", 4),
                   new UnrealScriptTokenId("FORMAL_COMMENT", "comment", 5),
                   new UnrealScriptTokenId("MULTI_LINE_COMMENT", "comment", 6),
                   new UnrealScriptTokenId("ABSTRACT", "keyword", 8),
                   new UnrealScriptTokenId("ASSERT", "keyword", 9),
                   new UnrealScriptTokenId("BOOLEAN", "keyword", 10),
                   new UnrealScriptTokenId("BREAK", "keyword", 11),
                   new UnrealScriptTokenId("BYTE", "keyword", 12),
                   new UnrealScriptTokenId("CASE", "keyword", 13),
                   new UnrealScriptTokenId("CATCH", "keyword", 14),
                   new UnrealScriptTokenId("CHAR", "keyword", 15),
                   new UnrealScriptTokenId("CLASS", "keyword", 16),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("CONST", "keyword", 17),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("CONTINUE", "keyword", 18),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("_DEFAULT", "keyword", 19),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("DO", "keyword", 20),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("DOUBLE", "keyword", 21),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("ELSE", "keyword", 22),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("ENUM", "keyword", 23),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("EXTENDS", "keyword", 24),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("FALSE", "keyword", 25),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("FINAL", "keyword", 26),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("FINALLY", "keyword", 27),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("FLOAT", "keyword", 28),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("FOR", "keyword", 29),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("GOTO", "keyword", 30),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("IF", "keyword", 31),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("IMPLEMENTS", "keyword", 32),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("IMPORT", "keyword", 33),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("INSTANCEOF", "keyword", 34),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("INT", "keyword", 35),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("INTERFACE", "keyword", 36),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("LONG", "keyword", 37),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("NATIVE", "keyword", 38),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("NEW", "keyword", 39),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("NULL", "keyword", 40),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("PACKAGE", "keyword", 41),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("PRIVATE", "keyword", 42),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("PROTECTED", "keyword", 43),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("PUBLIC", "keyword", 44),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("RETURN", "keyword", 45),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("SHORT", "keyword", 46),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("STATIC", "keyword", 47),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("STRICTFP", "keyword", 48),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("SUPER", "keyword", 49),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("SWITCH", "keyword", 50),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("SYNCHRONIZED", "keyword", 51),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("THIS", "keyword", 52),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("THROW", "keyword", 53),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("THROWS", "keyword", 54),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("TRANSIENT", "keyword", 55),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("TRUE", "keyword", 56),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("TRY", "keyword", 57),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("VOID", "keyword", 58),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("VOLATILE", "keyword", 59),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("WHILE", "keyword", 60),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("INTEGER_LITERAL", "literal", 61),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("DECIMAL_LITERAL", "literal", 62),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("HEX_LITERAL", "literal", 63),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("OCTAL_LITERAL", "literal", 64),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("FLOATING_POINT_LITERAL", "literal", 65),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("DECIMAL_FLOATING_POINT_LITERAL", "literal", 66),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("DECIMAL_EXPONENT", "number", 67),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("HEXADECIMAL_FLOATING_POINT_LITERAL", "literal", 68),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("HEXADECIMAL_EXPONENT", "number", 69),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("CHARACTER_LITERAL", "literal", 70),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("STRING_LITERAL", "literal", 71),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("IDENTIFIER", "identifier", 72),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("LETTER", "literal", 73),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("PART_LETTER", "literal", 74),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("LPAREN", "operator", 75),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("RPAREN", "operator", 76),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("LBRACE", "operator", 77),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("RBRACE", "operator", 78),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("LBRACKET", "operator", 79),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("RBRACKET", "operator", 80),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("SEMICOLON", "operator", 81),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("COMMA", "operator", 82),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("DOT", "operator", 83),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("AT", "operator", 84),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("ASSIGN", "operator", 85),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("LT", "operator", 86),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("BANG", "operator", 87),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("TILDE", "operator", 88),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("HOOK", "operator", 89),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("COLON", "operator", 90),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("EQ", "operator", 91),
                   /** RegularExpression operator. */
                   new UnrealScriptTokenId("LE", "operator", 92),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("GE", "operator", 93),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("NE", "operator", 94),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("SC_OR", "operator", 95),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("SC_AND", "operator", 96),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("INCR", "operator", 97),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("DECR", "operator", 98),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("PLUS", "operator", 99),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("MINUS", "operator", 100),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("STAR", "operator", 101),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("SLASH", "operator", 102),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("BIT_AND", "operator", 103),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("BIT_OR", "operator", 104),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("XOR", "operator", 105),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("REM", "operator", 106),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("LSHIFT", "operator", 107),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("PLUSASSIGN", "operator", 108),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("MINUSASSIGN", "operator", 109),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("STARASSIGN", "operator", 110),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("SLASHASSIGN", "operator", 111),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("ANDASSIGN", "operator", 112),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("ORASSIGN", "operator", 113),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("XORASSIGN", "operator", 114),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("REMASSIGN", "operator", 115),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("LSHIFTASSIGN", "operator", 116),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("RSIGNEDSHIFTASSIGN", "operator", 117),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("RUNSIGNEDSHIFTASSIGN", "operator", 118),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("ELLIPSIS", "operator", 119),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("RUNSIGNEDSHIFT", "operator", 120),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("RSIGNEDSHIFT", "operator", 121),
                   /** RegularExpression Id. */
                   new UnrealScriptTokenId("GT", "operator", 122),
                     /** Lexical state. */

               });
       idToToken = new HashMap<Integer, UnrealScriptTokenId>();
       for (UnrealScriptTokenId token : tokens) {
           idToToken.put(token.ordinal(), token);
       }
   }

   static synchronized UnrealScriptTokenId getToken(int id) {
       if (idToToken == null) {
           init();
       }
       return idToToken.get(id);
   }

   protected synchronized Collection<UnrealScriptTokenId> createTokenIds() {
       if (tokens == null) {
           init();
       }
       return tokens;
   }

   protected synchronized Lexer<UnrealScriptTokenId> createLexer(LexerRestartInfo<UnrealScriptTokenId> info) {
       return new UnrealScriptLexer(info);
   }

   protected String mimeType() {
       return "text/x-uc";
   }
}
