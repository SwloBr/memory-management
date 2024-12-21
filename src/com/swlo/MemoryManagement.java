package com.swlo;

import com.swlo.allocator.FirstFitAllocator;
import com.swlo.allocator.MemoryAllocator;

import java.util.Arrays;
import java.util.List;

public class MemoryManagement {
    public static void main(String[] args) {
        Memory memory = new Memory(32);

        List<Process> processes = Arrays.asList(
                new Process("P1", 5),
                new Process("P2", 4),
                new Process("P3", 2),
                new Process("P4", 5),
                new Process("P5", 8),
                new Process("P6", 3),
                new Process("P7", 5),
                new Process("P8", 8),
                new Process("P9", 2),
                new Process("P10", 6)
        );

        MemoryAllocator allocator = new FirstFitAllocator(memory);
        allocator.allocateProcesses(processes);
    }
}