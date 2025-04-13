package actividad;

import java.util.ArrayList;
import java.util.List;
public class Limits {
	int[] array;
	int start;
	int end;
	public Limits(int[] array, int start, int end) {
		this.array = array;
		this.start = start;
		this.end = end;
	}
	public int length() {
		return end - start + 1;
	}
}
class SetVectors {
	private List<Limits> subconjuntos = new ArrayList<>();
	public void insertar(Limits p) {
		subconjuntos.add(p);
	}
	public Limits mayor() {
		Limits max = subconjuntos.get(0);
		for (Limits l : subconjuntos) {
			if (l.length() > max.length()) {
				max = l;
			}
		}
		subconjuntos.remove(max);
		return max;
	}
	public int longitudMayor() {
		if (subconjuntos.isEmpty()) return 0;
		int maxLen = 0;
		for (Limits l : subconjuntos) {
			if (l.length() > maxLen) {
				maxLen = l.length();
			}
		}
		return maxLen;
	}
	public boolean estaVacio() {
		return subconjuntos.isEmpty();
	}
	public void destruir() {
		subconjuntos.clear();
	}
}
