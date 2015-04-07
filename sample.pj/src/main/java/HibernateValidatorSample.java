import java.util.Locale;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Range;

class Car {
	@NotNull
	public String name;

	@Range(min = 1, max = 10)
	public int weight;
};

public class HibernateValidatorSample {

	public static void main(String[] args) {
		Car car = new Car();
		car.weight = 0;
		car.name = null;
		Validator validator = Validation.byDefaultProvider().configure().messageInterpolator
				(new CustomMessageInterpolator(Locale.ENGLISH)).buildValidatorFactory().getValidator();
		Set<ConstraintViolation<Car>> violations = validator.validate(car);

		if(violations.size() > 0){
			for (ConstraintViolation<Car> violation : violations) {
				System.out.println(violation.getMessage());
			}
		}
	}
}
