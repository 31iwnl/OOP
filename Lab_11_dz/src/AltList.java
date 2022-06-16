public class AltList {
	private List head;
	private List tail;

	public AltList() {
		head = null;
		tail = null;
	}

	private boolean isEmpty() {
		return head == null;
	}

	public void addLast(String[] data) {
		List temp = new List(data);

		if (isEmpty()) {
			head = temp;
		} else {
			tail.next = temp;
		}

		temp.prev = tail;
		tail = temp;

	}

	public void removeFirst() {
		if (head.next == null) {
			tail = null;
		} else {
			head.next.prev = null;
		}
		head = head.next;

	}

	public void removeLast() {
		if (head.next == null) {
			head = null;
		} else {
			tail.prev.next = null;
		}
		tail = tail.prev;
	}

	public void remoteAt(String Name) {

		List cur = head;

		while (!(cur.data[1].equals(Name))) {
			cur = cur.next;

			if (cur == null) {
				return;
			}
		}

		if (cur == head) {
			removeFirst();
		} else {
			cur.prev.next = cur.next;
		}
		if (cur == tail) {
			removeLast();
		} else {
			if (cur.prev != null) {
				cur.next.prev = cur.prev;
			}
		}

	}

	public String print() {
		List temp = head;
		String MainText = "";

		while (temp != null) {
			for (int i = 0; i < 4; i++) {
				MainText += temp.data[i] + "\n";
			}
			MainText += "\n";
			temp = temp.next;
		}
		return MainText;
	}

	public String printName(String Name) {
		List temp = head;
		String MainText = "";
		while (temp != null) {
			if (temp.data[1].equals(Name)) {
				for (int i = 0; i < 4; i++) {
					MainText += temp.data[i] + "\n";
				}
				MainText += "\n";
				temp = temp.next;
			} else {
				temp = temp.next;
			}
		}
		return MainText;
	}

	public String prints() {
		List temp = tail;
		String MainText = "";
		while (temp != null) {
			for (int i = 0; i < 4; i++) {
				MainText += temp.data[i] + "\n";
			}
			MainText += "\n";
			temp = temp.prev;
		}
		return MainText;
	}
}
