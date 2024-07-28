package co.wedevx.digitalbank.automation.ui.utils;

import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import java.util.*;

public class MockData {

    //It utilizes the JavaFaker library to create random names, email addresses, SSN, etc.

    private FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-US"), new RandomService());

    public Map<String, String> generateRandomNameAndEmail() {
        String name = fakeValuesService.bothify(new Faker().name().firstName());
        String email = fakeValuesService.bothify(name + "####@gmail.com");

        Map<String, String> data = new HashMap<>();
        data.put("name", name);
        data.put("email", email);
        return data;
    }

    public String generateSnn() {
        String ssn = String.format("%09d", new Random().nextInt(1000000000));
        return ssn;
    }

    public static void main(String[] args) {
        MockData mockData = new MockData();

        Map<String, String> data = mockData.generateRandomNameAndEmail();
        System.out.println(data.get("name"));
        System.out.println(data.get("email"));

        System.out.println(mockData.generateSnn());
    }
}
