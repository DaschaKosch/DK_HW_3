package testdata;

import net.datafaker.Faker;

public class TestData {
    private final Faker faker = new Faker();

    public final String firstName = faker.name().firstName();
    public final String lastName = faker.name().lastName();
    public final String email = faker.internet().emailAddress();
    public final String gender = faker.options().option("Male", "Female");
    public final String phone = faker.options().option("1234567890", "1243658790");
    public final String subject = faker.options().option("Chemistry", "Math", "History", "English");
    public final String hobby = faker.options().option("Music", "Sports", "Reading");
    public final String currentAddress = faker.address().fullAddress();
    public final String permanentAddress = faker.address().fullAddress();
    public final String state = faker.options().option("NCR");
    public final String city = faker.options().option("Delhi");
    public final String picture = faker.options().option("img.png");
    public final String day = String.valueOf(faker.number().numberBetween(1, 29));
    public final String month = faker.options().option("January", "February", "March", "April");
    public final String year = String.valueOf(faker.number().numberBetween(1990, 2005));

    public final String userName = faker.name().fullName();
    public final String userEmail = faker.internet().emailAddress();
    public final String negativeUserEmail = faker.options().option("not-an-email", "user@domain");
    public final String negativePhone = faker.options().option("123", "abc", "", "+", "12-34");

}