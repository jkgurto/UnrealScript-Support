package org.unrealscriptsupport.lexer;

import org.netbeans.api.lexer.Language;
import org.netbeans.api.lexer.TokenId;

public class UnrealScriptTokenId implements TokenId {

    private final String name;
    private final String primaryCategory;
    private final int id;

    private static final Language<UnrealScriptTokenId> language = new UnrealScriptLanguageHierarchy().language();

    public static final Language<UnrealScriptTokenId> getLanguage() {
        return language;
    }

    UnrealScriptTokenId(
            String name,
            String primaryCategory,
            int id) {
        this.name = name;
        this.primaryCategory = primaryCategory;
        this.id = id;
    }

    @Override
    public String primaryCategory() {
        return primaryCategory;
    }

    @Override
    public int ordinal() {
        return id;
    }

    @Override
    public String name() {
        return name;
    }
}
