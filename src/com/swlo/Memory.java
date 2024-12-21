package com.swlo;


public class Memory {
    private final int[] memory;

    public Memory(int size) {
        this.memory = new int[size];
    }

    public int[] getState() {
        return memory;
    }

    public boolean canAllocate(int startIndex, int size) {
        for (int i = startIndex; i < startIndex + size; i++) {
            if (i >= memory.length || memory[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public void allocate(int startIndex, int size, int processId) {
        for (int i = startIndex; i < startIndex + size; i++) {
            memory[i] = processId;
        }
    }

    public void deallocate(int processId) {
        for (int i = 0; i < memory.length; i++) {
            if (memory[i] == processId) {
                memory[i] = 0;
            }
        }
    }

    public void printState() {
        System.out.print("Memory State: [");
        for (int i = 0; i < memory.length; i++) {
            System.out.print(memory[i] == 0 ? "0" : "1");
            if (i < memory.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}