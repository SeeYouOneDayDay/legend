package libcore.io;

public class Libcore {
    private Libcore() { }

    /**
     * Direct access to syscalls. Code should strongly prefer using {@link #os}
     * unless it has a strong reason to bypass the helpful checks/guards that it
     * provides.
     */
    public static Os rawOs = new Linux();

    /**
     * Access to syscalls with helpful checks/guards.
     */
    public static Os os = new BlockGuardOs(rawOs);
}
