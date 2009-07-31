package mark.utils.ui;

import java.util.*;
import java.util.Map.Entry;

import javax.swing.text.JTextComponent;
import mark.utils.bean.Formatter;
import mark.utils.el.FieldResolver;

public class SimpleComponentBinder {

	private Map<JTextComponent, FieldResolver> map;

	public SimpleComponentBinder() {
		map = new HashMap<JTextComponent, FieldResolver>();
	}

	public void bind(JTextComponent comp, Class<?> clazz, String field,
			Formatter formatter) {
		bind(comp, new FieldResolver(clazz, field), formatter);
	}

	public void bind(JTextComponent comp, Class<?> clazz, String field) {
		bind(comp, new FieldResolver(clazz, field));
	}

	public void bind(JTextComponent comp, FieldResolver resolver) {
		bind(comp, resolver, resolver.getFormatter());
	}

	public void bind(JTextComponent comp, FieldResolver resolver,
			Formatter formatter) {
		resolver.setFormatter(formatter);
		map.put(comp, resolver);
	}

	public void updateView(Object obj) {
		JTextComponent comp;
		FieldResolver field;
		for (Entry<JTextComponent, FieldResolver> ent : map.entrySet()) {
			comp = ent.getKey();
			field = ent.getValue();
			comp.setText((String) field.getValue(obj));
		}
	}

	public void updateModel(Object obj) {
		JTextComponent comp;
		FieldResolver field;
		for (Entry<JTextComponent, FieldResolver> ent : map.entrySet()) {
			comp = ent.getKey();
			field = ent.getValue();
			field.setValue(obj, comp.getText());
		}
	}
}