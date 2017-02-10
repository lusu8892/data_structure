import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by sulu on 2/2/17.
 */

public class GenericPhoneBook <AnyType extends Comparable<AnyType>> {

    GenericPhoneBook (AnyType [] input_id_array, long [] input_phone_number_array) {
        int num_item = input_id_array.length;
        person_id_array = (AnyType[]) new Comparable[phone_book_capacity];
        System.arraycopy(input_id_array, 0, person_id_array,0, num_item);

        phone_number_array = new long[phone_book_capacity];
        System.arraycopy(input_phone_number_array,0, phone_number_array, 0, num_item);
    }

    public long findPerson (AnyType person_wanted) {
//        long phone_number;
//
//        int low_bound = 0;
//        int high_bound = phone_book_capacity - 1;
//        int index;
//        while (low_bound <= high_bound) {
//            index = (int) Math.floor((low_bound + high_bound) / 2);
//
//            if (person_wanted.equals(person_id_array[index])) {
//                phone_number = phone_number_array[index];
//                return phone_number; // the wanted person's phone number FOUND
//            }
//            else {
//                if (person_wanted.compareTo(person_id_array[index]) < 0) {
//                    high_bound = index - 1;
//                }
//                else {
//                    low_bound = index + 1;
//                }
//            }
//        }
        int index = 0;
        while (index <= phone_book_capacity) {
            if (person_wanted.equals(person_id_array[index])) {
                return phone_number_array[index];
            } else {
                index++;
            }
        }

        System.out.println("The wanted person's phone number NOT FOUND");
        return 0; // the wanted person's phone number NOT FOUND
    }

    public boolean addPerson (AnyType person_added, long phone_number_added,
                              AnyType [] input_id_array, long [] input_phone_number_array) {

        int saved_num_item = input_id_array.length;
//        int num_item = person_id_array.length;
        if (saved_num_item == phone_book_capacity) {
            System.out.println("The phonebook's capacity is reached, no more room available");
            return false;
        }
        else {
            person_id_array[saved_num_item] = person_added;
            phone_number_array[saved_num_item] = phone_number_added;

            saved_num_item ++;
//            input_id_array. = (AnyType[]) new Comparable[saved_num_item];  // increase input_id_array length by 1
//            input_phone_number_array = new long[saved_num_item];

            input_id_array = Arrays.copyOf(input_id_array, input_id_array.length + 1);
            input_phone_number_array = Arrays.copyOf(input_phone_number_array, input_phone_number_array.length + 1);

            // copy person_id_array to input_id_array showing the new added person's ID
//            System.arraycopy(person_id_array,0,input_id_array,0, saved_num_item);
            // copy phone_number_array to input_phone_number_array showing the new added person's corresponding phone number
//            System.arraycopy(phone_number_array, 0, input_phone_number_array,0, saved_num_item);
            return true;
        }

    }
//
//    public boolean deletePerson () {
//
//    }

    public void show_phone_book (AnyType [] input_id_array, long [] input_phone_number_array) {
        for (int i = 0; i < input_id_array.length; i++) {
            System.out.println(input_id_array[i]);
            System.out.println(input_phone_number_array[i]);
        }
    }

    private AnyType[] person_id_array;
    private long [] phone_number_array;
    private int phone_book_capacity = 99;  // the variable to store the total length of phone book array
}
