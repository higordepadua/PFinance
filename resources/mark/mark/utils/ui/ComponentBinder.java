package mark.utils.ui;

import java.util.Map.Entry;

import javax.swing.text.JTextComponent;
import mark.utils.bean.Formatter;
import mark.utils.el.FieldResolver;
import mark.utils.map.MappedMap;

public class ComponentBinder {
	private MappedMap<Class<?>, JTextComponent, FieldResolver> mMap;

	public ComponentBinder() {
		mMap = new MappedMap<Class<?>, JTextComponent, FieldResolver>();
	}

	public void bind(JTextComponent comp, Class<?> clazz, String field,
			Formatter formatter) {
		bind(comp, new FieldResolver(clazz, field), formatter);
	}

	public void bind(JTextComponent comp, Class<?> clazz, String field) {
		bind(comp, new FieldResolver(clazz, field));
	}

	public void bind(JTextComponent comp, FieldResolver resolver) {
		bind(comp, resolver, new FieldResolver.BasicFormatter());
	}

	public void bind(JTextComponent comp, FieldResolver resolver,
			Formatter formatter) {
		resolver.setFormatter(formatter);
		mMap.put(resolver.getOwnerClass(), comp, resolver);
	}

	public void updateView(Object... objs) {
		JTextComponent comp;
		FieldResolver field;
		for (Class<?> clazz : mMap.getKeys()) {
			Object obj = getCompatible(objs, clazz);
			for (Entry<JTextComponent, FieldResolver> ent : mMap.getMap(clazz)
					.entrySet()) {
				comp = ent.getKey();
				field = ent.getValue();
				comp.setText((String) field.getValue(obj));
			}
		}
	}

	private Object getCompatible(Object[] objs, Class<?> clazz) {
		for (Object obj : objs)
			if (clazz.isInstance(obj))
				return obj;
		return null;
	}

	public void updateModel(Object... objs) {
		JTextComponent comp;
		FieldResolver field;

		for (Class<?> clazz : mMap.getKeys()) {
			Object obj = getCompatible(objs, clazz);
			for (Entry<JTextComponent, FieldResolver> ent : mMap.getMap(clazz)
					.entrySet()) {
				comp = ent.getKey();
				field = ent.getValue();
				field.setValue(obj, comp.getText());
			}
		}
	}
}