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

import java.io.FileDescriptor;
import java.io.InterruptedIOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.nio.ByteBuffer;


/**
 * Informs BlockGuard of any activity it should be aware of.
 */
public class BlockGuardOs extends ForwardingOs {
    public BlockGuardOs(Os os) {
        super(os);
    }

    private FileDescriptor tagSocket(FileDescriptor fd) throws ErrnoException {
        throw new RuntimeException("Stub!");
    }

    @Override
    public FileDescriptor accept(FileDescriptor fd, SocketAddress peerAddress) throws ErrnoException, SocketException {
        throw new RuntimeException("Stub!");
    }

    @Override
    public boolean access(String path, int mode) throws ErrnoException {
        throw new RuntimeException("Stub!");
    }

    @Override
    public void chmod(String path, int mode) throws ErrnoException {
    }

    @Override
    public void chown(String path, int uid, int gid) throws ErrnoException {
    }

    @Override
    public void close(FileDescriptor fd) throws ErrnoException {
        throw new RuntimeException("Stub!");
    }

    private static boolean isInetSocket(FileDescriptor fd) throws ErrnoException {
        throw new RuntimeException("Stub!");
    }

    private static boolean isInetDomain(int domain) {
        throw new RuntimeException("Stub!");
    }

    private static boolean isLingerSocket(FileDescriptor fd) throws ErrnoException {
        throw new RuntimeException("Stub!");
    }

    @Override
    public void connect(FileDescriptor fd, InetAddress address, int port) throws ErrnoException, SocketException {

    }

    @Override
    public void connect(FileDescriptor fd, SocketAddress address) throws ErrnoException,
            SocketException {

    }

    @Override
    public void fchmod(FileDescriptor fd, int mode) throws ErrnoException {

    }

    @Override
    public void fchown(FileDescriptor fd, int uid, int gid) throws ErrnoException {

    }

    // TODO: Untag newFd when needed for dup2(FileDescriptor oldFd, int newFd)

    @Override
    public void fdatasync(FileDescriptor fd) throws ErrnoException {

    }

    @Override
    public StructStat fstat(FileDescriptor fd) throws ErrnoException {
        throw new RuntimeException("Stub!");
    }

    @Override
    public StructStatVfs fstatvfs(FileDescriptor fd) throws ErrnoException {
        throw new RuntimeException("Stub!");
    }

    @Override
    public void fsync(FileDescriptor fd) throws ErrnoException {
    }

    @Override
    public void ftruncate(FileDescriptor fd, long length) throws ErrnoException {

    }

    @Override
    public void lchown(String path, int uid, int gid) throws ErrnoException {

    }

    @Override
    public void link(String oldPath, String newPath) throws ErrnoException {

    }

    @Override
    public long lseek(FileDescriptor fd, long offset, int whence) throws ErrnoException {
        throw new RuntimeException("Stub!");
    }

    @Override
    public StructStat lstat(String path) throws ErrnoException {
        throw new RuntimeException("Stub!");
    }

    @Override
    public void mkdir(String path, int mode) throws ErrnoException {

    }

    @Override
    public void mkfifo(String path, int mode) throws ErrnoException {

    }

    @Override
    public FileDescriptor open(String path, int flags, int mode) throws ErrnoException {
        throw new RuntimeException("Stub!");
    }

    @Override
    public int poll(StructPollfd[] fds, int timeoutMs) throws ErrnoException {
        throw new RuntimeException("Stub!");
    }

    @Override
    public void posix_fallocate(FileDescriptor fd, long offset, long length) throws ErrnoException {

    }

