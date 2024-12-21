package com.swlo.allocator;

import com.swlo.Memory;

public class FirstFitAllocator extends MemoryAllocator {
    public FirstFitAllocator(Memory memory) {
        super(memory);
    }


    @Override
    protected void allocate(com.swlo.Process process) {
        for (int i = 0; i <= memory.getState().length - process.getSize(); i++) {
            if (memory.canAllocate(i, process.getSize())) {
                memory.allocate(i, process.getSize(), process.hashCode());
                System.out.println("Process " + process.getId() + " allocated at index " + i);
                return;
            }
        }
        System.out.println("Process " + process.getId() + " could not be allocated.");

    }
}