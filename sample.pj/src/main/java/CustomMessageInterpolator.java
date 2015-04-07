import java.util.Locale;

import javax.validation.MessageInterpolator;

import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;

public class CustomMessageInterpolator implements MessageInterpolator {
	private Locale locale;
	private MessageInterpolator mi;

	public CustomMessageInterpolator(Locale locale) {
		this.locale = locale;
		this.mi = new ResourceBundleMessageInterpolator();
	}

	public String interpolate(String m, Context c) {
		return mi.interpolate(m, c, locale);
	}

	public String interpolate(String m, Context c, Locale l) {
		return mi.interpolate(m, c, locale);
	}
}