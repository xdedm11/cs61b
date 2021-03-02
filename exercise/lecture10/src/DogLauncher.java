import java.util.Comparator;

public class DogLauncher {
    public static void main(String[] args) {
        Dog d1 = new Dog("Elyse", 3);
        Dog d2 = new Dog("Strure", 9);
        Dog[] dogs = {d1, d2};
        Dog maxDog = (Dog) Maximizer.max(dogs);
//        maxDog.bark();

        Comparator<Dog> nc = Dog.getNameComparator();
        if (nc.compare(d1, d2) > 0){
            d1.bark();
        }else {
            d2.bark();
        }
    }
}
