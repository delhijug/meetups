package org.jug.oops.ps;
class StackImpUsingArray implements Stack {
	private int x[];
	private final int SIZE;
	private int top;
	
	public StackImpUsingArray(int size) {
		this.SIZE=size;
		x=new int[SIZE];
		top=-1;
		
	}
	
	
	/* (non-Javadoc)
	 * @see org.jug.oops.ps.Stack#push(int)
	 */
	@Override
	public void push(int element){
		if(top==SIZE-1)
			return ;
		else
			x[++top]=element;
	}
	
	
	/* (non-Javadoc)
	 * @see org.jug.oops.ps.Stack#pop()
	 */
	@Override
	public int pop(){
		if(top==-1)
			return -99;
		else
			return x[top--];
	}
}
