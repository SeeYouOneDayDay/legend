/*
 * Copyright (C) 2011 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package libcore.io;

import android.system.ErrnoException;
import android.system.Int64Ref;
import android.system.StructPollfd;
import android.system.StructStat;
import android.system.StructStatVfs;
import android.system.StructTimeval;
import android.system.StructUtsname;

import java.io.FileDescriptor;
import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;
import java.util.Objects;

/**
 * Subclass this if you want to override some {@link Os} methods but otherwise delegate.
 *
 *
 */
public class ForwardingOs implements Os {

    private final Os os;

    /**
     * Constructs new {@link ForwardingOs}.
     *
     * @param os {@link Os} delegate for not overridden methods
     *
     *
     */
    protected ForwardingOs(Os os) {
        this.os = Objects.requireNonNull(os);
    }

    /**
     * @return the delegate object passed to the constructor.
     *
     *
     */
    protected final Os delegate() {
        return os;
    }

    /**
     *
     *
     */
    public FileDescriptor accept(FileDescriptor fd, SocketAddress peerAddress) throws ErrnoException, SocketException {
        return os.accept(fd, peerAddress);
    }




    /**
     *
     */
    public boolean access(String path, int mode) throws ErrnoException {
        return os.access(path, mode);
    }


    /**
     *
     */
    public void bind(FileDescriptor fd, InetAddress address, int port) throws ErrnoException, SocketException {
        os.bind(fd, address, port);
    }

    /**
     *
     */
    public void bind(FileDescriptor fd, SocketAddress address) throws ErrnoException, SocketException {
        os.bind(fd, address);
    }



    public void chmod(String path, int mode) throws ErrnoException {
        os.chmod(path, mode);
    }

    /**
     *
     */

    public void chown(String path, int uid, int gid) throws ErrnoException {
        os.chown(path, uid, gid);
    }

    /**
     *
     */
    public void close(FileDescriptor fd) throws ErrnoException {
        os.close(fd);
    }

    /**
     *
     */
    public void android_fdsan_exchange_owner_tag(FileDescriptor fd, long previousOwnerId, long newOwnerId) {

    }

    /**
     *
     */
    public long android_fdsan_get_owner_tag(FileDescriptor fd) {
        throw new RuntimeException("Stub!");
    }

    /**
     *
     */
    public String android_fdsan_get_tag_type(long tag) {
        throw new RuntimeException("Stub!");
    }

    /**
     *
     */
    public long android_fdsan_get_tag_value(long tag) {
        throw new RuntimeException("Stub!");
    }

    /**
     *
     */
    public void connect(FileDescriptor fd, InetAddress address, int port) throws ErrnoException, SocketException {
        os.connect(fd, address, port);
    }

    /**
     *
     */
    public void connect(FileDescriptor fd, SocketAddress address) throws ErrnoException, SocketException {
        os.connect(fd, address);
    }

    /**
     *
     */
    public FileDescriptor dup(FileDescriptor oldFd) throws ErrnoException {
        return os.dup(oldFd);
    }

    /**
     *
     */
    public FileDescriptor dup2(FileDescriptor oldFd, int newFd) throws ErrnoException {
        return os.dup2(oldFd, newFd);
    }

    /**
     *
     */
    public String[] environ() {
        return os.environ();
    }

    /**
     *
     */
    public void execv(String filename, String[] argv) throws ErrnoException {
        os.execv(filename, argv);
    }

    /**
     *
     */
    public void execve(String filename, String[] argv, String[] envp) throws ErrnoException {
        os.execve(filename, argv, envp);
    }

    /**
     *
     */
    public void fchmod(FileDescriptor fd, int mode) throws ErrnoException {
        os.fchmod(fd, mode);
    }

    /**
     *
     */
    public void fchown(FileDescriptor fd, int uid, int gid) throws ErrnoException {
        os.fchown(fd, uid, gid);
    }

