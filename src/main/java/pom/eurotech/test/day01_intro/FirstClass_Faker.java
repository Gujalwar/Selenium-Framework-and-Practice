package pom.eurotech.test.day01_intro;

import com.github.javafaker.Faker;

public class FirstClass_Faker {
    public static void main(String[] args) {
        Faker faker = new Faker();
        System.out.println("faker.animal().name() = " + faker.animal().name());
        System.out.println("faker.name().fullName() = " + faker.name().fullName());
        System.out.println("faker.address().city() = " + faker.address().city());
        System.out.println("faker.gameOfThrones().character() = " + faker.gameOfThrones().character());
        System.out.println("faker.number().digits(6) = " + faker.number().digits(6));
        System.out.println("faker.number().digit() = " + faker.number().digit());
        System.out.println("faker.address().country() = " + faker.address().country());

        for (int i = 1; i<=100;i++){
            System.out.println("faker.address().country() = " + faker.address().country());

        }
    }

}
