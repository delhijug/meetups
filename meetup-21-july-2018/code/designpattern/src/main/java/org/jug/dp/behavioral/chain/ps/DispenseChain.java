package org.jug.dp.behavioral.chain.ps;
public interface DispenseChain {
	void setNextChain(DispenseChain nextChain);
	void dispense(Currency cur);
}

