/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.unrealscriptsupport.lexer;

import org.netbeans.spi.lexer.Lexer;
import org.netbeans.spi.lexer.LexerRestartInfo;
import org.unrealscriptsupport.jcclexer.JavaCharStream;
import org.unrealscriptsupport.jcclexer.UnrealScriptParserTokenManager;
import org.unrealscriptsupport.jcclexer.Token;

class UnrealScriptLexer implements Lexer<UnrealScriptTokenId> {

    private LexerRestartInfo<UnrealScriptTokenId> info;
    private UnrealScriptParserTokenManager unrealScriptParserTokenManager;


    UnrealScriptLexer (LexerRestartInfo<UnrealScriptTokenId> info) {
        this.info = info;
        JavaCharStream stream = new JavaCharStream (info.input ());
        unrealScriptParserTokenManager = new UnrealScriptParserTokenManager (stream);
    }

    @Override
    public org.netbeans.api.lexer.Token<UnrealScriptTokenId> nextToken () {
        Token token = unrealScriptParserTokenManager.getNextToken ();
        if (info.input ().readLength () < 1) return null;
        return info.tokenFactory ().createToken (UnrealScriptLanguageHierarchy.getToken (token.kind));
    }

    @Override
    public Object state () {
        return null;
    }

    @Override
    public void release () {
    }
}
