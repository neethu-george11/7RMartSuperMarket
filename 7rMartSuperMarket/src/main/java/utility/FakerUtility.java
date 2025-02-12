package utility;

import com.github.javafaker.Address;
import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;

public class FakerUtility {

	public String getFakeFirstName() {
		Faker faker = new Faker();
		Address address = faker.address();
		String text = address.firstName();
		return text;
	}

	public String getFakeLastName() {
		Faker faker = new Faker();
		Address address = faker.address();
		String text = address.lastName();
		return text;
	}

	public String getFakeCityName() {
		Faker faker = new Faker();
		Address address = faker.address();
		String text = address.cityName();
		return text;
	}

	public String getFakePassword() {
		Faker faker = new Faker();
		String password = faker.internet().password(8, 16, true, true, true);
		return password;

	}

	public String getFakePhoneNumber() {
		Faker faker = new Faker();
		// Generate a fake phone number
		PhoneNumber phoneNumber = faker.phoneNumber();
		String phone = phoneNumber.phoneNumber();

		return phone;
	}

}