    /**
     *
     */
    public int fcntlInt(FileDescriptor fd, int cmd, int arg) throws ErrnoException {
        return os.fcntlInt(fd, cmd, arg);
    }

    /**
     *
     */
    public int fcntlVoid(FileDescriptor fd, int cmd) throws ErrnoException {
        return os.fcntlVoid(fd, cmd);
    }

    /**
     *
     */
    public void fdatasync(FileDescriptor fd) throws ErrnoException {
        os.fdatasync(fd);
    }

    /**
     *
     */
    public StructStat fstat(FileDescriptor fd) throws ErrnoException {
        return os.fstat(fd);
    }

    /**
     *
     */
    public StructStatVfs fstatvfs(FileDescriptor fd) throws ErrnoException {
        return os.fstatvfs(fd);
    }

    /**
     *
     */
    public void fsync(FileDescriptor fd) throws ErrnoException {
        os.fsync(fd);
    }

    /**
     *
     */
    public void ftruncate(FileDescriptor fd, long length) throws ErrnoException {
        os.ftruncate(fd, length);
    }

    /**
     *
     */
    public String gai_strerror(int error) {
        return os.gai_strerror(error);
    }

    /**
     *
     */
    public int getegid() {
        return os.getegid();
    }

    /**
     *
     */
    public int geteuid() {
        return os.geteuid();
    }

    /**
     *
     */
    public int getgid() {
        return os.getgid();
    }

    /**
     *
     */

    public String getenv(String name) {
        return os.getenv(name);
    }

    /**
     *
     */
    public String getnameinfo(InetAddress address, int flags) throws Exception {
        throw new RuntimeException("Stub!");
    }

    /**
     *
     */
    public SocketAddress getpeername(FileDescriptor fd) throws ErrnoException {
        return os.getpeername(fd);
    }

    /**
     *
     */
    public int getpgid(int pid) throws ErrnoException {
        return os.getpgid(pid);
    }

    /**
     *
     */
    public int getpid() {
        return os.getpid();
    }

    /**
     *
     */
    public int getppid() {
        return os.getppid();
    }



    /**
     *
     */
    public SocketAddress getsockname(FileDescriptor fd) throws ErrnoException {
        return os.getsockname(fd);
    }

    /**
     *
     */
    public int getsockoptByte(FileDescriptor fd, int level, int option) throws ErrnoException {
        return os.getsockoptByte(fd, level, option);
    }

    /**
     *
     */
    public InetAddress getsockoptInAddr(FileDescriptor fd, int level, int option) throws ErrnoException {
        return os.getsockoptInAddr(fd, level, option);
    }

    /**
     *
     */
    public int getsockoptInt(FileDescriptor fd, int level, int option) throws ErrnoException {
        return os.getsockoptInt(fd, level, option);
    }



    /**
     *
     */
    public StructTimeval getsockoptTimeval(FileDescriptor fd, int level, int option) throws ErrnoException {
        return os.getsockoptTimeval(fd, level, option);
    }



    /**
     *
     */
    public int gettid() {
        return os.gettid();
    }

    /**
     *
     */
    public int getuid() {
        return os.getuid();
    }

    /**
     *
     */
    public byte[] getxattr(String path, String name) throws ErrnoException {
        return os.getxattr(path, name);
    }


    /**
     *
     */
    public String if_indextoname(int index) {
        return os.if_indextoname(index);
    }

    /**
     *
     */
    public int if_nametoindex(String name) {
        return os.if_nametoindex(name);
    }

    /**
     *
     */
    public InetAddress inet_pton(int family, String address) {
        return os.inet_pton(family, address);
    }

    /**
     *
     */
    public int ioctlFlags(FileDescriptor fd, String interfaceName) throws ErrnoException {
        return os.ioctlFlags(fd, interfaceName);
    }

    /**
     *
     */
    public InetAddress ioctlInetAddress(FileDescriptor fd, int cmd, String interfaceName) throws ErrnoException {
        return os.ioctlInetAddress(fd, cmd, interfaceName);
    }

