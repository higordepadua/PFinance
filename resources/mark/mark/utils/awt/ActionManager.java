package mark.utils.awt;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.AbstractButton;

public class ActionManager implements ActionListener {
	private List<Action> before, after;
	private Map<AbstractButton, Action> map;

	public ActionManager() {
		map = new HashMap<AbstractButton, Action>();
		before = new ArrayList<Action>();
		after = new ArrayList<Action>();
	}

	public void manage(AbstractButton source, Action action) {
		map.put(source, action);
		source.addActionListener(this);
	}

	public void doBefore(Action action) {
		before.add(action);
	}

	public void doAfter(Action action) {
		after.add(action);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		for (Action action : before)
			action.doAction();
		map.get(arg0.getSource()).doAction();
		for (Action action : after)
			action.doAction();
	}

	public interface Action {
		public void doAction();
	}
}