    @Override
    public int pread(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException, InterruptedIOException {
        throw new RuntimeException("Stub!");
    }

    @Override
    public int pread(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException, InterruptedIOException {
        throw new RuntimeException("Stub!");
    }

    @Override
    public int pwrite(FileDescriptor fd, ByteBuffer buffer, long offset) throws ErrnoException, InterruptedIOException {
        throw new RuntimeException("Stub!");
    }

    @Override
    public int pwrite(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, long offset) throws ErrnoException, InterruptedIOException {
        throw new RuntimeException("Stub!");
    }

    @Override
    public int read(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException, InterruptedIOException {
        throw new RuntimeException("Stub!");
    }

    @Override
    public int read(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException, InterruptedIOException {
        throw new RuntimeException("Stub!");
    }

    @Override
    public String readlink(String path) throws ErrnoException {
        throw new RuntimeException("Stub!");
    }

    @Override
    public String realpath(String path) throws ErrnoException {
        throw new RuntimeException("Stub!");
    }

    @Override
    public int readv(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException, InterruptedIOException {
        throw new RuntimeException("Stub!");
    }

    @Override
    public int recvfrom(FileDescriptor fd, ByteBuffer buffer, int flags, InetSocketAddress srcAddress) throws ErrnoException, SocketException {
        throw new RuntimeException("Stub!");
    }

    @Override
    public int recvfrom(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetSocketAddress srcAddress) throws ErrnoException, SocketException {
        throw new RuntimeException("Stub!");
    }

    @Override
    public void remove(String path) throws ErrnoException {

    }

    @Override
    public void rename(String oldPath, String newPath) throws ErrnoException {

    }

    @Override
    public long sendfile(FileDescriptor outFd, FileDescriptor inFd, Int64Ref offset, long byteCount) throws ErrnoException {
        throw new RuntimeException("Stub!");
    }

    @Override
    public int sendto(FileDescriptor fd, ByteBuffer buffer, int flags, InetAddress inetAddress, int port) throws ErrnoException, SocketException {
        throw new RuntimeException("Stub!");
    }

    @Override
    public int sendto(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount, int flags, InetAddress inetAddress, int port) throws ErrnoException, SocketException {
        throw new RuntimeException("Stub!");
    }

    @Override
    public FileDescriptor socket(int domain, int type, int protocol) throws ErrnoException {
        throw new RuntimeException("Stub!");
    }

    @Override
    public void socketpair(int domain, int type, int protocol, FileDescriptor fd1, FileDescriptor fd2) throws ErrnoException {

    }

    @Override
    public StructStat stat(String path) throws ErrnoException {
        throw new RuntimeException("Stub!");
    }

    @Override
    public StructStatVfs statvfs(String path) throws ErrnoException {
        throw new RuntimeException("Stub!");
    }

    @Override
    public void symlink(String oldPath, String newPath) throws ErrnoException {

    }

    @Override
    public int write(FileDescriptor fd, ByteBuffer buffer) throws ErrnoException, InterruptedIOException {
        throw new RuntimeException("Stub!");
    }

    @Override
    public int write(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount) throws ErrnoException, InterruptedIOException {
        throw new RuntimeException("Stub!");
    }

    @Override
    public int writev(FileDescriptor fd, Object[] buffers, int[] offsets, int[] byteCounts) throws ErrnoException, InterruptedIOException {
        throw new RuntimeException("Stub!");
    }

    @Override
    public void execv(String filename, String[] argv) throws ErrnoException {
        throw new RuntimeException("Stub!");
    }

    @Override
    public void execve(String filename, String[] argv, String[] envp)
            throws ErrnoException {
        throw new RuntimeException("Stub!");
    }

    @Override
    public byte[] getxattr(String path, String name) throws ErrnoException {
        throw new RuntimeException("Stub!");
    }

    @Override
    public void msync(long address, long byteCount, int flags) throws ErrnoException {
        throw new RuntimeException("Stub!");
    }

    @Override
    public void removexattr(String path, String name) throws ErrnoException {
        throw new RuntimeException("Stub!");
    }

    @Override
    public void setxattr(String path, String name, byte[] value, int flags)
            throws ErrnoException {
        throw new RuntimeException("Stub!");
    }

    @Override
    public int sendto(FileDescriptor fd, byte[] bytes, int byteOffset, int byteCount,
                      int flags, SocketAddress address) throws ErrnoException, SocketException {
        throw new RuntimeException("Stub!");
    }

    @Override
    public void unlink(String pathname) throws ErrnoException {
        throw new RuntimeException("Stub!");
    }

    @Override
    public long splice(FileDescriptor fdIn, Int64Ref offIn, FileDescriptor fdOut, Int64Ref offOut, long len, int flags) throws ErrnoException {
        throw new RuntimeException("Stub!");
    }
}