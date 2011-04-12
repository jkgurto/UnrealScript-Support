/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.unrealscriptsupport.lexer;

import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;
import org.unrealscriptsupport.jcclexer.JavaCharStream;
import org.unrealscriptsupport.jcclexer.JavaParserTokenManager;
import org.unrealscriptsupport.jcclexer.Token;

class UnrealScriptLexer implements Lexer<UnrealScriptTokenId> {

    private LexerRestartInfo<UnrealScriptTokenId> info;
    private JavaParserTokenManager javaParserTokenManager;


    UnrealScriptLexer (LexerRestartInfo<UnrealScriptTokenId> info) {
        this.info = info;
        JavaCharStream stream = new JavaCharStream (info.input ());
        javaParserTokenManager = new JavaParserTokenManager (stream);
    }

    public org.netbeans.api.lexer.Token<UnrealScriptTokenId> nextToken () {
        Token token = javaParserTokenManager.getNextToken ();
        if (info.input ().readLength () < 1) return null;
        return info.tokenFactory ().createToken (UnrealScriptLanguageHierarchy.getToken (token.kind));
    }

    public Object state () {
        return null;
    }

    public void release () {
    }
}
