package com.swlo.allocator;

import com.swlo.Memory;

public class NextFitAllocator extends MemoryAllocator {
    private int lastIndex = 0;

    public NextFitAllocator(Memory memory) {
        super(memory);
    }

    @Override
    protected void allocate(com.swlo.Process process) {
        for (int i = lastIndex; i < memory.getState().length; i++) {
            if (memory.canAllocate(i, process.getSize())) {
                memory.allocate(i, process.getSize(), process.hashCode());
                lastIndex = i + process.getSize();
                System.out.println("Process " + process.getId() + " allocated at index " + i);
                return;
            }
        }
        for (int i = 0; i < lastIndex; i++) {
            if (memory.canAllocate(i, process.getSize())) {
                memory.allocate(i, process.getSize(), process.hashCode());
                lastIndex = i + process.getSize();
                System.out.println("Process " + process.getId() + " allocated at index " + i);
                return;
            }
        }
        System.out.println("Process " + process.getId() + " could not be allocated.");
    }
}