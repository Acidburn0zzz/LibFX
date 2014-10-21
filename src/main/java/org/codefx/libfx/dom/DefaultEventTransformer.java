package org.codefx.libfx.dom;

import java.util.Objects;

import javax.swing.event.HyperlinkEvent;

import org.w3c.dom.events.Event;

/**
 * Default implementation of {@link EventTransformer}.
 * <p>
 * This class is thread-safe, i.e. the provided methods can be called from different threads and concurrent executions
 * do not interfere with each other.
 */
public class DefaultEventTransformer implements EventTransformer {

	@Override
	public boolean canTransformToHyperlinkEvent(Event domEvent) {
		Objects.requireNonNull(domEvent, "The argument 'domEvent' must not be null.");

		Object source = "the source does not matter for this call";
		DomEventToHyperlinkEventTransformer transformer = new DomEventToHyperlinkEventTransformer(domEvent, source);
		return transformer.canTransform();
	}

	@Override
	public HyperlinkEvent transformToHyperlinkEvent(Event domEvent, Object source) throws IllegalArgumentException {
		DomEventToHyperlinkEventTransformer transformer = new DomEventToHyperlinkEventTransformer(domEvent, source);
		return transformer.transform();
	}

}