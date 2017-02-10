/**
 * Created by sulu on 2/2/17.
 */

import java.lang.System;

public class GenericPhoneBookDemo {

    public static void main(String[] args) {

        String [] person_name = {"Tom", "Jack", "Alex", "Andy", "Jason", "Will"};
        Integer [] person_ssn = {984339090, 999345578, 43559223, 212337898, 77890321, 99023556};
        long [] phone_numbers = {7892456789L, 48956241267L, 4653192724L, 9337789455L, 9223668009L, 7154028889L};

        GenericPhoneBook<String> phonebook_1 = new GenericPhoneBook<>(person_name, phone_numbers);
        long phone_number_checked = phonebook_1.findPerson(person_name[4]);
        System.out.println(person_name[4] + "'s phone number: " + phone_number_checked);

        GenericPhoneBook<Integer> phonebook_2 = new GenericPhoneBook<>(person_ssn, phone_numbers);
        phone_number_checked = phonebook_2.findPerson(person_ssn[2]);
        System.out.println(person_ssn[2] + "'s phone number: " + phone_number_checked);

        phonebook_1.addPerson("Ben", 89756678440L, person_name, phone_numbers);

        phonebook_1.show_phone_book(person_name, phone_numbers);
//        phonebook_2.show_phone_book(person_ssn, phone_numbers);


//        return 0;
    }
}
