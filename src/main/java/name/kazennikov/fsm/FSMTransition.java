package name.kazennikov.fsm;

public class FSMTransition<E> {
	/**
	 * Encoding:
	 * <ul>
	 * <li> label > 0 - AnnotationMatcher table lookup
	 * <li> label = 0 - epsilon
	 * <li> label = -1 - GROUP_START
	 * <li> label < -1 - named group lookup
	 */
	FSMState<E> src;
	int label;
	FSMState<E> dest;
	
	public FSMTransition(FSMState<E> src, int label, FSMState<E> dest) {
		this.src = src;
		this.label = label;
		this.dest = dest;
	}
	
	
	public FSMState<E> getSrc() {
		return src;
	}
	
	public FSMState<E> getDest() {
		return dest;
	}
	
	public int getLabel() {
		return label;
	}
	
	public boolean isEpsilon() {
		return label == Constants.EPSILON;
	}
	
	@Override
	public String toString() {
		return String.format("{src=%d, label=%d, dest=%d}", src.getNumber(), label, dest.getNumber());
	}
	

}