
package org.unrealscriptsupport.options.global;

/**
 * Class for storing tool collection preferences.
 * eg.
 * KillingFloor.name=Killing Floor
 * KillingFloor.compiler.args=make1
 * KillingFloor.compiler.basedir=base1
 * KillingFloor.compiler.filename=ucc1
 * KillingFloor.compiler.resultdir=system1
 * KillingFloor.executable.filename=kf.exe
 */
public class ToolCollectionData {

    public static final String UNKNOWN_STRING = "<unknown>";

    public static final String COMPILER_STRING = "compiler";
    public static final String EXECUTABLE_STRING = "executable";

    public static final String ARGS_STRING = "args";
    public static final String BASE_DIR_STRING = "basedir";
    public static final String FILE_NAME_STRING = "filename";
    public static final String RESULT_DIR_STRING = "resultdir";

    public String name = UNKNOWN_STRING;
    public String compilerArgs = UNKNOWN_STRING;
    public String compilerBaseDir = UNKNOWN_STRING;
    public String compilerFileName = UNKNOWN_STRING;
    public String compilerResultDir = UNKNOWN_STRING;
    public String executableFileName = UNKNOWN_STRING;

    public ToolCollectionData(String name) {
        this.name = name;
    }

    public ToolCollectionData(ToolCollectionData other) {
        set(other);
    }

    private void set(ToolCollectionData other) {
        this.name = other.name;
        this.compilerArgs = other.compilerArgs;
        this.compilerBaseDir = other.compilerBaseDir;
        this.compilerFileName = other.compilerFileName;
        this.compilerResultDir = other.compilerResultDir;
        this.executableFileName = other.executableFileName;
        return;
    }

    @Override
    public boolean equals(Object other) {

        if (other == null) {
            return false;
        }
        else if(other == this) {
            return true;
        }

        else if(other instanceof ToolCollectionData) {
            ToolCollectionData o = (ToolCollectionData) other;

            if ( (this.name == null) &&
                 (o.name == null) ) {
                return true;
            }
            else if(this.name.equals(o.name)) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(name);
        sb.append("\n");

        sb.append(COMPILER_STRING);
        sb.append(".");
        sb.append(ARGS_STRING);
        sb.append(" = ");
        sb.append(compilerArgs);
        sb.append("\n");

        sb.append(COMPILER_STRING);
        sb.append(".");
        sb.append(BASE_DIR_STRING);
        sb.append(" = ");
        sb.append(compilerBaseDir);
        sb.append("\n");

        sb.append(COMPILER_STRING);
        sb.append(".");
        sb.append(FILE_NAME_STRING);
        sb.append(" = ");
        sb.append(compilerFileName);
        sb.append("\n");

        sb.append(COMPILER_STRING);
        sb.append(".");
        sb.append(RESULT_DIR_STRING);
        sb.append(" = ");
        sb.append(compilerResultDir);
        sb.append("\n");

        sb.append(EXECUTABLE_STRING);
        sb.append(".");
        sb.append(FILE_NAME_STRING);
        sb.append(" = ");
        sb.append(executableFileName);
        sb.append("\n");

        return sb.toString();
    }
}

