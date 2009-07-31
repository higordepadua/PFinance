package mark.utils.swing.scroll;

import java.awt.BorderLayout;
import java.awt.Component;
import java.util.List;

import javax.swing.JPanel;
import mark.utils.ui.SimpleComponentBinder;

public class ScrollablePanel<T> implements ScrollEventListener {
	private JPanel main;
	private JPanel panel;
	private SimpleComponentBinder binder;
	private ScrollBar<T> bar;

	public ScrollablePanel(String buttons) {
		binder = new SimpleComponentBinder();
		main = new JPanel();
		panel = new JPanel();
		bar = new ScrollBar<T>();
		bar.addScrollEventListener(this);
		main.setLayout(new BorderLayout());
		main.add(panel, BorderLayout.NORTH);
		main.add(bar, BorderLayout.SOUTH);

		String[] args = buttons.split("[\\[\\]]");
		for (String s : args)
			if (!s.isEmpty())
				bar.addScrollButton(new ScrollBar.ScrollButton(Integer
						.parseInt(s)));
	}

	public void setResults(List<T> list) {
		bar.setList(list);
	}

	public SimpleComponentBinder getBinder() {
		return binder;
	}

	public void add(Component comp, Object obj) {
		if (obj != null)
			panel.add(comp, obj);
		else
			panel.add(comp);
	}

	public JPanel getEditablePanel() {
		return panel;
	}

	public JPanel getContent() {
		return main;
	}

	@Override
	public void scrollPerformed(ScrollEvent event) {
		binder.updateView(event.getValue());
	}

}
