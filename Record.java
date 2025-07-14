package smartex;

/**
 * Abstract class Record
 * Contains welcomeMessage() and abstract finalizeRecord().
 */
public abstract class Record {
    public abstract void finalizeRecord();

    public void welcomeMessage() {
        System.out.println("--- Welcome to Smartex Student System ---");
    }
}

