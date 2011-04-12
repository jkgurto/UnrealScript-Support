/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.unrealscriptsupport.parser;

import java.util.ArrayList;
import java.util.List;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.StyledDocument;
import org.netbeans.modules.parsing.spi.Parser.Result;
import org.netbeans.modules.parsing.spi.ParserResultTask;
import org.netbeans.modules.parsing.spi.Scheduler;
import org.netbeans.modules.parsing.spi.SchedulerEvent;
import org.netbeans.spi.editor.hints.ErrorDescription;
import org.netbeans.spi.editor.hints.ErrorDescriptionFactory;
import org.netbeans.spi.editor.hints.HintsController;
import org.netbeans.spi.editor.hints.Severity;
import org.openide.text.NbDocument;
import org.openide.util.Exceptions;
import org.unrealscriptsupport.jccparser.ParseException;
import org.unrealscriptsupport.jccparser.Token;
import org.unrealscriptsupport.parser.UnrealScriptParser.UnrealScriptParserResult;

/**
 *
 * @author geertjan
 */
class SyntaxErrorsHighlightingTask extends ParserResultTask {

    public SyntaxErrorsHighlightingTask () {
    }

    @Override
    public void run (Result result, SchedulerEvent event) {
        try {
            UnrealScriptParserResult unrealScriptResult = (UnrealScriptParserResult) result;
            List<ParseException> syntaxErrors = unrealScriptResult.getJavaParser ().syntaxErrors;
            Document document = result.getSnapshot ().getSource ().getDocument (false);
            List<ErrorDescription> errors = new ArrayList<ErrorDescription> ();
            for (ParseException syntaxError : syntaxErrors) {
                Token token = syntaxError.currentToken;
                int start = NbDocument.findLineOffset ((StyledDocument) document, token.beginLine - 1) + token.beginColumn - 1;
                int end = NbDocument.findLineOffset ((StyledDocument) document, token.endLine - 1) + token.endColumn;
                ErrorDescription errorDescription = ErrorDescriptionFactory.createErrorDescription (
                    Severity.ERROR,
                    syntaxError.getMessage (),
                    document,
                    document.createPosition (start),
                    document.createPosition (end)
                );
                errors.add (errorDescription);
            }
            HintsController.setErrors (document, "simple-java", errors);
        } catch (BadLocationException ex1) {
            Exceptions.printStackTrace (ex1);
        } catch (org.netbeans.modules.parsing.spi.ParseException ex1) {
            Exceptions.printStackTrace (ex1);
        }
    }

    @Override
    public int getPriority () {
        return 100;
    }

    @Override
    public Class<? extends Scheduler> getSchedulerClass () {
        return Scheduler.EDITOR_SENSITIVE_TASK_SCHEDULER;
    }

    @Override
    public void cancel () {
    }
}
