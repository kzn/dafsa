package name.kazennikov.fsa.walk;

import gnu.trove.list.array.TIntArrayList;
import name.kazennikov.fsa.Constants;

public class BaseWalkFSA {
	TIntArrayList src = new TIntArrayList();
	TIntArrayList dest = new TIntArrayList();
	TIntArrayList labels = new TIntArrayList();
	
	TIntArrayList stateStart = new TIntArrayList();
	TIntArrayList stateEnd = new TIntArrayList();
	
	int lastState = 0;
	
	public void addTransition(int src, int label, int dest) {
		this.src.add(src);
		this.dest.add(dest);
		this.labels.add(label);
		lastState = Math.max(lastState, Math.max(src, dest));
	}
	
	public int transitionCount() {
		return src.size();
	}
	
	public int stateCount() {
		return lastState + 1; // assuming that states are started from 0
	}
	
	public int next(int src, int input) {
		for(int i = stateStart.get(src); i < stateEnd.get(src); i++) {
			if(labels.get(i) == input)
				return dest.get(i);
		}
		
		return Constants.INVALID_STATE;
	}
	
	public int stateStart(int state) {
		return stateStart.get(state);
	}
	
	public int stateEnd(int state) {
		return stateEnd.get(state);
	}
	
	

}