package mark.utils.swing.scroll;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import mark.utils.collections.CollectionsUtil;
import mark.utils.collections.filter.Filter;

public class ScrollBar<T> extends JPanel {
	private List<T> list;
	private List<ScrollEventListener> listeners;
	private JLabel pageLabel;
	private List<ScrollButton> buttons;
	private T currentValue;
	private int currentIndex;

	public ScrollBar() {
		buttons = new ArrayList<ScrollButton>();
		listeners = new ArrayList<ScrollEventListener>();
		pageLabel = new JLabel();

		setBorder(new LineBorder(Color.BLACK, 1));
		setLayout(new FlowLayout());
	}

	public void setList(List<T> list) {
		this.list = list;
		updatePageLabelText();
		setValue(0);
	}

	private void updatePageLabelText() {
		int size = list.size();
		int length = String.valueOf(size).length();
		int cLength = String.valueOf(currentIndex + 1).length();
		int dif = length - cLength;
		String current = fillString('0', String.valueOf(currentIndex + 1), dif);
		pageLabel.setText(new StringBuilder(String.valueOf(current))
				.append("/").append(list.size()).toString());
	}

	private String fillString(char begin, String rest, int times) {
		char[] chars = new char[times];
		for (int i = 0; i < times; i++)
			chars[i] = begin;

		return new String(chars).concat(rest);
	}

	public void addScrollButton(ScrollButton button) {
		buttons.add(button);
		Collections.sort(buttons);
		placeButtons();
		ScrollBar<T>.ScrollButtonActionListener listener = new ScrollButtonActionListener(
				button);
		button.addActionListener(listener);
	}

	private void placeButtons() {
		int index = CollectionsUtil.firstIndexOf(buttons,
				new Filter<ScrollButton>() {
					@Override
					public boolean accept(ScrollButton obj) {
						return obj.value > 0;
					}

				});
		for (int i = 0; i < buttons.size(); i++) {
			if (i == index)
				add(pageLabel);

			add(buttons.get(i));
		}
		revalidate();
	}

	public void setValue(int index) {
		if (index < 0)
			index = 0;
		if (index >= list.size())
			index = list.size() - 1;
		currentIndex = index;
		currentValue = list.get(index);
		updatePageLabelText();
	}

	public void addScrollEventListener(ScrollEventListener listener) {
		listeners.add(listener);
	}

	public void fireScrollEvent() {
		ScrollEvent event = new ScrollEvent(currentValue, this);
		for (ScrollEventListener listener : listeners)
			listener.scrollPerformed(event);
	}

	public static class ScrollButton extends JButton implements
			Comparable<ScrollButton> {
		private int value;

		public ScrollButton(int value) {
			this.value = value;
			super.setBorder(null);
		}

		@Override
		public void setBorder(Border border) {
		}

		@Override
		public String getText() {
			String s = "";
			if (value > 0)
				s = "+";
			return s + Integer.toString(value);
		}

		@Override
		public int compareTo(ScrollButton arg0) {
			return value - arg0.value;
		}

	}

	public T getCurrentValue() {
		return currentValue;
	}

	private class ScrollButtonActionListener implements ActionListener {
		private ScrollButton button;

		public ScrollButtonActionListener(ScrollButton button) {
			this.button = button;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			setValue(currentIndex + button.value);
			fireScrollEvent();
		}

	}

}