    /**
     *
     */
    public int ioctlInt(FileDescriptor fd, int cmd) throws ErrnoException {
        throw new RuntimeException("Stub!");
    }

    /**
     *
     */
    public int ioctlMTU(FileDescriptor fd, String interfaceName) throws ErrnoException {
        return os.ioctlMTU(fd, interfaceName);
    }

    /**
     *
     */
    public boolean isatty(FileDescriptor fd) {
        return os.isatty(fd);
    }

    /**
     *
     */
    public void kill(int pid, int signal) throws ErrnoException {
        os.kill(pid, signal);
    }

    /**
     *
     */

    public void lchown(String path, int uid, int gid) throws ErrnoException {
        os.lchown(path, uid, gid);
    }

    /**
     *
     */

    public void link(String oldPath, String newPath) throws ErrnoException {
        os.link(oldPath, newPath);
    }

    /**
     *
     */
    public void listen(FileDescriptor fd, int backlog) throws ErrnoException {
        os.listen(fd, backlog);
    }

    /**
     *
     */
    public String[] listxattr(String path) throws ErrnoException {
        return os.listxattr(path);
    }

    /**
     *
     */
    public long lseek(FileDescriptor fd, long offset, int whence) throws ErrnoException {
        return os.lseek(fd, offset, whence);
    }

    /**
     *
     */

    public StructStat lstat(String path) throws ErrnoException {
        return os.lstat(path);
    }

    /**
     *
     */
    public FileDescriptor memfd_create(String name, int flags) throws ErrnoException {
        throw new RuntimeException("Stub!");
    }

    /**
     *
     */
    public void mincore(long address, long byteCount, byte[] vector) throws ErrnoException {
        os.mincore(address, byteCount, vector);
    }

    /**
     *
     */

    public void mkdir(String path, int mode) throws ErrnoException {
        os.mkdir(path, mode);
    }

    /**
     *
     */

    public void mkfifo(String path, int mode) throws ErrnoException {
        os.mkfifo(path, mode);
    }

    /**
     *
     */
    public void mlock(long address, long byteCount) throws ErrnoException {
        os.mlock(address, byteCount);
    }

    /**
     *
     */
    public long mmap(long address, long byteCount, int prot, int flags, FileDescriptor fd, long offset) throws ErrnoException {
        return os.mmap(address, byteCount, prot, flags, fd, offset);
    }

    /**
     *
     */
    public void msync(long address, long byteCount, int flags) throws ErrnoException {
        os.msync(address, byteCount, flags);
    }

    /**
     *
     */
    public void munlock(long address, long byteCount) throws ErrnoException {
        os.munlock(address, byteCount);
    }

    /**
     *
     */
    public void munmap(long address, long byteCount) throws ErrnoException {
        os.munmap(address, byteCount);
    }

    /**
     * Opens the file specified by {@code path}.
     *
     * If the specified file does not exist, it may optionally (if
     * {@link android.system.OsConstants#O_CREAT} is specified in flags)
     * be created by {@link #open(String, int, int)}.
     *
     * The argument flags must include one of the following access
     * modes: {@link android.system.OsConstants#O_RDONLY},
     * {@link android.system.OsConstants#O_WRONLY}, or
     * {@link android.system.OsConstants#O_RDWR}. These request opening the
     * file read-only, write-only, or read/write, respectively.
     *
     * In addition, zero or more file creation flags and file status
     * flags can be bitwise-or'd in flags. The file creation flags are
     * {@link android.system.OsConstants#O_CLOEXEC}, {@link android.system.OsConstants#O_CREAT},
     * {@link android.system.OsConstants# O_DIRECTORY}, {@link android.system.OsConstants#O_EXCL},
     * {@link android.system.OsConstants#O_NOCTTY}, {@link android.system.OsConstants#O_NOFOLLOW},
     * {@link android.system.OsConstants# O_TMPFILE}, and {@link android.system.OsConstants#O_TRUNC}.
     *
     * @see <a href="https://man7.org/linux/man-pages/man2/open.2.html">open(2)</a>.
     *
     * @param path  path of the file to be opened
     * @param flags bitmask of the access, file creation and file status flags
     * @param mode  specifies the file mode bits to be applied when a new file is
     *              created. If neither {@link android.system.OsConstants#O_CREAT}
     *              nor {@link android.system.OsConstants# O_TMPFILE} is specified in
     *              flags, then mode is ignored (and can thus be specified as 0, or simply omitted).
     * @return {@link FileDescriptor} of an opened file
     * @throws ErrnoException if requested access to the file is not allowed, or search
     *                        permission is denied for one of the directories in the
     *                        path prefix of {@code path}, or the file did not exist yet and
     *                        write access to the parent directory is not allowed, or other error.
     *                        See the full list of errors in the "See Also" list.
     *
     *
     */
    public FileDescriptor open(String path, int flags, int mode) throws ErrnoException {
        return os.open(path, flags, mode);
    }

