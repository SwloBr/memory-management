package com.swlo.allocator;

import com.swlo.Memory;

public class BestFitAllocator extends MemoryAllocator {
    public BestFitAllocator(Memory memory) {
        super(memory);
    }

    @Override
    protected void allocate(com.swlo.Process process) {
        int bestIndex = -1;
        int smallestFit = Integer.MAX_VALUE;

        for (int i = 0; i <= memory.getState().length - process.getSize(); i++) {
            if (memory.canAllocate(i, process.getSize())) {
                int spaceLeft = getSpaceLeft(i);
                if (spaceLeft < smallestFit) {
                    smallestFit = spaceLeft;
                    bestIndex = i;
                }
            }
        }

        if (bestIndex != -1) {
            memory.allocate(bestIndex, process.getSize(), process.hashCode());
            System.out.println("Process " + process.getId() + " allocated at index " + bestIndex);
        } else {
            System.out.println("Process " + process.getId() + " could not be allocated.");
        }
    }

    private int getSpaceLeft(int startIndex) {
        int space = 0;
        for (int i = startIndex; i < memory.getState().length; i++) {
            if (memory.getState()[i] == 0) {
                space++;
            } else {
                break;
            }
        }
        return space;
    }
}