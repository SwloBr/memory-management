package com.swlo.allocator;

import com.swlo.Memory;
import com.swlo.Process;

import java.util.List;
import java.util.Random;

public abstract class MemoryAllocator {
    protected final Memory memory;

    public MemoryAllocator(Memory memory) {
        this.memory = memory;
    }

    public void allocateProcesses(List<com.swlo.Process> processes) {
        Random random = new Random();

        for (int i = 0; i < 30; i++) {
            com.swlo.Process process = processes.get(random.nextInt(processes.size()));

            if (!isProcessInMemory(process)) {
                allocate(process);
            } else {
                deallocateProcess(process);
            }

            memory.printState();
        }
    }

    protected abstract void allocate(com.swlo.Process process);

    protected void deallocateProcess(com.swlo.Process process) {
        memory.deallocate(process.hashCode());
        System.out.println("Process " + process.getId() + " deallocated.");
    }

    protected boolean isProcessInMemory(Process process) {
        int processHash = process.hashCode();
        for (int value : memory.getState()) {
            if (value == processHash) {
                return true;
            }
        }
        return false;
    }
}