    /**
     *
     */
    public FileDescriptor[] pipe2(int flags) throws ErrnoException {
        return os.pipe2(flags);
    }

    /**
     *
     */
    public int poll(StructPollfd[] fds, int timeoutMs) throws ErrnoException {
        return os.poll(fds, timeoutMs);
    }

    /**
     *
     */
    public void posix_fallocate(FileDescriptor fd, long offset, long length) throws ErrnoException {
        os.posix_fallocate(fd, offset, length);
    }

    /**
     *
     */
    public int prctl(int option, long arg2, long arg3, long arg4, long arg5) throws ErrnoException {
        return os.prctl(option, arg2, arg3, arg4, arg5);
    }

    /**
     *
     */
    public int pread(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException, InterruptedIOException {
        return os.pread(fd, buffer, offset);
    }

    /**
     *
     */
    public int pread(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException, InterruptedIOException {
        return os.pread(fd, bytes, byteOffset, byteCount, offset);
    }

    /**
     *
     */
    public int pwrite(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException, InterruptedIOException {
        return os.pwrite(fd, buffer, offset);
    }

    /**
     *
     */
    public int pwrite(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException, InterruptedIOException {
        return os.pwrite(fd, bytes, byteOffset, byteCount, offset);
    }

    /**
     *
     */
    public int read(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException, InterruptedIOException {
        return os.read(fd, buffer);
    }

    /**
     *
     */
    public int read(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException, InterruptedIOException {
        return os.read(fd, bytes, byteOffset, byteCount);
    }

    /**
     *
     */

    public String readlink(String path) throws ErrnoException {
        return os.readlink(path);
    }

    /**
     *
     */
    public String realpath(String path) throws ErrnoException {
        return os.realpath(path);
    }

    /**
     *
     */
    public int readv(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException, InterruptedIOException {
        return os.readv(fd, buffers, offsets, byteCounts);
    }

    /**
     *
     */
    public int recvfrom(FileDescriptor fd, ByteBuffer buffer, int flags, InetSocketAddress srcAddress) throws ErrnoException, SocketException {
        return os.recvfrom(fd, buffer, flags, srcAddress);
    }

    /**
     *
     */
    public int recvfrom(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetSocketAddress srcAddress) throws ErrnoException, SocketException {
        return os.recvfrom(fd, bytes, byteOffset, byteCount, flags, srcAddress);
    }

    /**

    /**
     * Deletes a name from the filesystem.
     *
     * If the removed name was the last link to a file and no processes
     * have the file open, the file is deleted and the space it was
     * using is made available for reuse.
     *
     * If the name was the last link to a file, but any processes still
     * have the file open, the file will remain in existence until the
     * last file descriptor referring to it is closed.
     *
     * If the name referred to a symbolic link, the link is removed.
     *
     * If the name referred to a socket, FIFO, or device, the name is
     * removed, but processes which have the object open may continue to
     * use it.
     *
     * @see <a href="https://man7.org/linux/man-pages/man3/remove.3.html">remove(3)</a>.
     *
     * @param path file to delete
     * @throws ErrnoException if access to {@code path} is not allowed, an I/O error occurred.
     *                        See the full list of errors in the "See Also" list.
     *
     *
     */
    public void remove(String path) throws ErrnoException {
        os.remove(path);
    }

    /**
     *
     */

    public void removexattr(String path, String name) throws ErrnoException {
        os.removexattr(path, name);
    }

    /**
     * Renames a file, moving it between directories if required.
     *
     * @see <a href="https://man7.org/linux/man-pages/man2/rename.2.html">rename(2)</a>.
     *
     * @param oldPath file to be moved to a new location {@code newPath}
     * @param newPath destination to move file {@code oldPath}
     * @throws ErrnoException if write permission is denied for the directory containing
     *                        {@code oldPath} or {@code newPath}, or, search permission is denied for
     *                        one of the directories in the path prefix of {@code oldPath} or
     *                        {@code newPath}, or {@code oldPath} is a directory and does not allow
     *                        write permission. See the full list of errors in the "See Also" list.
     *
     *
     */
    public void rename(String oldPath, String newPath) throws ErrnoException {
        os.rename(oldPath, newPath);
    }

    /**
     *
     */
    public long sendfile(FileDescriptor outFd, FileDescriptor inFd, Int64Ref offset, long byteCount) throws ErrnoException {
        return os.sendfile(outFd, inFd, offset, byteCount);
    }


    public int sendto(FileDescriptor fd, ByteBuffer buffer, int flags, InetAddress inetAddress, int port) throws ErrnoException, SocketException {
        return os.sendto(fd, buffer, flags, inetAddress, port);
    }

    /**
     *
     */
    public int sendto(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetAddress inetAddress, int port) throws ErrnoException, SocketException {
        return os.sendto(fd, bytes, byteOffset, byteCount, flags, inetAddress, port);
    }

    /**
     *
     */
    public int sendto(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, SocketAddress address) throws ErrnoException, SocketException {
        return os.sendto(fd, bytes, byteOffset, byteCount, flags, address);
    }

    /**
     *
     */
    public void setegid(int egid) throws ErrnoException {
        os.setegid(egid);
    }

    /**
     *
     */

    public void setenv(String name, String value, boolean overwrite) throws ErrnoException {
        os.setenv(name, value, overwrite);
    }

    /**
     *
     */
    public void seteuid(int euid) throws ErrnoException {
        os.seteuid(euid);
    }

    /**
     *
     */
    public void setgid(int gid) throws ErrnoException {
        os.setgid(gid);
    }

    /**
     *
     */
    public void setpgid(int pid, int pgid) throws ErrnoException {
        os.setpgid(pid, pgid);
    }

    /**
     *
     */
    public void setregid(int rgid, int egid) throws ErrnoException {
        os.setregid(rgid, egid);
    }

    /**
     *
     */
    public void setreuid(int ruid, int euid) throws ErrnoException {
        os.setreuid(ruid, euid);
    }

    /**
     *
     */
    public int setsid() throws ErrnoException {
        return os.setsid();
    }

    /**
     *
     */
    public void setsockoptByte(FileDescriptor fd, int level, int option, int value) throws ErrnoException {
        os.setsockoptByte(fd, level, option, value);
    }

    /**
     *
     */
    public void setsockoptIfreq(FileDescriptor fd, int level, int option, String value) throws ErrnoException {
        os.setsockoptIfreq(fd, level, option, value);
    }

    /**
     *
     */
    public void setsockoptInt(FileDescriptor fd, int level, int option, int value) throws ErrnoException {
        os.setsockoptInt(fd, level, option, value);
    }

    /**
     *
     */
    public void setsockoptIpMreqn(FileDescriptor fd, int level, int option, int value) throws ErrnoException {
        os.setsockoptIpMreqn(fd, level, option, value);
    }

    public void setsockoptTimeval(FileDescriptor fd, int level, int option, StructTimeval value) throws ErrnoException {
        os.setsockoptTimeval(fd, level, option, value);
    }

    public void setuid(int uid) throws ErrnoException {
        os.setuid(uid);
    }

    public void setxattr(String path, String name, byte[] value, int flags) throws ErrnoException {
        os.setxattr(path, name, value, flags);
    }

    public void shutdown(FileDescriptor fd, int how) throws ErrnoException {
        os.shutdown(fd, how);
    }

    public FileDescriptor socket(int domain, int type, int protocol) throws ErrnoException {
        return os.socket(domain, type, protocol);
    }

    public void socketpair(int domain, int type, int protocol, FileDescriptor fd1, FileDescriptor fd2) throws ErrnoException {
        os.socketpair(domain, type, protocol, fd1, fd2);
    }

    public long splice(FileDescriptor fdIn, Int64Ref offIn, FileDescriptor fdOut, Int64Ref offOut, long len, int flags) throws ErrnoException {
        return os.splice(fdIn, offIn, fdOut, offOut, len, flags);
    }

    /**
     * Returns information about a file.
     *
     * @see <a href="https://man7.org/linux/man-pages/man2/lstat.2.html">stat(2)</a>.
     *
     * @param path path to file to get info about
     * @return {@link StructStat} containing information about the file
     * @throws ErrnoException See the full list of errors in the "See Also" list.
     *
     */
    public StructStat stat(String path) throws ErrnoException {
        return os.stat(path);
    }

    public StructStatVfs statvfs(String path) throws ErrnoException {
        return os.statvfs(path);
    }

    public String strerror(int errno) {
        return os.strerror(errno);
    }


    public String strsignal(int signal) {
        return os.strsignal(signal);
    }

    public void symlink(String oldPath, String newPath) throws ErrnoException {
        os.symlink(oldPath, newPath);
    }


    public long sysconf(int name) {
        return os.sysconf(name);
    }

    public void tcdrain(FileDescriptor fd) throws ErrnoException {
        os.tcdrain(fd);
    }

    public void tcsendbreak(FileDescriptor fd, int duration) throws ErrnoException {
        os.tcsendbreak(fd, duration);
    }

    public int umask(int mask) {
        return os.umask(mask);
    }

    public StructUtsname uname() {
        return os.uname();
    }

    /**
     * Deletes a name from the filesystem.
     *
     * If the removed name was the last link to a file and no processes
     * have the file open, the file is deleted and the space it was
     * using is made available for reuse.
     *
     * If the name was the last link to a file, but any processes still
     * have the file open, the file will remain in existence until the
     * last file descriptor referring to it is closed.
     *
     * If the name referred to a symbolic link, the link is removed.
     *
     * If the name referred to a socket, FIFO, or device, the name is
     * removed, but processes which have the object open may continue to
     * use it.
     *
     * @see <a href="https://man7.org/linux/man-pages/man2/unlink.2.html">unlink(2)</a>.
     *
     * @param pathname file to unlink
     * @throws ErrnoException if access to {@code pathname} is not allowed, an I/O error occurred.
     *                        See the full list of errors in the "See Also" list.
     *
     *
     */
    public void unlink(String pathname) throws ErrnoException {
        os.unlink(pathname);
    }


    public void unsetenv(String name) throws ErrnoException {
        os.unsetenv(name);
    }



    public int write(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException, InterruptedIOException {
        return os.write(fd, buffer);
    }

    public int write(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException, InterruptedIOException {
        return os.write(fd, bytes, byteOffset, byteCount);
    }

    public int writev(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException, InterruptedIOException {
        return os.writev(fd, buffers, offsets, byteCounts);
    }


    public String toString() {
        return "ForwardingOs{os=" + os + "}";
    }
}