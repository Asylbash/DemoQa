package com.demoqa.utils;

import com.demoqa.entities_polya_objects.Employee;
import com.demoqa.entities_polya_objects.NBWalletEntity;
import com.demoqa.entities_polya_objects.PracticeFormEntity;
import com.demoqa.entities_polya_objects.TextBoxEntity;
import com.demoqa.pages_raznye_stranicy_get.PracticeFormPage;
import com.github.javafaker.Faker;
<<<<<<< HEAD
=======

import java.io.File;
>>>>>>> refs/remotes/origin/main
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class RandomUtils {
    Faker faker = new Faker();
    Random random = new Random();
    String filePath = new File("src/main/resources/pictures/Jenkins.png").getAbsolutePath();

    public TextBoxEntity generateRandomTextBoxEntity() {
        TextBoxEntity textBoxEntity = new TextBoxEntity();
        textBoxEntity.setFullName(faker.name().fullName());
        textBoxEntity.setEmail(faker.internet().emailAddress());
        textBoxEntity.setCurrentAddress(faker.address().fullAddress());
        textBoxEntity.setPermanentAddress(faker.address().secondaryAddress());
        return textBoxEntity;
    }

    public PracticeFormEntity generateRandomPracticeFormEntity() {
        PracticeFormEntity practiceFormEntity = new PracticeFormEntity();
        practiceFormEntity.setFirstName(faker.name().firstName());
        practiceFormEntity.setLastName(faker.name().lastName());
        practiceFormEntity.setEmail(faker.internet().emailAddress());
        practiceFormEntity.setGender(randomGender());
        practiceFormEntity.setMobileNumber("3932067955");
//        practiceFormEntity.setSubject("m");
        practiceFormEntity.setSubjects(Arrays.asList("M", "P", "C")); // Пример списка предметов
        practiceFormEntity.setHobby(randomHobby());
        practiceFormEntity.setSelectPic(filePath);
        practiceFormEntity.setCurrentAddress(faker.address().fullAddress());
        practiceFormEntity.setState(randomState());
//        practiceFormEntity.setState("Raj");
        //  practiceFormEntity.setCity("Jaip");
        return practiceFormEntity;
    }

    private String randomGender() {
        List<String> genders = Arrays.asList("Male", "Female", "Other");
        return genders.get(random.nextInt(genders.size()));
    }

    private String randomHobby() {
        List<String> hobbies = Arrays.asList("Sports", "Reading", "Music");
        return hobbies.get(random.nextInt(hobbies.size()));
    }

    private String randomState() {
        PracticeFormPage practiceFormPage = new PracticeFormPage();
        List<String> states = practiceFormPage.getSelectStateOptions();
        return states.get(random.nextInt(states.size()));
    }

    public Employee createMockEmployee() {
        Employee employee = new Employee();
        employee.setFirstName(faker.name().firstName());
        employee.setLastName(faker.name().lastName());
        employee.setAge(faker.number().numberBetween(18, 100));
        // employee.setEmail("cierra@example.com");
        employee.setEmail(faker.internet().emailAddress());
        employee.setSalary(faker.number().numberBetween(100000, 20000000));
        employee.setDepartment(faker.job().position());
        return employee;
    }

    public NBWalletEntity createRandomNBWalletEntity() {
        NBWalletEntity nbWalletEntity = new NBWalletEntity();
        nbWalletEntity.setFirstName(faker.name().firstName());
        nbWalletEntity.setLastName(faker.name().firstName());
        nbWalletEntity.setEmail(faker.internet().emailAddress());
        nbWalletEntity.setPhoneNumber(faker.number().numberBetween(500000000, 700000000));
        nbWalletEntity.setSelectPic(filePath);
        nbWalletEntity.setPassword(faker.internet().password());
        return nbWalletEntity;
    }

}












