import java.util.Arrays;

public class Lesson_1 {
    public static void main(String[] args) {
        /*Написать метод, который меняет два элемента массива местами.
        (массив может быть любого ссылочного типа);*/
        TestGeneric<Integer> intArray = new TestGeneric<>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(intArray);
        intArray.moveItems(1, 7);
        System.out.println(intArray);
        /*Написать метод, который преобразует массив в ArrayList;*/
        System.out.println("ArrayList= " + intArray.toList());
        /*a. Есть классы Fruit -> Apple, Orange;(больше фруктов не надо)
        b. Класс Box в который можно складывать фрукты, коробки условно сортируются
        по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
        c. Для хранения фруктов внутри коробки можете использовать ArrayList;
        d. Сделать метод getWeight() который высчитывает вес коробки, зная количество
        фруктов и вес одного фрукта(вес яблока - 1.0f, апельсина - 1.5f, не важно в каких это единицах);
        e. Внутри класса коробка сделать метод compare, который позволяет сравнить
        текущую коробку с той, которую подадут в compare в качестве параметра,
        true - если их веса равны, false в противном случае(коробки с яблоками мы
        можем сравнивать с коробками с апельсинами);
        f. Написать метод, который позволяет пересыпать фрукты из текущей коробки
        в другую коробку(помним про сортировку фруктов, нельзя яблоки высыпать в
        коробку с апельсинами), соответственно в текущей коробке фруктов не остается,
        а в другую перекидываются объекты, которые были в этой коробке;
        g. Не забываем про метод добавления фрукта в коробку.*/
        System.out.println("Создаем коробку с яблоками.");
        Box<Apple> appleBox = new Box<>();
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        System.out.println("appleBox= " + appleBox.getWeight());
        System.out.println("Создаем коробку с апельсинами.");
        Box<Orange> orangeBox = new Box<>();
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());
        System.out.println("orangeBox= " + orangeBox.getWeight());
        System.out.println("Сравниваем ящики по весу.");
        if (appleBox.compare(orangeBox)) {
            System.out.println("appleBox равен orangeBox по весу");
        } else {
            System.out.println("appleBox не равен orangeBox по весу");
        }
        System.out.println("Создаем коробку с яблоками №2.");
        Box<Apple> appleBox2 = new Box<>();
        appleBox2.add(new Apple());
        appleBox2.add(new Apple());
        System.out.println("appleBox2= " + appleBox2.getWeight());
        System.out.println("Пересыпаем яблоки из коробки 1 в 2.");
        appleBox.pour(appleBox2);
        System.out.println("appleBox1= " + appleBox.getWeight());
        System.out.println("appleBox2= " + appleBox2.getWeight());
    }


}
