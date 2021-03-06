package indi.key.mipsemulator.core.action;

import indi.key.mipsemulator.core.controller.Cpu;
import indi.key.mipsemulator.core.controller.Machine;
import indi.key.mipsemulator.core.model.Statement;
import indi.key.mipsemulator.storage.Memory;
import indi.key.mipsemulator.storage.Register;

public interface MemoryAction extends Action {
    void execute(Memory m, long address, Register rt);

    @Override
    default void execute(Machine m, Cpu c, Statement s) {
        execute(m.getAddressRedirector(), s.rsReg.getUnsigned() + s.immediate.integerValue(), s.rtReg);
    }
}
