/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.unrealscriptsupport.parser;

import java.io.Reader;
import java.io.StringReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ChangeListener;
import org.netbeans.modules.parsing.api.Snapshot;
import org.netbeans.modules.parsing.api.Task;
import org.netbeans.modules.parsing.spi.Parser;
import org.netbeans.modules.parsing.spi.SourceModificationEvent;

public class UnrealScriptParser extends Parser {

    private Snapshot snapshot;
    private org.unrealscriptsupport.jccparser.UnrealScriptParser unrealScriptParser;

    @Override
    public void parse (Snapshot snapshot, Task task, SourceModificationEvent event) {
        this.snapshot = snapshot;
        Reader reader = new StringReader (snapshot.getText ().toString ());
        unrealScriptParser = new org.unrealscriptsupport.jccparser.UnrealScriptParser (reader);
        try {
            unrealScriptParser.CompilationUnit ();
        } catch (org.unrealscriptsupport.jccparser.ParseException ex) {
            Logger.getLogger (UnrealScriptParser.class.getName()).log (Level.WARNING, null, ex);
        }
    }

    @Override
    public Result getResult (Task task) {
        return new UnrealScriptParserResult (snapshot, unrealScriptParser);
    }

    @Override
    public void cancel () {
    }

    @Override
    public void addChangeListener (ChangeListener changeListener) {
    }

    @Override
    public void removeChangeListener (ChangeListener changeListener) {
    }


    public static class UnrealScriptParserResult extends Result {

        private org.unrealscriptsupport.jccparser.UnrealScriptParser unrealScriptParser;
        private boolean valid = true;

        UnrealScriptParserResult (Snapshot snapshot, org.unrealscriptsupport.jccparser.UnrealScriptParser unrealScriptParser) {
            super (snapshot);
            this.unrealScriptParser = unrealScriptParser;
        }

        public org.unrealscriptsupport.jccparser.UnrealScriptParser getUnrealScriptParser () throws org.netbeans.modules.parsing.spi.ParseException {
            if (!valid) throw new org.netbeans.modules.parsing.spi.ParseException ();
            return unrealScriptParser;
        }

        @Override
        protected void invalidate () {
            valid = false;
        }
    }
}
